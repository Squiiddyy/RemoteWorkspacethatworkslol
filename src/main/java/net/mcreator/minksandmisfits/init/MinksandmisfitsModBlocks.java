/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.minksandmisfits.block.CattailBlock;
import net.mcreator.minksandmisfits.block.ABlock;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MinksandmisfitsMod.MODID);
	public static final DeferredBlock<Block> CATTAIL;
	public static final DeferredBlock<Block> DINOFLAGELLATE;
	static {
		CATTAIL = REGISTRY.register("cattail", CattailBlock::new);
		DINOFLAGELLATE = REGISTRY.register("dinoflagellate", ABlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}