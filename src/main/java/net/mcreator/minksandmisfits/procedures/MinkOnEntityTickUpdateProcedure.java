package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModItems;

public class MinkOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double L = 0;
		if (entity.isInWaterOrBubble()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.MINK_FAST_SWIMMER, 10, 0, false, false));
			if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.MINK_WATER_POWER, 1, 0, false, false));
			}
		}
		if (entity.isInWaterOrBubble() && entity instanceof Mob _mobEnt5 && _mobEnt5.isAggressive()) {
			if (entity.getPersistentData().getDouble("minksandmisfitsTimer") == 0) {
				entity.getPersistentData().putDouble("minksandmisfitsTimer", 100);
			} else {
				entity.getPersistentData().putDouble("minksandmisfitsTimer", (entity.getPersistentData().getDouble("minksandmisfitsTimer") - 1));
			}
			if (entity.getPersistentData().getDouble("minksandmisfitsTimer") == 0) {
				if (Math.random() < 0.8) {
					entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.4), (entity.getLookAngle().y * 1.2), (entity.getLookAngle().z * 0.4)));
				}
			}
		}
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