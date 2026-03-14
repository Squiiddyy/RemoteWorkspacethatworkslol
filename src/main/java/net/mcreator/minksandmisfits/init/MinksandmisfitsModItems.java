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

import net.mcreator.minksandmisfits.item.*;
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
	public static final DeferredItem<Item> BLUE_SAND;
	public static final DeferredItem<Item> BLUE_SAND_STONE;
	public static final DeferredItem<Item> MINK_FUR;
	public static final DeferredItem<Item> GRAPE;
	public static final DeferredItem<Item> GRAPE_VINE;
	public static final DeferredItem<Item> BUG_REMAINS;
	public static final DeferredItem<Item> TICK_SPAWN_EGG;
	public static final DeferredItem<Item> MINK_FUR_ARMOR_ARMOR_BOOTS;
	public static final DeferredItem<Item> MINK_ARMOR;
	public static final DeferredItem<Item> BUG_HELMET;
	public static final DeferredItem<Item> BUG_CHESTPLATE;
	public static final DeferredItem<Item> OPOSSUM_RIDEABLE_SPAWN_EGG;
	public static final DeferredItem<Item> MINK_TRANSFORM;
	public static final DeferredItem<Item> MINK_FUR_CARPET;
	public static final DeferredItem<Item> MUSK_RAT_SPAWN_EGG;
	public static final DeferredItem<Item> CRAYFISH_SPAWN_EGG;
	static {
		BASIC_PLAYER_SPAWN_EGG = REGISTRY.register("basic_player_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.BASIC_PLAYER, -7821124, -4491161, new Item.Properties()));
		HOUSE_ANCHOR_SPAWN_EGG = REGISTRY.register("house_anchor_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.HOUSE_ANCHOR, -1, -1, new Item.Properties()));
		OPOSSUM_SPAWN_EGG = REGISTRY.register("opossum_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.OPOSSUM, -1917227, -11255230, new Item.Properties()));
		CATTAIL = doubleBlock(MinksandmisfitsModBlocks.CATTAIL);
		MINK_SPAWN_EGG = REGISTRY.register("mink_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.MINK, -12505297, -3624794, new Item.Properties()));
		DASHTEST = REGISTRY.register("dashtest", DashtestItem::new);
		DINOFLAGELLATE = block(MinksandmisfitsModBlocks.DINOFLAGELLATE);
		BLUE_SAND = block(MinksandmisfitsModBlocks.BLUE_SAND);
		BLUE_SAND_STONE = block(MinksandmisfitsModBlocks.BLUE_SAND_STONE);
		MINK_FUR = REGISTRY.register("mink_fur", MinkFurItem::new);
		GRAPE = REGISTRY.register("grape", GrapeItem::new);
		GRAPE_VINE = doubleBlock(MinksandmisfitsModBlocks.GRAPE_VINE);
		BUG_REMAINS = REGISTRY.register("bug_remains", BugRemainsItem::new);
		TICK_SPAWN_EGG = REGISTRY.register("tick_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.TICK, -1, -1, new Item.Properties()));
		MINK_FUR_ARMOR_ARMOR_BOOTS = REGISTRY.register("mink_fur_armor_armor_boots", MinkFurArmorArmorItem.Boots::new);
		MINK_ARMOR = REGISTRY.register("mink_armor", MinkArmorItem::new);
		BUG_HELMET = REGISTRY.register("bug_helmet", BugItem.Helmet::new);
		BUG_CHESTPLATE = REGISTRY.register("bug_chestplate", BugItem.Chestplate::new);
		OPOSSUM_RIDEABLE_SPAWN_EGG = REGISTRY.register("opossum_rideable_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.OPOSSUM_RIDEABLE, -1917227, -11255230, new Item.Properties()));
		MINK_TRANSFORM = REGISTRY.register("mink_transform", MinkTransformItem::new);
		MINK_FUR_CARPET = block(MinksandmisfitsModBlocks.MINK_FUR_CARPET);
		MUSK_RAT_SPAWN_EGG = REGISTRY.register("musk_rat_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.MUSK_RAT, -1, -1, new Item.Properties()));
		CRAYFISH_SPAWN_EGG = REGISTRY.register("crayfish_spawn_egg", () -> new DeferredSpawnEggItem(MinksandmisfitsModEntities.CRAYFISH, -1, -1, new Item.Properties()));
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