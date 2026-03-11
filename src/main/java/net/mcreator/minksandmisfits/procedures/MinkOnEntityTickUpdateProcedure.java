package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class MinkOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double L = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10, 0, false, false));
		if (entity.isInWaterOrBubble() && entity instanceof Mob _mobEnt2 && _mobEnt2.isAggressive()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10, 0, false, false));
			if (entity.getPersistentData().getDouble("minksandmisfitsTimer") == 0) {
				entity.getPersistentData().putDouble("minksandmisfitsTimer", 100);
			} else {
				entity.getPersistentData().putDouble("minksandmisfitsTimer", (entity.getPersistentData().getDouble("minksandmisfitsTimer") - 1));
			}
			if (entity.getPersistentData().getDouble("minksandmisfitsTimer") == 0) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x), (entity.getDeltaMovement().y() + entity.getLookAngle().y), (entity.getDeltaMovement().z() + entity.getLookAngle().z)));
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 10, 0, false, false));
	}
}