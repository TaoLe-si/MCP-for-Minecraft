package com.taolesi.mcpforminecraft.client;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 动作面的纵深：`Blocks` 管方块，这里管"人还能做的其余事" —— 对实体动手、
 * 配方书一键合成、容器按钮、创造栏取物、松弓、丢东西、睡觉、上下载具……
 *
 * <p>全部走 {@code MultiPlayerGameMode} 上对应的方法，也就是原版鼠标/按键最终落到的那几个；
 * 不直接改世界，服务端会裁决。
 */
public final class Actions {
    private Actions() {
    }

    /** 对实体右键：喂食、剪毛、挤奶、交易、上船、给盔甲架穿装备…… */
    static JsonObject useOnEntity(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        Entity target = requireEntity(mc, args);
        InteractionHand hand = readHand(args);
        JsonObject before = Observation.of(mc);
        player.swing(hand);
        InteractionResult result = mc.gameMode.interact(player, target, hand);
        String type = ForgeRegistries.ENTITY_TYPES.getKey(target.getType()).toString();
        Journal.event("op", "useOnEntity " + type + " → " + result);
        return Observation.pair(before, Observation.of(mc), entityExtra(target, result, hand));
    }

    /**
     * 在实体上的**具体位置**右键（盔甲架摆姿势、展示框转物品、点名某个体素）。
     * 不给坐标就打实体包围盒中心。
     */
    static JsonObject useOnEntityAt(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        Entity target = requireEntity(mc, args);
        InteractionHand hand = readHand(args);
        var box = target.getBoundingBox();
        double x = args.has("x") ? args.get("x").getAsDouble() : box.getCenter().x;
        double y = args.has("y") ? args.get("y").getAsDouble() : box.getCenter().y;
        double z = args.has("z") ? args.get("z").getAsDouble() : box.getCenter().z;

        JsonObject before = Observation.of(mc);
        player.swing(hand);
        InteractionResult result = mc.gameMode.interactAt(player, target,
                new EntityHitResult(target, new net.minecraft.world.phys.Vec3(x, y, z)), hand);
        Journal.event("op", "useOnEntityAt #" + target.getId() + " → " + result);
        return Observation.pair(before, Observation.of(mc), entityExtra(target, result, hand));
    }

    private static JsonObject entityExtra(Entity target, InteractionResult result,
                                          InteractionHand hand) {
        JsonObject extra = new JsonObject();
        extra.addProperty("targetId", target.getId());
        extra.addProperty("targetType",
                ForgeRegistries.ENTITY_TYPES.getKey(target.getType()).toString());
        extra.addProperty("hand", hand.name().toLowerCase());
        extra.addProperty("consumed", result.consumesAction());
        extra.addProperty("result", String.valueOf(result));
        return extra;
    }

    private static Entity requireEntity(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        if (!args.has("entityId")) {
            throw new IllegalArgumentException("要指定 entityId（先用 entities 拿）");
        }
        int id = args.get("entityId").getAsInt();
        Entity e = player.level().getEntity(id);
        if (e == null) {
            throw new IllegalStateException("附近没有 id=" + id + " 的实体");
        }
        return e;
    }

    private static InteractionHand readHand(JsonObject args) {
        return args.has("hand") && "off".equalsIgnoreCase(args.get("hand").getAsString())
                ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
    }

    // ------------------------------------------------------------------ 配方书 / 创造栏

