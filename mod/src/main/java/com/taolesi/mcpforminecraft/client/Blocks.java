package com.taolesi.mcpforminecraft.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;

/**
 * 世界层：看方块、看实体、看背包，以及挖/放/交互/攻击/使用/换手。
 *
 * <p>改动类动作全部走 {@code MultiPlayerGameMode} —— 也就是原版鼠标左键/右键
 * 最终落到的那几个方法（{@code startDestroyBlock/continueDestroyBlock/useItemOn/
 * attack/useItem}）。**没有直接改方块**：那样做服务端不认，一改就会被拉回去，
 * 而且看起来像"方块凭空没了/凭空出现"。
 *
 * <p>为什么不用反射去调 {@code MouseHandler} 那几个私有方法：私有的东西说变就变，
 * 而且语义动作（"挖这个方块"）本来就比"按下左键"更好用 —— 后者还得先对准。
 */
public final class Blocks {
    /** 一次区域扫描最多返回多少个方块，防止一条包把游戏和网络都噎住。 */
    private static final int SCAN_LIMIT = 4096;

    private Blocks() {
    }

    // ------------------------------------------------------------------ 观测

    static JsonObject block(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        BlockPos pos = readPos(args);
        JsonObject o = describe(mc, pos);
        o.addProperty("distance", Math.sqrt(player.distanceToSqr(
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5)));
        return o;
    }

    static JsonObject blocks(Minecraft mc, JsonObject args) {
        ClientLevel level = mc.level;
        BlockPos a = readPos(args, "x1", "y1", "z1");
        BlockPos b = readPos(args, "x2", "y2", "z2");
        String filter = args.has("filter") ? args.get("filter").getAsString() : "";
        int limit = args.has("limit") ? Math.min(args.get("limit").getAsInt(), SCAN_LIMIT) : 512;

        int x1 = Math.min(a.getX(), b.getX()), x2 = Math.max(a.getX(), b.getX());
        int y1 = Math.min(a.getY(), b.getY()), y2 = Math.max(a.getY(), b.getY());
        int z1 = Math.min(a.getZ(), b.getZ()), z2 = Math.max(a.getZ(), b.getZ());
        long volume = (long) (x2 - x1 + 1) * (y2 - y1 + 1) * (z2 - z1 + 1);
        if (volume > 1_000_000L) {
            throw new IllegalArgumentException("扫描体积太大（" + volume + "），缩小区间再试");
        }

        JsonArray found = new JsonArray();
        boolean truncated = false;
        BlockPos.MutableBlockPos cursor = new BlockPos.MutableBlockPos();
        outer:
        for (int y = y1; y <= y2; y++) {
            for (int z = z1; z <= z2; z++) {
                for (int x = x1; x <= x2; x++) {
                    cursor.set(x, y, z);
                    BlockState state = level.getBlockState(cursor);
                    if (state.isAir()) {
                        continue;
                    }
                    String id = ForgeRegistries.BLOCKS.getKey(state.getBlock()).toString();
                    if (!filter.isEmpty() && !id.contains(filter)) {
                        continue;
                    }
                    if (found.size() >= limit) {
                        truncated = true;
                        break outer;
                    }
                    JsonObject o = new JsonObject();
                    o.addProperty("x", x);
                    o.addProperty("y", y);
                    o.addProperty("z", z);
                    o.addProperty("block", id);
                    found.add(o);
                }
            }
        }
        JsonObject out = new JsonObject();
        out.add("blocks", found);
        out.addProperty("count", found.size());
        out.addProperty("scanned", volume);
        out.addProperty("truncated", truncated);
        return out;
    }

    static JsonObject entities(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        double radius = args.has("radius") ? args.get("radius").getAsDouble() : 16.0;
        String type = args.has("type") ? args.get("type").getAsString() : "";
        int limit = args.has("limit") ? args.get("limit").getAsInt() : 64;

        AABB box = player.getBoundingBox().inflate(radius);
        List<Entity> hits = player.level().getEntities(player, box, e -> true);
        JsonArray out = new JsonArray();
        for (Entity e : hits) {
            if (out.size() >= limit) {
                break;
            }
            String id = ForgeRegistries.ENTITY_TYPES.getKey(e.getType()).toString();
            if (!type.isEmpty() && !id.contains(type)) {
                continue;
            }
            JsonObject o = new JsonObject();
            o.addProperty("id", e.getId());
            o.addProperty("type", id);
            o.addProperty("name", e.getName().getString());
            o.addProperty("x", e.getX());
            o.addProperty("y", e.getY());
            o.addProperty("z", e.getZ());
            o.addProperty("distance", Math.sqrt(e.distanceToSqr(player)));
            if (e instanceof LivingEntity living) {
                o.addProperty("health", living.getHealth());
            }
            out.add(o);
        }
        JsonObject result = new JsonObject();
        result.add("entities", out);
        result.addProperty("count", out.size());
        return result;
    }

