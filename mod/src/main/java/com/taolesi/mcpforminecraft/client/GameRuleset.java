package com.taolesi.mcpforminecraft.client;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.world.level.GameRules;

/**
 * 1.20.1 全部游戏规则的清单。
 *
 * <p><b>这份字段名单是从 {@code GameRules.java} 抄下来的</b>（45 条），不是凭记忆写的 ——
 * 换版本后规则会增减，**要重新抄**（抄法见 skills/minecraft-api/SKILL.md 第 10 章 N21）。
 *
 * <p>为什么非要抄：原版**没有公开的遍历入口** ——
 * {@code GameRules} 只有一个按键取值的 {@code getRule(Key)}（`GameRules:117`），
 * 而 {@code /gamerule} 命令**不支持无参列出全部**（实测回 "Unknown or incomplete command"）。
 * 想让代理能"看全所有规则"，只能自己攒这份名单。
 *
 * <p>好消息：**规则名不用手抄** —— {@code Key.getId()} 就是命令里用的那个名字，
 * 所以这里只抄字段名，名字运行时取。
 */
final class GameRuleset {
    private static final Map<String, GameRules.Key<?>> BY_NAME = new LinkedHashMap<>();

    static {
        add(GameRules.RULE_ANNOUNCE_ADVANCEMENTS);
        add(GameRules.RULE_BLOCK_EXPLOSION_DROP_DECAY);
        add(GameRules.RULE_COMMANDBLOCKOUTPUT);
        add(GameRules.RULE_COMMAND_MODIFICATION_BLOCK_LIMIT);
        add(GameRules.RULE_DAYLIGHT);
        add(GameRules.RULE_DISABLE_ELYTRA_MOVEMENT_CHECK);
        add(GameRules.RULE_DISABLE_RAIDS);
        add(GameRules.RULE_DOBLOCKDROPS);
        add(GameRules.RULE_DOENTITYDROPS);
        add(GameRules.RULE_DOFIRETICK);
        add(GameRules.RULE_DOINSOMNIA);
        add(GameRules.RULE_DOMOBLOOT);
        add(GameRules.RULE_DOMOBSPAWNING);
        add(GameRules.RULE_DO_IMMEDIATE_RESPAWN);
        add(GameRules.RULE_DO_PATROL_SPAWNING);
        add(GameRules.RULE_DO_TRADER_SPAWNING);
        add(GameRules.RULE_DO_VINES_SPREAD);
        add(GameRules.RULE_DO_WARDEN_SPAWNING);
        add(GameRules.RULE_DROWNING_DAMAGE);
        add(GameRules.RULE_FALL_DAMAGE);
        add(GameRules.RULE_FIRE_DAMAGE);
        add(GameRules.RULE_FORGIVE_DEAD_PLAYERS);
        add(GameRules.RULE_FREEZE_DAMAGE);
        add(GameRules.RULE_GLOBAL_SOUND_EVENTS);
        add(GameRules.RULE_KEEPINVENTORY);
        add(GameRules.RULE_LAVA_SOURCE_CONVERSION);
        add(GameRules.RULE_LIMITED_CRAFTING);
        add(GameRules.RULE_LOGADMINCOMMANDS);
        add(GameRules.RULE_MAX_COMMAND_CHAIN_LENGTH);
        add(GameRules.RULE_MAX_ENTITY_CRAMMING);
        add(GameRules.RULE_MOBGRIEFING);
        add(GameRules.RULE_MOB_EXPLOSION_DROP_DECAY);
        add(GameRules.RULE_NATURAL_REGENERATION);
        add(GameRules.RULE_PLAYERS_SLEEPING_PERCENTAGE);
        add(GameRules.RULE_RANDOMTICKING);
        add(GameRules.RULE_REDUCEDDEBUGINFO);
        add(GameRules.RULE_SENDCOMMANDFEEDBACK);
        add(GameRules.RULE_SHOWDEATHMESSAGES);
        add(GameRules.RULE_SNOW_ACCUMULATION_HEIGHT);
        add(GameRules.RULE_SPAWN_RADIUS);
        add(GameRules.RULE_SPECTATORSGENERATECHUNKS);
        add(GameRules.RULE_TNT_EXPLOSION_DROP_DECAY);
        add(GameRules.RULE_UNIVERSAL_ANGER);
        add(GameRules.RULE_WATER_SOURCE_CONVERSION);
        add(GameRules.RULE_WEATHER_CYCLE);
    }

    private GameRuleset() {
    }

    private static void add(GameRules.Key<?> key) {
        BY_NAME.put(key.getId(), key);
    }

    /** 全部规则名 → Key，顺序跟源码里一致。 */
    static Map<String, GameRules.Key<?>> all() {
        return BY_NAME;
    }

    static GameRules.Key<?> byName(String name) {
        GameRules.Key<?> key = BY_NAME.get(name);
        if (key == null) {
            throw new IllegalArgumentException("没有这条游戏规则：" + name
                    + "（名字是 camelCase，如 doDaylightCycle；不带参数看全部）");
        }
        return key;
    }
}
