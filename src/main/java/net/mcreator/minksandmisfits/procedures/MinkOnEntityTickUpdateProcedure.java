package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModItems;

public class MinkOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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
		if (world.dayTime() == 120 && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinksandmisfitsModItems.MINK_FUR.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinksandmisfitsModItems.MINK_FUR.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (Math.random() < 0.25) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinksandmisfitsModItems.MINK_FUR.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}