    static JsonObject inventory(Minecraft mc) {
        LocalPlayer player = requireWorld(mc);
        Inventory inv = player.getInventory();
        JsonArray items = new JsonArray();
        for (int i = 0; i < inv.getContainerSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (stack.isEmpty()) {
                continue;
            }
            items.add(describeStack(i, stack));
        }
        JsonObject out = new JsonObject();
        out.add("slots", items);
        out.addProperty("selected", inv.selected);
        out.addProperty("held", ForgeRegistries.ITEMS
                .getKey(player.getMainHandItem().getItem()).toString());
        out.addProperty("offhand", ForgeRegistries.ITEMS
                .getKey(player.getOffhandItem().getItem()).toString());
        return out;
    }

    static JsonObject ray(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        double reach = args.has("reach") ? args.get("reach").getAsDouble() : 4.5;
        HitResult hit = player.pick(reach, 1.0F, false);
        JsonObject out = new JsonObject();
        out.addProperty("type", hit.getType().name().toLowerCase());
        if (hit instanceof BlockHitResult blockHit) {
            out.add("block", describe(mc, blockHit.getBlockPos()));
            out.addProperty("face", blockHit.getDirection().getName());
        } else if (hit instanceof EntityHitResult entityHit) {
            Entity e = entityHit.getEntity();
            out.addProperty("entityId", e.getId());
            out.addProperty("entityType",
                    ForgeRegistries.ENTITY_TYPES.getKey(e.getType()).toString());
            out.addProperty("entityName", e.getName().getString());
        }
        return out;
    }

    // ------------------------------------------------------------------ 改动类

    /** 挖掉一个方块。生存要按硬度挖若干 tick，所以挂账到挖穿为止。 */
    static void breakBlock(Minecraft mc, JsonObject args, CompletableFuture<JsonObject> out) {
        LocalPlayer player = requireWorld(mc);
        BlockPos pos = readPos(args);
        Direction face = readFace(args, Direction.UP);
        if (player.level().getBlockState(pos).isAir()) {
            throw new IllegalStateException("那里本来就是空气：" + pos.toShortString());
        }
        JsonObject before = Observation.of(mc);
        JsonObject extra = new JsonObject();
        extra.add("target", describe(mc, pos));
        Journal.event("op", "break " + pos.toShortString());

        boolean[] started = {false};
        GameActions.submit(before, extra, 400,
                m -> {
                    if (m.level == null || m.player == null) {
                        return true;
                    }
                    BlockState now = m.level.getBlockState(pos);
                    if (now.isAir()) {
                        extra.addProperty("broke", true);
                        return true;
                    }
                    if (!started[0]) {
                        started[0] = true;
                        m.gameMode.startDestroyBlock(pos, face);
                    }
                    m.gameMode.continueDestroyBlock(pos, face);
                    extra.addProperty("progress", m.gameMode.isDestroying());
                    return false;
                },
                () -> player.swing(InteractionHand.MAIN_HAND),
                out);
    }

    /** 在 (x,y,z) 放一个方块：点它相邻方块的对应面，物品就落到这个坐标上。 */
    static JsonObject place(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        BlockPos pos = readPos(args);
        Direction face = readFace(args, Direction.UP);
        BlockPos clicked = pos.relative(face.getOpposite());

        // 两件事先说清楚，别让调用方对着"SUCCESS 但什么都没变"发愣：
        // useItemOn 是"本地预测 + 发包"的语义，返回值成功**不代表服务端会照做**。
        if (!player.level().getBlockState(pos).isAir()) {
            throw new IllegalStateException("目标位置已经有方块了：" + pos.toShortString()
                    + " 是 " + ForgeRegistries.BLOCKS.getKey(
                            player.level().getBlockState(pos).getBlock()));
        }
        if (player.level().getBlockState(clicked).isAir()) {
            throw new IllegalStateException("贴不上去：" + clicked.toShortString()
                    + "（face=" + face.getName() + " 指向的支撑方块）是空气，"
                    + "换一面或换个目标位置");
        }
        return useItemOn(mc, player, clicked, face, "place " + pos.toShortString());
    }

