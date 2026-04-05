/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.procedures.BleedEffectExpiresProcedure;
import net.mcreator.minksandmisfits.potion.*;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public class MinksandmisfitsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> MINK_FAST_SWIMMER = REGISTRY.register("mink_fast_swimmer", () -> new MinkFastSwimmerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SOFT_FALL = REGISTRY.register("soft_fall", () -> new SoftFallMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SNOW_BOOST = REGISTRY.register("snow_boost", () -> new SnowBoostMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> DETARGET = REGISTRY.register("detarget", () -> new DetargetMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINK_LIKE = REGISTRY.register("mink_like", () -> new MinkLikeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LONG_LIFE = REGISTRY.register("long_life", () -> new LongLifeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MINK_WATER_POWER = REGISTRY.register("mink_water_power", () -> new MinkWaterPowerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUPER_SLASH_COOLDOWN = REGISTRY.register("super_slash_cooldown", () -> new SuperSlashCooldownMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDCLAW = REGISTRY.register("bleedclaw", () -> new BleedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDIMUNE = REGISTRY.register("bleedimune", () -> new BleedimuneMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(BLEEDCLAW)) {
			BleedEffectExpiresProcedure.execute(entity.level(), entity);
		}
	}
}