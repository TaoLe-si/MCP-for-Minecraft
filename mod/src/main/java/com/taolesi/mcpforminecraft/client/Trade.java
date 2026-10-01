package com.taolesi.mcpforminecraft.client;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ServerboundSelectTradePacket;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 村民（和流浪商人）交易。
 *
 * <p>核心事实：**点一下交易按钮不是只发一个包**。原版
 * {@code MerchantScreen#postButtonClick()}（`:55`）做的是三件事，一件都不能少：
 * <pre>
 *   this.menu.setSelectionHint(shopItem);                        // 1. 本地标记选中的是第几个
 *   this.menu.tryMoveItems(shopItem);                            // 2. 把付款物品从背包挪进付款槽
 *   this.connection.send(new ServerboundSelectTradePacket(...)); // 3. 告诉服务端选了哪个
 * </pre>
 * 少了第 2 步，付款槽是空的，点结果槽什么也不会发生 —— 这种"看着像没反应"的问题，
 * 光看 {@code handleInventoryMouseClick} 是查不出来的。
 *
 * <p>之后还要点**结果槽**（{@code MerchantMenu} 里索引是 **2**，见
 * {@code MerchantMenu:42} 的 {@code MerchantResultSlot}）才算真正成交。
 */
public final class Trade {
    /** {@code MerchantMenu} 里结果槽的下标（付款槽是 0、1，结果槽是 2）。 */
    private static final int RESULT_SLOT = 2;

    private Trade() {
    }

    private static MerchantMenu requireMenu(Minecraft mc) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        if (!(player.containerMenu instanceof MerchantMenu menu)) {
            throw new IllegalStateException("现在开的不是交易界面（当前是 "
                    + player.containerMenu.getClass().getSimpleName()
                    + "）。先找个村民右键打开它。");
        }
        return menu;
    }

    /** 列出这个商人现在能给的所有交易。 */
    static JsonObject trades(Minecraft mc, JsonObject args) {
        MerchantMenu menu = requireMenu(mc);
        JsonArray out = new JsonArray();
        int index = 0;
        for (MerchantOffer offer : menu.getOffers()) {
            JsonObject o = new JsonObject();
            o.addProperty("index", index++);
            o.add("costA", stack(offer.getCostA()));
            o.add("costB", stack(offer.getCostB()));
            o.add("result", stack(offer.getResult()));
            o.addProperty("uses", offer.getUses());
            o.addProperty("maxUses", offer.getMaxUses());
            o.addProperty("outOfStock", offer.isOutOfStock());
            o.addProperty("rewardExp", offer.shouldRewardExp());
            out.add(o);
        }
        JsonObject o = new JsonObject();
        o.add("trades", out);
        o.addProperty("count", out.size());
        o.addProperty("traderLevel", menu.getTraderLevel());
        o.addProperty("traderXp", menu.getTraderXp());
        o.addProperty("canRestock", menu.canRestock());
        o.addProperty("hint", "成交要两步：先 trade{index} 选中，它会顺带把付款物品挪进槽位");
        return o;
    }

    /**
     * 选一笔交易并成交。
     *
     * <p>给 {@code index} 就选那笔并直接点结果槽；只给 {@code selectOnly} 就只选中不成交
     * （调试用）。
     */
    static JsonObject trade(Minecraft mc, JsonObject args) {
        MerchantMenu menu = requireMenu(mc);
        LocalPlayer player = InputOverride.requireWorld(mc);
        int index = args.has("index") ? args.get("index").getAsInt() : 0;
        int count = args.has("count") ? Math.max(1, args.get("count").getAsInt()) : 1;
        if (index < 0 || index >= menu.getOffers().size()) {
            throw new IllegalArgumentException("这个商人只有 " + menu.getOffers().size()
                    + " 笔交易，没有第 " + index + " 笔（用 trades 看清单）");
        }
        MerchantOffer offer = menu.getOffers().get(index);
        if (offer.isOutOfStock()) {
            throw new IllegalStateException("第 " + index + " 笔交易已经用完了（outOfStock）");
        }

        JsonObject before = Observation.of(mc);
        JsonObject extra = new JsonObject();
        extra.addProperty("index", index);
        extra.add("offer", stack(offer.getResult()));

        // 1+2：本地选中 + 把付款物品挪进付款槽（原版 postButtonClick 的前两步）
        menu.setSelectionHint(index);
        menu.tryMoveItems(index);
        // 3：告诉服务端选了哪一笔
        if (mc.getConnection() != null) {
            mc.getConnection().send(new ServerboundSelectTradePacket(index));
        }
        Journal.event("op", "trade 选中第 " + index + " 笔");

        boolean selectOnly = args.has("selectOnly") && args.get("selectOnly").getAsBoolean();
        if (selectOnly) {
            extra.addProperty("traded", false);
            extra.addProperty("note", "只选中没成交");
            return Observation.pair(before, Observation.of(mc), extra);
        }

        // 点结果槽才真的成交。
        //
        // 这里必须用 **QUICK_MOVE（Shift+左键）**，不能用 PICKUP：
        // PICKUP 点结果槽是把产物放到**光标上**（carried item），不进背包 ——
        // 实测踩过：成交了、绿宝石扣了、麦包一个没进背包，因为它在光标上挂着。
        // Shift+左键才是"直接塞进背包"（服务端 `MerchantMenu.quickMoveStack` 里针对
        // 结果槽走的就是成交那条路）。
        // 注意：一次 QUICK_MOVE **可能成交不止一次** —— 付款物品够的话，原版会把
        // 结果槽里能换的都换掉（实测一次点击把 8 个绿宝石全换成 24 个面包）。
        // 所以次数要按 `uses` 的增量算，不能按"点了几次"算。
        int usesBefore = offer.getUses();
        for (int i = 0; i < count; i++) {
            mc.gameMode.handleInventoryMouseClick(menu.containerId, RESULT_SLOT, 0,
                    ClickType.QUICK_MOVE, player);
        }
        int done = offer.getUses() - usesBefore;
        Journal.event("op", "trade 成交 " + done + " 次");

        // 付款槽里可能还剩着东西（`tryMoveItems` 是把**整叠**挪进去的，不是只挪一份），
        // 如实报出来：关界面时原版会把它们还回背包（`MerchantMenu.removed()`）。
        JsonObject payment = new JsonObject();
        for (int i = 0; i < RESULT_SLOT; i++) {
            ItemStack left = menu.slots.get(i).getItem();
            if (!left.isEmpty()) {
                payment.add(String.valueOf(i), stack(left));
            }
        }
        extra.addProperty("traded", done > 0);
        extra.addProperty("times", done);
        extra.addProperty("usesLeft", offer.getMaxUses() - offer.getUses());
        extra.add("paymentLeftInSlots", payment);
        extra.addProperty("note", "结果是服务端裁决的；成交几次就用抢几次 QUICK_MOVE。"
                + "付款槽可能还剩（tryMoveItems 挪的是整叠），关界面时原版会还回背包。"
                + "产物进的是背包 —— 用 inventory 回读确认。");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    private static JsonObject stack(ItemStack stack) {
        JsonObject o = new JsonObject();
        if (stack.isEmpty()) {
            o.addProperty("item", "minecraft:air");
            o.addProperty("count", 0);
            return o;
        }
        o.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
        o.addProperty("count", stack.getCount());
        if (stack.hasCustomHoverName()) {
            o.addProperty("name", stack.getHoverName().getString());
        }
        return o;
    }
}