    /**
     * 配方书一键合成（就像在配方书里点一下那个配方）。
     *
     * <p>三种指定方式：`recipeId`（精确）、`result`（按产物物品名子串找第一个）、
     * `index`（配方书展开列表里的序号）。都在**当前打开的容器**里合成，所以
     * 得先开着合成台/背包。
     *
     * <p>这条是服务端裁决的：回包只代表"请求发出去了"，产物要下一拍才出现。
     */
    static JsonObject placeRecipe(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        boolean all = !args.has("all") || args.get("all").getAsBoolean();

        List<Recipe<?>> candidates = recipeCandidates(mc);
        Recipe<?> picked = null;
        if (args.has("recipeId")) {
            String want = args.get("recipeId").getAsString();
            for (Recipe<?> recipe : candidates) {
                if (recipeId(mc, recipe).equals(want)) {
                    picked = recipe;
                    break;
                }
            }
        } else if (args.has("result")) {
            String want = args.get("result").getAsString().toLowerCase();
            for (Recipe<?> recipe : candidates) {
                String result = resultId(mc, recipe);
                if (result.contains(want)) {
                    picked = recipe;
                    break;
                }
            }
        } else if (args.has("index")) {
            int index = args.get("index").getAsInt();
            if (index < 0 || index >= candidates.size()) {
                throw new IllegalArgumentException("配方书里只有 " + candidates.size()
                        + " 个可选配方，没有序号 " + index + "（先用 recipebook 看看有什么）");
            }
            picked = candidates.get(index);
        } else {
            throw new IllegalArgumentException("要指定 recipeId / result / index 之一");
        }
        if (picked == null) {
            throw new IllegalStateException("配方书里没找到匹配的配方（先用 recipebook 看可选列表）");
        }

        JsonObject before = Observation.of(mc);
        int containerId = player.containerMenu.containerId;
        mc.gameMode.handlePlaceRecipe(containerId, picked, all);
        Journal.event("op", "placeRecipe " + resultId(mc, picked) + " all=" + all);
        JsonObject extra = new JsonObject();
        extra.addProperty("recipe", recipeId(mc, picked));
        extra.addProperty("result", resultId(mc, picked));
        extra.addProperty("useMaxItems", all);
        extra.addProperty("note", "服务端裁决：产物下一拍才出现，用 inventory/container 回读确认");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 配方书里当前可选的配方（顺序就是 `placeRecipe` 的 index）。 */
    static JsonObject recipeOptions(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        boolean onlyCraftable = args.has("craftable") && args.get("craftable").getAsBoolean();
        JsonArray out = new JsonArray();
        List<Recipe<?>> all = recipeCandidates(mc);
        for (int i = 0; i < all.size(); i++) {
            Recipe<?> recipe = all.get(i);
            JsonObject o = new JsonObject();
            o.addProperty("index", i);
            o.addProperty("recipe", recipeId(mc, recipe));
            o.addProperty("result", resultId(mc, recipe));
            out.add(o);
        }
        JsonObject o = new JsonObject();
        o.add("options", out);
        o.addProperty("count", out.size());
        o.addProperty("note", onlyCraftable ? "（暂时没按 craftable 过滤）" : "");
        return o;
    }

    /** 玩家配方书里"现在这些格子做得出来"的配方，也是 placeRecipe 的 index 来源。 */
    private static List<Recipe<?>> recipeCandidates(Minecraft mc) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        var groups = player.getRecipeBook().getCollections();
        java.util.List<Recipe<?>> out = new java.util.ArrayList<>();
        for (var group : groups) {
            if (group.hasKnownRecipes()) {
                out.addAll(group.getRecipes());
            }
        }
        return out;
    }

    private static String recipeId(Minecraft mc, Recipe<?> recipe) {
        return mc.level.getRecipeManager().byKey(recipe.getId())
                .map(r -> recipe.getId().toString())
                .orElse(recipe.getId().toString());
    }

    private static String resultId(Minecraft mc, Recipe<?> recipe) {
        ItemStack stack = recipe.getResultItem(mc.level.registryAccess());
        return stack.isEmpty() ? "minecraft:air"
                : ForgeRegistries.ITEMS.getKey(stack.getItem()).toString();
    }

