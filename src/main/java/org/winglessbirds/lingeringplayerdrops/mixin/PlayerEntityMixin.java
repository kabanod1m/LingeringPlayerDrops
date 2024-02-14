package org.winglessbirds.lingeringplayerdrops.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.winglessbirds.lingeringplayerdrops.util.PlayerDropItemEvents;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;", at = @At("RETURN"))
    private void inject_dropItem(final ItemStack stack, final boolean throwRandomly, final boolean retainOwnership, @Nullable final CallbackInfoReturnable ret) {
        PlayerDropItemEvents.AFTER.invoker().afterDropItem(stack, throwRandomly, retainOwnership, ret);
    }
}
