package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class RaptorialClawLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MinksandmisfitsModMobEffects.BLEEDIMUNE))) {
			entity.getPersistentData().putDouble("BleedStackClaw", (entity.getPersistentData().getDouble("BleedStackClaw") + 1));
			if (entity.getPersistentData().getDouble("BleedStackClaw") == 1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.BLEEDCLAW, 80, 0));
			}
			if (entity.getPersistentData().getDouble("BleedStackClaw") == 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.BLEEDCLAW, 80, 1));
			}
			if (entity.getPersistentData().getDouble("BleedStackClaw") == 3) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.BLEEDCLAW, 80, 2));
			}
			if (entity.getPersistentData().getDouble("BleedStackClaw") == 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.BLEEDCLAW, 80, 3));
			}
			if (entity.getPersistentData().getDouble("BleedStackClaw") == 5) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.BLEEDCLAW, 80, 4));
			}
		}
	}
}