/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.potion.*;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> MINK_FAST_SWIMMER = REGISTRY.register("mink_fast_swimmer", () -> new MinkFastSwimmerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SOFT_FALL = REGISTRY.register("soft_fall", () -> new SoftFallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SNOW_BOOST = REGISTRY.register("snow_boost", () -> new SnowBoostMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DETARGET = REGISTRY.register("detarget", () -> new DetargetMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SLOW_DECENT = REGISTRY.register("slow_decent", () -> new SlowDecentMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINK_LIKE = REGISTRY.register("mink_like", () -> new MinkLikeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LONG_LIFE = REGISTRY.register("long_life", () -> new LongLifeMobEffect());
}