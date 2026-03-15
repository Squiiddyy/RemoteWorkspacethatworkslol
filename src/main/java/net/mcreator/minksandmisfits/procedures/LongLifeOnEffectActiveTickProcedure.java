package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class LongLifeOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("LL1", (entity.getPersistentData().getDouble("LL1") + 1));
		if (entity.getPersistentData().getDouble("LL1") % 80 == 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1
						+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MinksandmisfitsModMobEffects.LONG_LIFE) ? _livEnt.getEffect(MinksandmisfitsModMobEffects.LONG_LIFE).getAmplifier() : 0));
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MinksandmisfitsModMobEffects.LONG_LIFE) ? _livEnt.getEffect(MinksandmisfitsModMobEffects.LONG_LIFE).getDuration() : 0) < 100) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.LONG_LIFE, 3000, 0, true, true));
		}
	}
}