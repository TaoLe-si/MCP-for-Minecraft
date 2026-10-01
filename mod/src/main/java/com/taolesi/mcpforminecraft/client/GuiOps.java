package com.taolesi.mcpforminecraft.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taolesi.mcpforminecraft.control.Journal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.ContainerEventHandler;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * 界面层：看当前界面有什么控件，点按钮、往输入框打字、点容器槽位、关界面。
 *
 * <p>点按钮走的是 {@code screen.mouseClicked(cx, cy, 0)} —— 跟真人鼠标落在按钮中心
 * 是同一条路（{@code ContainerEventHandler.mouseClicked} 会把事件派发给命中的子控件，
 * 再落到 {@code AbstractButton.onClick → onPress}）。所以**不用反射、也不用假装移动鼠标**，
 * 而且按的是哪个按钮由坐标决定，跟界面自己算热区的方式完全一致。
 */
public final class GuiOps {
    private GuiOps() {
    }

    /** 当前界面的控件清单。人在外面看不到屏幕，这个就是"眼睛"。 */
    static JsonObject screen(Minecraft mc) {
        Screen screen = mc.screen;
        JsonObject out = new JsonObject();
        out.addProperty("open", screen != null);
        if (screen == null) {
            return out;
        }
        out.addProperty("title", screen.getTitle().getString());
        out.addProperty("class", screen.getClass().getName());

        JsonArray widgets = new JsonArray();
        List<AbstractWidget> all = widgets(screen);
        for (int i = 0; i < all.size(); i++) {
            AbstractWidget w = all.get(i);
            JsonObject o = new JsonObject();
            o.addProperty("index", i);
            o.addProperty("type", w.getClass().getSimpleName());
            o.addProperty("label", w.getMessage().getString());
            o.addProperty("x", w.getX());
            o.addProperty("y", w.getY());
            o.addProperty("width", w.getWidth());
            o.addProperty("height", w.getHeight());
            o.addProperty("active", w.active);
            o.addProperty("visible", w.visible);
            if (w instanceof EditBox box) {
                o.addProperty("value", box.getValue());
            }
            widgets.add(o);
        }
        out.add("widgets", widgets);

        if (screen instanceof AbstractContainerScreen<?> containerScreen) {
            AbstractContainerMenu menu = containerScreen.getMenu();
            out.addProperty("containerId", menu.containerId);
            out.add("slots", slots(menu));
        }
        return out;
    }

    /**
     * 点按钮。给 {@code label} 就按文字找（子串、不分大小写），给 {@code index} 就按序号找。
     *
     * <p>找不到就报错并列出所有按钮 —— 比"静默点空"强，调用方一眼能看出界面长什么样。
     */
    static JsonObject clickButton(Minecraft mc, JsonObject args) {
        Screen screen = requireScreen(mc);
        List<AbstractWidget> all = widgets(screen);
        AbstractWidget target = null;

        if (args.has("index")) {
            int index = args.get("index").getAsInt();
            if (index < 0 || index >= all.size()) {
                throw new IllegalArgumentException("没有序号 " + index + " 的控件；"
                        + "当前共 " + all.size() + " 个：" + labels(all));
            }
            target = all.get(index);
        } else if (args.has("label")) {
            String want = args.get("label").getAsString().toLowerCase();
            for (AbstractWidget w : all) {
                if (w.getMessage().getString().toLowerCase().contains(want)) {
                    target = w;
                    break;
                }
            }
            if (target == null) {
                throw new IllegalArgumentException("没有文字含『" + want + "』的控件；"
                        + "当前有：" + labels(all));
            }
        } else {
            throw new IllegalArgumentException("要指定 label 或 index");
        }

        if (!target.active) {
            throw new IllegalStateException("控件『" + target.getMessage().getString()
                    + "』当前是灰的（active=false），点了也没用");
        }

        int cx = target.getX() + target.getWidth() / 2;
        int cy = target.getY() + target.getHeight() / 2;
        JsonObject before = Observation.of(mc);
        boolean handled = screen.mouseClicked(cx, cy, 0);
        screen.mouseReleased(cx, cy, 0);

        Journal.event("op", "clickButton 『" + target.getMessage().getString() + "』 @(" + cx + "," + cy + ")");
        JsonObject extra = new JsonObject();
        extra.addProperty("clicked", target.getMessage().getString());
        extra.addProperty("at", cx + "," + cy);
        extra.addProperty("handled", handled);
        return Observation.pair(before, Observation.of(mc), extra);
    }

    /** 往输入框里打字。{@code submit=true} 顺带回车（比如聊天、种子输入框）。 */
    static JsonObject typeText(Minecraft mc, JsonObject args) {
        Screen screen = requireScreen(mc);
        String text = args.has("text") ? args.get("text").getAsString() : "";
        boolean submit = args.has("submit") && args.get("submit").getAsBoolean();

        EditBox box = null;
        if (args.has("index")) {
            int index = args.get("index").getAsInt();
            List<EditBox> boxes = editBoxes(screen);
            if (index < 0 || index >= boxes.size()) {
                throw new IllegalArgumentException("当前界面只有 " + boxes.size() + " 个输入框");
            }
            box = boxes.get(index);
        } else {
            List<EditBox> boxes = editBoxes(screen);
            if (boxes.isEmpty()) {
                throw new IllegalArgumentException("当前界面没有输入框");
            }
            box = boxes.get(0);
        }

        box.setFocused(true);
        box.setValue(text);
        Journal.event("op", "typeText 「" + text + "」");
        if (submit) {
            screen.keyPressed(257 /* GLFW_KEY_ENTER */, 0, 0);   // 让界面自己处理回车
        }
        JsonObject out = new JsonObject();
        out.addProperty("value", box.getValue());
        out.addProperty("submitted", submit);
        out.addProperty("screen", mc.screen == null
                ? null : mc.screen.getClass().getSimpleName());
        return out;
    }

