package me.voxelbill.intentional_pickup.common.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.voxelbill.intentional_pickup.common.tags.ModItemTags;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

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
    public void intentional_pickup$pickUpItemInject(ServerLevel level, ItemEntity entity, CallbackInfo ci) {
        RegistryAccess access = ((Mob)(Object)this).level().registryAccess();
        boolean hasWhitelist = !ModItemTags.isTagEmpty(ModItemTags.PICKUP_WHITELIST, access);
        boolean hasBlacklist = !ModItemTags.isTagEmpty(ModItemTags.PICKUP_BLACKLIST, access);
        ItemStack item = entity.getItem();

        if ((hasWhitelist && !item.is(ModItemTags.PICKUP_WHITELIST)) || (hasBlacklist && item.is(ModItemTags.PICKUP_BLACKLIST))) {
            ci.cancel();
        }

        if (entity.getOwner() == null) {
            ci.cancel();
        }
    }
}
