package me.voxelbill.intentional_pickup.common.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;

@Mixin(Mob.class)
public class MobMixin {

    @Inject(
        method = "pickUpItem",
        at = @At(
            value = "HEAD",
            target = "(net/minecraft/server/level/ServerLevel;net/minecraft/world/entity/item/ItemEntity;)V"
        ),
        cancellable = true
    )
    public void mob_intentional_pickup$pickUpItemInject(ServerLevel level, ItemEntity entity, CallbackInfo ci) {
        if (entity.getOwner() == null) {
            ci.cancel();
        }
    }
}
