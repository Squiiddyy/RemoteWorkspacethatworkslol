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
	public static final DeferredItem<Item> OPOSSUM_SPAWN_EGG;
	static {
		BASIC_PLAYER_SPAWN_EGG = REGISTRY.register("basic_player_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.BASIC_PLAYER, -7821124, -4491161, new Item.Properties()));
		HOUSE_ANCHOR_SPAWN_EGG = REGISTRY.register("house_anchor_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.HOUSE_ANCHOR, -1, -1, new Item.Properties()));
		MINK_SPAWN_EGG = REGISTRY.register("mink_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.MINK, -11981009, -9417395, new Item.Properties()));
		OPOSSUM_SPAWN_EGG = REGISTRY.register("opossum_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.OPOSSUM, -2171684, -10463658, new Item.Properties()));
	}
	// Start of user code block custom items
	// End of user code block custom items
}