    /**
     * 对着 (x,y,z) 这个方块右键（开门/按按钮/拉杆/开容器都算）。
     *
     * <p>{@code awaitScreen=true} 时**等界面真的开出来再回包**。为什么要这个开关：
     * 开容器是**服务端仲裁**的 —— 客户端只发一个 useItemOn，界面要等服务端回
     * {@code ClientboundOpenScreenPacket} 才出现（客户端 {@code ClientPacketListener}
     * 收到才 {@code setScreen}）。所以"回包即界面已开"是不成立的，不等就得让调用方
     * 自己轮询。
     */
    static void interact(Minecraft mc, JsonObject args, CompletableFuture<JsonObject> out) {
        LocalPlayer player = requireWorld(mc);
        BlockPos pos = readPos(args);
        Direction face = readFace(args, Direction.UP);
        JsonObject before = Observation.of(mc);
        JsonObject extra = clickBlock(mc, player, pos, face, "interact " + pos.toShortString());

        boolean await = args.has("awaitScreen") && args.get("awaitScreen").getAsBoolean();
        if (!await) {
            out.complete(Observation.pair(before, Observation.of(mc), extra));
            return;
        }
        int budget = Math.max(1, args.has("ticks") ? args.get("ticks").getAsInt() : 40);
        GameActions.submit(before, extra, budget,
                m -> m.screen != null,
                () -> extra.addProperty("screen", mc.screen == null
                        ? null : mc.screen.getClass().getSimpleName()),
                out);
    }

