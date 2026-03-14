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
				tabData.accept(MinksandmisfitsModBlocks.CATTAIL.get().asItem());
				tabData.accept(MinksandmisfitsModItems.MINK_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.DASHTEST.get());
				tabData.accept(MinksandmisfitsModBlocks.DINOFLAGELLATE.get().asItem());
				tabData.accept(MinksandmisfitsModBlocks.BLUE_SAND.get().asItem());
				tabData.accept(MinksandmisfitsModBlocks.BLUE_SAND_STONE.get().asItem());
				tabData.accept(MinksandmisfitsModItems.MINK_FUR.get());
				tabData.accept(MinksandmisfitsModItems.GRAPE.get());
				tabData.accept(MinksandmisfitsModBlocks.GRAPE_VINE.get().asItem());
				tabData.accept(MinksandmisfitsModItems.BUG_REMAINS.get());
				tabData.accept(MinksandmisfitsModItems.TICK_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.MINK_FUR_ARMOR_ARMOR_BOOTS.get());
				tabData.accept(MinksandmisfitsModItems.MINK_ARMOR.get());
				tabData.accept(MinksandmisfitsModItems.BUG_HELMET.get());
				tabData.accept(MinksandmisfitsModItems.BUG_CHESTPLATE.get());
				tabData.accept(MinksandmisfitsModItems.OPOSSUM_RIDEABLE_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.MINK_TRANSFORM.get());
				tabData.accept(MinksandmisfitsModBlocks.MINK_FUR_CARPET.get().asItem());
				tabData.accept(MinksandmisfitsModItems.MUSK_RAT_SPAWN_EGG.get());
				tabData.accept(MinksandmisfitsModItems.CRAYFISH_SPAWN_EGG.get());
			}).build());
}