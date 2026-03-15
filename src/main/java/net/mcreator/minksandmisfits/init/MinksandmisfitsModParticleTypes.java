/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinksandmisfitsModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EATBUG = REGISTRY.register("eatbug", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LIFE_PART = REGISTRY.register("life_part", () -> new SimpleParticleType(false));
}