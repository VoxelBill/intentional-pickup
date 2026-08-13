package me.voxelbill.intentional_pickup.common.tags;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    private static final String MOD_ID = "intentional_pickup";

    public static final TagKey<Item> PICKUP_WHITELIST = registerTag("pickup_whitelist");
    public static final TagKey<Item> PICKUP_BLACKLIST = registerTag("pickup_blacklist");

    public static boolean isTagEmpty(TagKey<Item> tag, RegistryAccess registryAccess) {
        return registryAccess.lookupOrThrow(Registries.ITEM).getOrThrow(tag).size() == 0;
    }

    private static TagKey<Item> registerTag(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
    }
}
