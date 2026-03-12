/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MINKS_AND_MISFITS = REGISTRY.register("minks_and_misfits",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.minksandmisfits.minks_and_misfits")).icon(() -> new ItemStack(MinksandmisfitsModItems.BASIC_PLAYER_SPAWN_EGG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MinksandmisfitsModItems.BASIC_PLAYER_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.HOUSE_ANCHOR_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.OPOSSUM_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModBlocks.CATTAIL.get().asItem());
				tabData.accept(MinksandmisfitsModItems.MINK_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.DASHTEST.get());
				tabData.accept(MinksandmisfitsModBlocks.DINOFLAGELLATE.get().asItem());
				tabData.accept(MinksandmisfitsModBlocks.BLUE_SAND.get().asItem());
				tabData.accept(MinksandmisfitsModBlocks.BLUE_SAND_STONE.get().asItem());
			}).build());
}