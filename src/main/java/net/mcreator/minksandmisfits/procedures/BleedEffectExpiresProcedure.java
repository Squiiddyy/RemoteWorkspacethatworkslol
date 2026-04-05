package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class BleedEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("minksandmisfits:bleed_damage_claw")))),
				(float) (3 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MinksandmisfitsModMobEffects.BLEEDCLAW) ? _livEnt.getEffect(MinksandmisfitsModMobEffects.BLEEDCLAW).getAmplifier() : 0) * 3
						+ (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 2d));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.BLEEDIMUNE, 20, 0, false, false));
		entity.getPersistentData().putDouble("BleedStackClaw", 0);
	}
}