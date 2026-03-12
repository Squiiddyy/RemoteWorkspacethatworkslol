/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MINKHISS = REGISTRY.register("minkhiss", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("minksandmisfits", "minkhiss")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MINKHISSHSORT = REGISTRY.register("minkhisshsort", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("minksandmisfits", "minkhisshsort")));
}