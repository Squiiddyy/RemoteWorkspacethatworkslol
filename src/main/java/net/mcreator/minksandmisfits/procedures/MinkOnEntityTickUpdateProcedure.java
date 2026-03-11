package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class MinkOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWater()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 1, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.SINKER, 1, 0, false, true));
		}
		if (entity.isInWater() && (entity.getDeltaMovement().z() >= 0.01 || entity.getDeltaMovement().x() >= 0.01) && (entity.getDeltaMovement().z() <= 0.05 || entity.getDeltaMovement().x() <= 0.5)) {
			entity.setDeltaMovement(new Vec3((entity.getLookAngle().x / 100), (entity.getLookAngle().y / 8), (entity.getLookAngle().z / 100)));
		}
	}
}