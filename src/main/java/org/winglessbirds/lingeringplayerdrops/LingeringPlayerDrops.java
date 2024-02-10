package org.winglessbirds.lingeringplayerdrops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.winglessbirds.lingeringplayerdrops.event.PlayerDropHandler;
import org.winglessbirds.lingeringplayerdrops.util.PlayerDropItemEvents;

public class LingeringPlayerDrops implements ModInitializer {

    public static final String MODID = "lingeringplayerdrops";
    public static final Logger LOG = LoggerFactory.getLogger(MODID);

    public static final GameRules.Key<GameRules.BooleanRule> PLAYER_DROP_ITEMS_LINGER = GameRuleRegistry.register("playerDropItemsLinger", GameRules.Category.DROPS, GameRuleFactory.createBooleanRule(true));
    public static final GameRules.Key<GameRules.BooleanRule> PLAYER_DEATH_ITEMS_LINGER = GameRuleRegistry.register("playerDeathItemsLinger", GameRules.Category.DROPS, GameRuleFactory.createBooleanRule(true));

    @Override
    public void onInitialize() {
        PlayerDropItemEvents.AFTER.register(new PlayerDropHandler());
    }

    // Clean up world from lingering items
    // Teleport to self
    // /tp @e[type=minecraft:item,nbt={Age:-32768s}] @s
    // Kill lingering items
    // /kill @e[type=minecraft:item,nbt={Age:-32768s}]
}
