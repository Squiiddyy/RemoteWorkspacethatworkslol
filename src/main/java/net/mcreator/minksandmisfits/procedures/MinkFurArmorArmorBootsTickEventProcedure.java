package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class MinkFurArmorArmorBootsTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.SOFT_FALL, 10, 0, false, false));
	}
}