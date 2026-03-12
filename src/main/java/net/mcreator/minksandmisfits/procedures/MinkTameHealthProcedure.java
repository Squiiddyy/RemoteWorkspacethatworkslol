package net.mcreator.minksandmisfits.procedures;

import net.neoforged.neoforge.event.entity.living.AnimalTameEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.minksandmisfits.entity.MinkEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class MinkTameHealthProcedure {
	@SubscribeEvent
	public static void onEntityTamed(AnimalTameEvent event) {
		execute(event, event.getAnimal());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof MinkEntity) {
			if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity1.getAttribute(Attributes.MAX_HEALTH).setBaseValue(24);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 50, false, false));
		}
	}
}