    /**
     * 点容器/背包里的槽位。
     *
     * <p>走 {@code gameMode.handleInventoryMouseClick} —— 原版鼠标点槽位走的就是它，
     * 由服务端仲裁后回同步包，所以不会出现"物品在本地凭空搬家"。
     */
    static JsonObject clickSlot(Minecraft mc, JsonObject args) {
        Screen screen = requireScreen(mc);
        if (!(screen instanceof AbstractContainerScreen<?> containerScreen)) {
            throw new IllegalStateException("当前界面不是容器界面（"
                    + screen.getClass().getSimpleName() + "），没有槽位可点");
        }
        LocalPlayer player = InputOverride.requireWorld(mc);
        AbstractContainerMenu menu = containerScreen.getMenu();
        int slot = args.get("slot").getAsInt();
        if (slot < 0 || slot >= menu.slots.size()) {
            throw new IllegalArgumentException("槽位要在 0.." + (menu.slots.size() - 1) + " 之间");
        }
        int button = args.has("button") ? args.get("button").getAsInt() : 0;
        ClickType clickType = ClickType.PICKUP;
        if (args.has("clickType")) {
            try {
                clickType = ClickType.valueOf(args.get("clickType").getAsString().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("clickType 不认识："
                        + args.get("clickType").getAsString() + "（可用 PICKUP/QUICK_MOVE/SWAP/THROW/…）");
            }
        }
        JsonObject before = Observation.of(mc);
        mc.gameMode.handleInventoryMouseClick(menu.containerId, slot, button, clickType, player);
        Journal.event("op", "clickSlot " + slot + " " + clickType);
        JsonObject extra = new JsonObject();
        extra.addProperty("slot", slot);
        extra.addProperty("button", button);
        extra.addProperty("clickType", clickType.name());
        extra.add("afterSlots", slots(menu));
        return Observation.pair(before, Observation.of(mc), extra);
    }

    static JsonObject closeScreen(Minecraft mc) {
        Screen screen = requireScreen(mc);
        String which = screen.getClass().getSimpleName();
        mc.setScreen(null);
        // setScreen(null) 内部会 grabMouse（Minecraft.java:1011），立刻还回去，
        // 不然会闪一下"光标被锁"
        ClientHooks.keepMouseFree(mc);
        Journal.event("op", "closeScreen " + which);
        JsonObject out = new JsonObject();
        out.addProperty("closed", which);
        return out;
    }

    // ------------------------------------------------------------------ 小工具

    private static Screen requireScreen(Minecraft mc) {
        Screen screen = mc.screen;
        if (screen == null) {
            throw new IllegalStateException("当前没有开着的界面（要开背包用 press{\"key\":\"inventory\"}）");
        }
        return screen;
    }

    /** 把界面里的控件按"能被点的顺序"摊平。 */
    private static List<AbstractWidget> widgets(Screen screen) {
        List<AbstractWidget> out = new ArrayList<>();
        collect(screen, out);
        return out;
    }

    private static void collect(ContainerEventHandler node, List<AbstractWidget> out) {
        for (GuiEventListener child : node.children()) {
            if (child instanceof AbstractWidget widget) {
                out.add(widget);
            } else if (child instanceof ContainerEventHandler nested) {
                collect(nested, out);
            }
        }
    }

    private static List<EditBox> editBoxes(Screen screen) {
        List<EditBox> out = new ArrayList<>();
        for (AbstractWidget widget : widgets(screen)) {
            if (widget instanceof EditBox box) {
                out.add(box);
            }
        }
        return out;
    }

    private static String labels(List<AbstractWidget> widgets) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < widgets.size(); i++) {
            AbstractWidget w = widgets.get(i);
            sb.append('[').append(i).append("] 「").append(w.getMessage().getString())
              .append('」').append(w.active ? "" : "(灰)");
            if (i < widgets.size() - 1) {
                sb.append("、");
            }
        }
        return sb.toString();
    }

    private static JsonArray slots(AbstractContainerMenu menu) {
        JsonArray out = new JsonArray();
        for (int i = 0; i < menu.slots.size(); i++) {
            Slot slot = menu.slots.get(i);
            ItemStack stack = slot.getItem();
            JsonObject o = new JsonObject();
            o.addProperty("slot", i);
            o.addProperty("containerSlot", slot.getContainerSlot());
            if (stack.isEmpty()) {
                o.addProperty("item", "minecraft:air");
            } else {
                o.add("stack", Blocks.describeStack(i, stack));
            }
            out.add(o);
        }
        return out;
    }
}
