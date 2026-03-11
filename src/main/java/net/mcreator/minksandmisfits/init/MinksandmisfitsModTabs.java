/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public class MinksandmisfitsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MinksandmisfitsMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(MinksandmisfitsModItems.BASIC_PLAYER_SPAWN_EGG.get());
			tabData.accept(MinksandmisfitsModItems.HOUSE_ANCHOR_SPAWN_EGG.get());
			tabData.accept(MinksandmisfitsModItems.MINK_SPAWN_EGG.get());
			tabData.accept(MinksandmisfitsModItems.OPOSSUM_SPAWN_EGG.get());
		}
	}
}