/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.potion.SinkerMobEffect;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> SINKER = REGISTRY.register("sinker", () -> new SinkerMobEffect());
}