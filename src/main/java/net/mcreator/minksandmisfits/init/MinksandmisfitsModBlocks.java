/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.minksandmisfits.block.PeenisPlantBlock;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MinksandmisfitsMod.MODID);
	public static final DeferredBlock<Block> PEENIS_PLANT;
	static {
		PEENIS_PLANT = REGISTRY.register("peenis_plant", PeenisPlantBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}