    /** 容器里的按钮（附魔台选等级、切石机选样式、信标选效果、织布机选图案）。 */
    static JsonObject containerButton(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        int button = args.get("buttonId").getAsInt();
        JsonObject before = Observation.of(mc);
        mc.gameMode.handleInventoryButtonClick(player.containerMenu.containerId, button);
        Journal.event("op", "containerButton " + button);
        JsonObject extra = new JsonObject();
        extra.addProperty("buttonId", button);
        extra.addProperty("containerId", player.containerMenu.containerId);
        extra.addProperty("note", "按钮编号各界面不同（附魔台 0..2 是等级，索引在 dataSlot 里）");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 创造栏取物：把物品放进指定槽位（不消耗，创造模式专用）。 */
    static JsonObject creativeGive(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        if (!player.getAbilities().instabuild) {
            throw new IllegalStateException("只有创造模式能用（当前模式 "
                    + mc.gameMode.getPlayerMode().getName() + "）");
        }
        String id = args.get("item").getAsString();
        var location = net.minecraft.resources.ResourceLocation.tryParse(
                id.contains(":") ? id : "minecraft:" + id);
        if (location == null) {
            throw new IllegalArgumentException("物品名不合法：" + id);
        }
        var item = ForgeRegistries.ITEMS.getValue(location);
        if (item == null) {
            throw new IllegalArgumentException("没有这个物品：" + location);
        }
        int count = args.has("count") ? args.get("count").getAsInt() : 1;
        int slot = args.has("slot") ? args.get("slot").getAsInt()
                : player.containerMenu.containerId == 0 ? 36 : 0;
        JsonObject before = Observation.of(mc);
        mc.gameMode.handleCreativeModeItemAdd(new ItemStack(item, count), slot);
        Journal.event("op", "creativeGive " + location + " x" + count + " → 槽 " + slot);
        JsonObject extra = new JsonObject();
        extra.addProperty("item", location.toString());
        extra.addProperty("count", count);
        extra.addProperty("slot", slot);
        extra.addProperty("note", "服务端裁决；用 inventory 回读确认");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    // ------------------------------------------------------------------ 手上那些事

    /** 松手：把正在蓄力的东西放掉（弓、三叉戟、望远镜、盾、吃东西中途松口）。 */
    static JsonObject releaseUsing(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Observation.of(mc);
        boolean wasUsing = player.isUsingItem();
        mc.gameMode.releaseUsingItem(player);
        Journal.event("op", "releaseUsing（之前在用=" + wasUsing + "）");
        JsonObject extra = new JsonObject();
        extra.addProperty("wasUsing", wasUsing);
        extra.addProperty("usedHand", player.getUsedItemHand().name().toLowerCase());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 开始用手里的东西（拉弓、吃东西、举盾）。要放开就用 releaseUsing。 */
    static JsonObject startUsing(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        InteractionHand hand = readHand(args);
        JsonObject before = Observation.of(mc);
        player.startUsingItem(hand);
        Journal.event("op", "startUsing " + hand);
        JsonObject extra = new JsonObject();
        extra.addProperty("hand", hand.name().toLowerCase());
        extra.addProperty("using", player.isUsingItem());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /**
     * 选取方块（鼠标中键）—— 照抄原版 {@code Minecraft.pickBlock()} 的步骤。
     *
     * <p>为什么不能直接调 {@code gameMode.handlePickItem(slot)}：那个方法的语义是
     * **"把背包第 N 格挪到手上"**（服务端 {@code ServerGamePacketListenerImpl:607} →
     * {@code inventory.pickSlot(slot)}），不是"选中准星指的方块"。
     * 真正的"中键选取"逻辑写在 {@code Minecraft.pickBlock()} 里，而它是 **private** 的，
     * 所以这里把它的三步照样做一遍：
     * <ol>
     *   <li>用准星命中结果取方块（Forge 的
     *       {@code IForgeBlockState#getCloneItemStack(HitResult, BlockGetter, BlockPos, Player)}）；</li>
     *   <li>创造模式：{@code inventory.setPickedItem(stack)} 再
     *       {@code handleCreativeModeItemAdd(手持, 36 + selected)} —— 36 是服务端那边快捷栏的起始槽号；</li>
     *   <li>生存模式：在背包里找到同一个物品，快捷栏里就直接切过去，否则
     *       {@code handlePickItem(那个槽)} 把它换上来。</li>
     * </ol>
     */
    static JsonObject pickItem(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Observation.of(mc);

        // 允许先转向再选取（原版是靠鼠标把准星移过去）
        if (args.has("x")) {
            InputOverride.lookAt(mc, args);
        }
        var hit = mc.hitResult;
        if (hit == null || hit.getType() == net.minecraft.world.phys.HitResult.Type.MISS) {
            throw new IllegalStateException("准星没打到任何东西（可以先 lookAt 再看）");
        }
        ItemStack picked;
        if (hit instanceof net.minecraft.world.phys.BlockHitResult blockHit) {
            var state = player.level().getBlockState(blockHit.getBlockPos());
            if (state.isAir()) {
                throw new IllegalStateException("准星那块是空气");
            }
            picked = state.getCloneItemStack(hit, player.level(), blockHit.getBlockPos(), player);
        } else if (hit instanceof net.minecraft.world.phys.EntityHitResult entityHit) {
            picked = entityHit.getEntity().getPickedResult(hit);
            if (picked == null) {
                throw new IllegalStateException("这个实体不支持『选取』");
            }
        } else {
            throw new IllegalStateException("准星类型不认识：" + hit.getType());
        }
        if (picked.isEmpty()) {
            throw new IllegalStateException("这个方块没有对应的物品可以选取");
        }

        var inventory = player.getInventory();
        String how;
        if (player.getAbilities().instabuild) {
            inventory.setPickedItem(picked);
            mc.gameMode.handleCreativeModeItemAdd(inventory.getItem(inventory.selected),
                    36 + inventory.selected);
            how = "creative";
        } else {
            int found = inventory.findSlotMatchingItem(picked);
            if (found == -1) {
                throw new IllegalStateException("背包里没有 " + ForgeRegistries.ITEMS
                        .getKey(picked.getItem()) + "（生存模式只能选取已有的东西）");
            }
            if (net.minecraft.world.entity.player.Inventory.isHotbarSlot(found)) {
                inventory.selected = found;
                how = "hotbar";
            } else {
                mc.gameMode.handlePickItem(found);
                how = "movedFromSlot" + found;
            }
        }
        Journal.event("op", "pickItem " + ForgeRegistries.ITEMS.getKey(picked.getItem())
                + " via " + how);
        JsonObject extra = new JsonObject();
        extra.addProperty("item", ForgeRegistries.ITEMS.getKey(picked.getItem()).toString());
        extra.addProperty("how", how);
        extra.addProperty("slot", inventory.selected);
        extra.addProperty("note", "创造模式那条要等服务端回 SetSlot 包才生效，隔一拍回读 inventory 才准");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 丢东西（Q）：丢手上那一个，或者 all=true 丢一整叠。 */
    static JsonObject drop(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        boolean all = args.has("all") && args.get("all").getAsBoolean();
        JsonObject before = Observation.of(mc);
        String held = ForgeRegistries.ITEMS
                .getKey(player.getMainHandItem().getItem()).toString();
        boolean dropped = player.drop(all);
        Journal.event("op", "drop all=" + all + " held=" + held);
        JsonObject extra = new JsonObject();
        extra.addProperty("held", held);
        extra.addProperty("all", all);
        extra.addProperty("dropped", dropped);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 中止正在进行的挖掘（挖一半改主意）。 */
    static JsonObject stopBreak(Minecraft mc, JsonObject args) {
        JsonObject before = Observation.of(mc);
        boolean was = mc.gameMode.isDestroying();
        int stage = mc.gameMode.getDestroyStage();
        mc.gameMode.stopDestroyBlock();
        Journal.event("op", "stopBreak（之前 isDestroying=" + was + "）");
        JsonObject extra = new JsonObject();
        extra.addProperty("wasDestroying", was);
        extra.addProperty("destroyStage", stage);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 挖掘进度：正在挖吗、挖到第几段、能挖多远。 */
    static JsonObject digStatus(Minecraft mc) {
        JsonObject o = new JsonObject();
        o.addProperty("destroying", mc.gameMode.isDestroying());
        o.addProperty("destroyStage", mc.gameMode.getDestroyStage());
        o.addProperty("pickRange", mc.gameMode.getPickRange());
        o.addProperty("hasExperience", mc.gameMode.hasExperience());
        o.addProperty("playerMode", mc.gameMode.getPlayerMode().getName());
        o.addProperty("previousMode", mc.gameMode.getPreviousPlayerMode() == null
                ? null : mc.gameMode.getPreviousPlayerMode().getName());
        o.addProperty("serverControlledInventory", mc.gameMode.isServerControlledInventory());
        o.addProperty("alwaysFlying", mc.gameMode.isAlwaysFlying());
        if (mc.hitResult instanceof net.minecraft.world.phys.BlockHitResult blockHit) {
            o.addProperty("aimingAt", blockHit.getBlockPos().toShortString());
            o.addProperty("aimingFace", blockHit.getDirection().getName());
        } else {
            o.addProperty("aimingAt", (String) null);
        }
        return o;
    }

    // ------------------------------------------------------------------ 身体状态

    /** 睡觉。床必须是合法的（晚上、没怪、床没被占）。 */
    static JsonObject sleep(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        BlockPos pos = Blocks.readPos(args);
        JsonObject before = Observation.of(mc);
        var outcome = player.startSleepInBed(pos);
        JsonObject extra = new JsonObject();
        outcome.ifLeft(problem -> extra.addProperty("problem", problem.name()));
        outcome.ifRight(unit -> extra.addProperty("sleeping", true));
        extra.addProperty("bed", pos.toShortString());
        Journal.event("op", "sleep " + pos.toShortString() + " → " + extra);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 起床。 */
    static JsonObject wakeUp(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Observation.of(mc);
        boolean was = player.isSleeping();
        player.stopSleeping();
        Journal.event("op", "wakeUp（之前睡着=" + was + "）");
        JsonObject extra = new JsonObject();
        extra.addProperty("wasSleeping", was);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 上载具（船/矿车/马/猪）。 */
    static JsonObject ride(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        Entity vehicle = requireEntity(mc, args);
        JsonObject before = Observation.of(mc);
        boolean ok = player.startRiding(vehicle, true);
        Journal.event("op", "ride #" + vehicle.getId() + " → " + ok);
        JsonObject extra = new JsonObject();
        extra.addProperty("vehicleId", vehicle.getId());
        extra.addProperty("mounted", ok);
        extra.addProperty("vehicle", ForgeRegistries.ENTITY_TYPES
                .getKey(vehicle.getType()).toString());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 下载具。 */
    static JsonObject dismount(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Observation.of(mc);
        Entity vehicle = player.getVehicle();
        player.stopRiding();
        Journal.event("op", "dismount");
        JsonObject extra = new JsonObject();
        extra.addProperty("wasRiding", vehicle == null ? null
                : ForgeRegistries.ENTITY_TYPES.getKey(vehicle.getType()).toString());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 死亡后重生。 */
    static JsonObject respawn(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        boolean dead = player.isDeadOrDying();
        JsonObject before = Observation.of(mc);
        player.respawn();
        Journal.event("op", "respawn（之前已死=" + dead + "）");
        JsonObject extra = new JsonObject();
        extra.addProperty("wasDead", dead);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /**
     * 开关创造飞行。
     *
     * <p>**原版规则：站在地上飞行会被自动取消。** 见 {@code LocalPlayer:784}：
     * <pre>if (this.onGround() && this.getAbilities().flying && !gameMode.isAlwaysFlying())
     *     this.getAbilities().flying = false;</pre>
     * 所以"把 flying 设成 true"在站着的时候下一 tick 就没了 —— 这不是 bug，是原版行为。
     * 要让它真的飞起来，得同时离地，所以这里默认顺手给一点向上的速度（{@code lift}，可关）。
     */
    static JsonObject fly(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        Abilities abilities = player.getAbilities();
        boolean want = args.has("on") ? args.get("on").getAsBoolean() : !abilities.flying;
        boolean lift = !args.has("lift") || args.get("lift").getAsBoolean();
        JsonObject before = Observation.of(mc);
        if (want && !abilities.mayfly) {
            throw new IllegalStateException("当前模式不许飞（gameMode="
                    + mc.gameMode.getPlayerMode().getName() + "）");
        }
        abilities.flying = want;
        // 切换飞行要告诉服务端，不然会被拉回地面。
        // LocalPlayer 重写了 onUpdateAbilities()，里面就是发 ServerboundPlayerAbilitiesPacket。
        player.onUpdateAbilities();
        boolean lifted = false;
        if (want && lift && player.onGround()) {
            var motion = player.getDeltaMovement();
            player.setDeltaMovement(motion.x, 0.42, motion.z);
            lifted = true;
        }
        Journal.event("op", "fly → " + want + (lifted ? "（顺带离地）" : ""));
        JsonObject extra = new JsonObject();
        extra.addProperty("flying", want);
        extra.addProperty("lifted", lifted);
        extra.addProperty("note", lifted
                ? "原版站在地上会取消飞行（LocalPlayer:784），所以顺手给了一点向上的速度让它脱离地面"
                : null);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /**
     * 打开自己的背包界面。
     *
     * <p>两条路，跟原版 {@code Minecraft.handleKeybinds} 里按 E 的分支**一模一样**
     * （`Minecraft` 里那段 `keyInventory.consumeClick()`）：
     * <ul>
     *   <li>普通情况：客户端自己 {@code setScreen(new InventoryScreen(player))}；</li>
     *   <li>服务端控制的背包（创造模式）：{@code sendOpenInventory()} 只发一个
     *       {@code ServerboundPlayerCommandPacket(OPEN_INVENTORY)}，界面由服务端回包才开。</li>
     * </ul>
     * 之前只调了后者，所以在普通模式下发了个包却什么也没发生 —— 这是读源码才看出来的。
     */
    static JsonObject openInventory(Minecraft mc, JsonObject args) {
        LocalPlayer player = InputOverride.requireWorld(mc);
        JsonObject before = Observation.of(mc);
        boolean serverControlled = mc.gameMode.isServerControlledInventory();
        if (serverControlled) {
            player.sendOpenInventory();
        } else {
            mc.setScreen(new net.minecraft.client.gui.screens.inventory.InventoryScreen(player));
        }
        Journal.event("op", "openInventory（服务端控制=" + serverControlled + "）");
        JsonObject extra = new JsonObject();
        extra.addProperty("serverControlled", serverControlled);
        extra.addProperty("note", serverControlled
                ? "界面要等服务端回包才开" : "界面已在客户端打开");
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 客户端侧的一份世界快照，用来核对"我这边看到的"和"服务端说的"是否一致。 */
    static JsonObject clientLevel(Minecraft mc) {
        ClientLevel level = mc.level;
        JsonObject o = new JsonObject();
        o.addProperty("dim", level.dimension().location().toString());
        o.addProperty("entityCount", level.getEntityCount());
        o.addProperty("loadedChunks", level.getChunkSource().getLoadedChunksCount());
        o.addProperty("dayTime", level.getDayTime());
        o.addProperty("gameTime", level.getGameTime());
        return o;
    }
}
