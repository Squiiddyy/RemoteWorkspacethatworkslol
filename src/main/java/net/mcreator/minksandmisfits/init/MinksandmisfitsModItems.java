/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.minksandmisfits.item.DashtestItem;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MinksandmisfitsMod.MODID);
	public static final DeferredItem<Item> BASIC_PLAYER_SPAWN_EGG;
	public static final DeferredItem<Item> HOUSE_ANCHOR_SPAWN_EGG;
	public static final DeferredItem<Item> OPOSSUM_SPAWN_EGG;
	public static final DeferredItem<Item> CATTAIL;
	public static final DeferredItem<Item> MINK_SPAWN_EGG;
	public static final DeferredItem<Item> DASHTEST;
	public static final DeferredItem<Item> DINOFLAGELLATE;
	static {
		BASIC_PLAYER_SPAWN_EGG = REGISTRY.register("basic_player_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.BASIC_PLAYER, -7821124, -4491161, new Item.Properties()));
		HOUSE_ANCHOR_SPAWN_EGG = REGISTRY.register("house_anchor_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.HOUSE_ANCHOR, -1, -1, new Item.Properties()));
		OPOSSUM_SPAWN_EGG = REGISTRY.register("opossum_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.OPOSSUM, -1978146, -11255230, new Item.Properties()));
		CATTAIL = doubleBlock(MinksandmisfitsModBlocks.CATTAIL);
		MINK_SPAWN_EGG = REGISTRY.register("mink_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.MINK, -12505297, -3624794, new Item.Properties()));
		DASHTEST = REGISTRY.register("dashtest", DashtestItem::new);
		DINOFLAGELLATE = block(MinksandmisfitsModBlocks.DINOFLAGELLATE);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return doubleBlock(block, new Item.Properties());
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), properties));
	}
}