    private static JsonObject useItemOn(Minecraft mc, LocalPlayer player, BlockPos clicked,
                                        Direction face, String what) {
        JsonObject before = Observation.of(mc);
        JsonObject extra = clickBlock(mc, player, clicked, face, what);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 真正的那一下右键。返回要带回给调用方的附加字段。 */
    private static JsonObject clickBlock(Minecraft mc, LocalPlayer player, BlockPos clicked,
                                         Direction face, String what) {
        Vec3 hitVec = Vec3.atCenterOf(clicked).relative(face, 0.5);
        BlockHitResult hit = new BlockHitResult(hitVec, face, clicked, false);
        player.swing(InteractionHand.MAIN_HAND);
        var result = mc.gameMode.useItemOn(player, InteractionHand.MAIN_HAND, hit);
        Journal.event("op", what + " → " + result);
        JsonObject extra = new JsonObject();
        extra.addProperty("clicked", clicked.toShortString());
        extra.addProperty("face", face.getName());
        extra.addProperty("consumed", result.consumesAction());
        return extra;
    }

    /** 攻击：默认打准星指着的东西，给 entityId 就打那个（先转过去对准）。 */
    static JsonObject attack(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        JsonObject before = Observation.of(mc);
        Entity target;
        if (args.has("entityId")) {
            int id = args.get("entityId").getAsInt();
            target = player.level().getEntity(id);
            if (target == null) {
                throw new IllegalStateException("附近没有 id=" + id + " 的实体");
            }
            double dx = target.getX() - player.getX();
            double dz = target.getZ() - player.getZ();
            InputOverride.look(mc, aimAt(player, target, dx, dz));
        } else if (mc.hitResult instanceof EntityHitResult hit) {
            target = hit.getEntity();
        } else {
            throw new IllegalStateException("准星没对着任何实体（也可以用 entityId 指定）");
        }
        player.swing(InteractionHand.MAIN_HAND);
        mc.gameMode.attack(player, target);
        Journal.event("op", "attack " + target.getName().getString());
        JsonObject extra = new JsonObject();
        extra.addProperty("targetId", target.getId());
        extra.addProperty("targetName", target.getName().getString());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    private static JsonObject aimAt(LocalPlayer player, Entity target, double dx, double dz) {
        double dy = (target.getY() + target.getEyeHeight() * 0.5)
                - (player.getY() + player.getEyeHeight());
        JsonObject out = new JsonObject();
        out.addProperty("yaw", Math.toDegrees(Math.atan2(dz, dx)) - 90.0);
        out.addProperty("pitch", -Math.toDegrees(Math.atan2(dy, Math.sqrt(dx * dx + dz * dz))));
        return out;
    }

    /** 用手里/副手的东西（吃、射、挥）。 */
    static JsonObject use(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        JsonObject before = Observation.of(mc);
        InteractionHand hand = args.has("hand") && "off".equalsIgnoreCase(args.get("hand").getAsString())
                ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
        var result = mc.gameMode.useItem(player, hand);
        Journal.event("op", "use(" + hand + ") → " + result);
        JsonObject extra = new JsonObject();
        extra.addProperty("hand", hand.name().toLowerCase());
        extra.addProperty("consumed", result.consumesAction());
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 选快捷栏槽位（1..9，也接受 0..8）。顺带把切换告诉服务端。 */
    static JsonObject selectSlot(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        int raw = args.get("slot").getAsInt();
        int slot = raw >= 1 && raw <= 9 ? raw - 1 : raw;
        if (slot < 0 || slot > 8) {
            throw new IllegalArgumentException("槽位要在 1..9（或 0..8）之间，收到 " + raw);
        }
        player.getInventory().selected = slot;
        syncCarried(mc, slot);
        JsonObject out = new JsonObject();
        out.addProperty("selected", slot);
        return out;
    }

    /** 滚轮：原版就是拿它切快捷栏的（{@code Inventory#swapPaint}）。 */
    static JsonObject scroll(Minecraft mc, JsonObject args) {
        LocalPlayer player = requireWorld(mc);
        double amount = args.has("amount") ? args.get("amount").getAsDouble() : 1.0;
        player.getInventory().swapPaint(amount);
        int slot = player.getInventory().selected;
        syncCarried(mc, slot);
        JsonObject out = new JsonObject();
        out.addProperty("selected", slot);
        out.addProperty("amount", amount);
        return out;
    }

    /** {@code MultiPlayerGameMode#ensureHasSentCarriedItem} 是私有的，所以自己发同一个包。 */
    private static void syncCarried(Minecraft mc, int slot) {
        if (mc.getConnection() != null) {
            mc.getConnection().send(new ServerboundSetCarriedItemPacket(slot));
        }
    }

    // ------------------------------------------------------------------ 小工具

    static JsonObject describeStack(int slot, ItemStack stack) {
        JsonObject o = new JsonObject();
        o.addProperty("slot", slot);
        o.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
        o.addProperty("count", stack.getCount());
        if (stack.hasCustomHoverName()) {
            o.addProperty("name", stack.getHoverName().getString());
        }
        if (stack.isDamageableItem()) {
            o.addProperty("damage", stack.getDamageValue());
        }
        return o;
    }

    /** 把一个方块讲清楚：是什么、是不是空气、有什么状态（facing/open/powered…）。 */
    static JsonObject describe(Minecraft mc, BlockPos pos) {
        ClientLevel level = mc.level;
        BlockState state = level.getBlockState(pos);
        JsonObject o = new JsonObject();
        o.addProperty("x", pos.getX());
        o.addProperty("y", pos.getY());
        o.addProperty("z", pos.getZ());
        o.addProperty("block", ForgeRegistries.BLOCKS.getKey(state.getBlock()).toString());
        o.addProperty("air", state.isAir());
        if (!state.isAir()) {
            o.addProperty("solid", state.isSolidRender(level, pos));
            o.addProperty("destroySpeed", state.getDestroySpeed(level, pos));
        }
        if (!state.getProperties().isEmpty()) {
            JsonObject props = new JsonObject();
            for (Property<?> property : state.getProperties()) {
                props.addProperty(property.getName(), readProperty(state, property));
            }
            o.add("props", props);
        }
        var blockEntity = level.getBlockEntity(pos);
        if (blockEntity != null) {
            o.addProperty("blockEntity", ForgeRegistries.BLOCK_ENTITY_TYPES.getKey(blockEntity.getType()).toString());
        }
        return o;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static String readProperty(BlockState state, Property<?> property) {
        return ((Property) property).getName(state.getValue((Property) property));
    }

    static BlockPos readPos(JsonObject args) {
        return readPos(args, "x", "y", "z");
    }

    static BlockPos readPos(JsonObject args, String kx, String ky, String kz) {
        for (String k : new String[]{kx, ky, kz}) {
            if (!args.has(k)) {
                throw new IllegalArgumentException("缺坐标参数 " + k);
            }
        }
        return new BlockPos(args.get(kx).getAsInt(), args.get(ky).getAsInt(), args.get(kz).getAsInt());
    }

    static Direction readFace(JsonObject args, Direction fallback) {
        if (!args.has("face")) {
            return fallback;
        }
        Direction face = Direction.byName(args.get("face").getAsString().toLowerCase());
        if (face == null) {
            throw new IllegalArgumentException("face 只能是 up/down/north/south/east/west");
        }
        return face;
    }

    private static LocalPlayer requireWorld(Minecraft mc) {
        return InputOverride.requireWorld(mc);
    }
}
