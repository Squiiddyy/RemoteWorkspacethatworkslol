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

import net.mcreator.minksandmisfits.entity.OpossumRideableEntity;
import net.mcreator.minksandmisfits.entity.OpossumEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OpossumTameHealthProcedure {
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
		if (entity instanceof OpossumEntity || entity instanceof OpossumRideableEntity) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity2.getAttribute(Attributes.MAX_HEALTH).setBaseValue(16);
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
				_livingEntity3.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(4);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 50, false, false));
		}
	}
}