package dev.codex.mcmcp;

import java.util.LinkedHashMap;
import java.util.Map;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;

final class PlayerControls {
    static final int MAX_HOLD_TICKS = 200;
    private static final Map<String, Integer> HELD = new LinkedHashMap<>();

    private PlayerControls() { }

    static void hold(Minecraft client, String control, int ticks) {
        KeyMapping mapping = mapping(client, control);
        if (mapping == null) throw new IllegalArgumentException("Unknown control: " + control);
        if ("inventory".equals(control)) {
            HELD.remove(control);
            mapping.setDown(false);
            if (client.screen instanceof InventoryScreen) {
                client.setScreen(null);
            } else {
                client.setScreen(new InventoryScreen(client.player));
            }
            return;
        }
        int duration = Math.max(1, Math.min(MAX_HOLD_TICKS, ticks));
        HELD.put(control, duration);
        if (consumesClick(control)) {
            KeyMapping.click(InputConstants.getKey(mapping.saveString()));
        }
        mapping.setDown(true);
    }

    private static boolean consumesClick(String control) {
        return switch (control) {
            case "jump", "use", "interact", "drop", "swap_offhand", "pick_block" -> true;
            default -> false;
        };
    }

    static void releaseAll(Minecraft client) {
        for (String control : HELD.keySet()) {
            KeyMapping mapping = mapping(client, control);
            if (mapping != null) mapping.setDown(false);
        }
        HELD.clear();
    }

    static void onClientTick(Minecraft client) {
        if (HELD.isEmpty()) return;
        for (Map.Entry<String, Integer> entry : HELD.entrySet()) {
            int remaining = entry.getValue() - 1;
            entry.setValue(remaining);
            if (remaining <= 0) {
                KeyMapping mapping = mapping(client, entry.getKey());
                if (mapping != null) mapping.setDown(false);
            }
        }
        HELD.values().removeIf(ticks -> ticks <= 0);
    }

    private static KeyMapping mapping(Minecraft client, String name) {
        return switch (name) {
            case "forward" -> client.options.keyUp;
            case "back" -> client.options.keyDown;
            case "left" -> client.options.keyLeft;
            case "right" -> client.options.keyRight;
            case "jump" -> client.options.keyJump;
            case "sneak" -> client.options.keyShift;
            case "sprint" -> client.options.keySprint;
            case "attack" -> client.options.keyAttack;
            case "inventory" -> client.options.keyInventory;
            case "drop" -> client.options.keyDrop;
            case "swap_offhand" -> client.options.keySwapOffhand;
            case "pick_block" -> client.options.keyPickItem;
            case "use", "interact" -> client.options.keyUse;
            default -> null;
        };
    }
}
