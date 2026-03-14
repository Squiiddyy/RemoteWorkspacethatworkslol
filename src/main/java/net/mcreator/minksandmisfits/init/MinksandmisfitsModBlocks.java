/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.minksandmisfits.block.*;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MinksandmisfitsMod.MODID);
	public static final DeferredBlock<Block> CATTAIL;
	public static final DeferredBlock<Block> DINOFLAGELLATE;
	public static final DeferredBlock<Block> BLUE_SAND;
	public static final DeferredBlock<Block> BLUE_SAND_STONE;
	public static final DeferredBlock<Block> GRAPE_VINE;
	public static final DeferredBlock<Block> MINK_FUR_CARPET;
	static {
		CATTAIL = REGISTRY.register("cattail", CattailBlock::new);
		DINOFLAGELLATE = REGISTRY.register("dinoflagellate", DinoflagellateBlock::new);
		BLUE_SAND = REGISTRY.register("blue_sand", BlueSandBlock::new);
		BLUE_SAND_STONE = REGISTRY.register("blue_sand_stone", BlueSandStoneBlock::new);
		GRAPE_VINE = REGISTRY.register("grape_vine", GrapeVineBlock::new);
		MINK_FUR_CARPET = REGISTRY.register("mink_fur_carpet", MinkFurCarpetBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}