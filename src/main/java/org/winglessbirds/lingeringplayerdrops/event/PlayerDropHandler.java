package org.winglessbirds.lingeringplayerdrops.event;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.winglessbirds.lingeringplayerdrops.LingeringPlayerDrops;
import org.winglessbirds.lingeringplayerdrops.util.PlayerDropItemEvents;

public class PlayerDropHandler implements PlayerDropItemEvents.After {

    @Override
    public void afterDropItem(ItemStack stack, boolean throwRandomly, boolean retainOwnership, @Nullable CallbackInfoReturnable itemEntity) {

        if (itemEntity == null) {
            return;
        }

        ItemEntity dropped;

        try {
            dropped = ((ItemEntity) itemEntity.getReturnValue());
        } catch (Exception e) {
            LingeringPlayerDrops.LOG.debug("Somehow encountered an exception!\n" + e.getMessage());
            return;
        }

        if (dropped == null) {
            return;
        }

        if (throwRandomly) {
            if (dropped.getWorld().getGameRules().getBoolean(LingeringPlayerDrops.PLAYER_DEATH_ITEMS_LINGER)) {
                dropped.setNeverDespawn();
            }
        } else {
            if (dropped.getWorld().getGameRules().getBoolean(LingeringPlayerDrops.PLAYER_DROP_ITEMS_LINGER)) {
                dropped.setNeverDespawn();
            }
        }
    }
}
