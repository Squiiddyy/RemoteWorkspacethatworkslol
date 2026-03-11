/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MinksandmisfitsMod.MODID);
	public static final DeferredItem<Item> BASIC_PLAYER_SPAWN_EGG;
	public static final DeferredItem<Item> HOUSE_ANCHOR_SPAWN_EGG;
	public static final DeferredItem<Item> MINK_SPAWN_EGG;
	static {
		BASIC_PLAYER_SPAWN_EGG = REGISTRY.register("basic_player_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.BASIC_PLAYER, -1, -1, new Item.Properties()));
		HOUSE_ANCHOR_SPAWN_EGG = REGISTRY.register("house_anchor_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.HOUSE_ANCHOR, -1, -1, new Item.Properties()));
		MINK_SPAWN_EGG = REGISTRY.register("mink_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.MINK, -1, -1, new Item.Properties()));
	}
	// Start of user code block custom items
	// End of user code block custom items
}