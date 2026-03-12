/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.entity.OpossumEntity;
import net.mcreator.minksandmisfits.entity.MinkEntity;
import net.mcreator.minksandmisfits.entity.HouseAnchorEntity;
import net.mcreator.minksandmisfits.entity.BasicPlayerEntity;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public class MinksandmisfitsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, MinksandmisfitsMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<BasicPlayerEntity>> BASIC_PLAYER = register("basic_player",
			EntityType.Builder.<BasicPlayerEntity>of(BasicPlayerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<HouseAnchorEntity>> HOUSE_ANCHOR = register("house_anchor",
			EntityType.Builder.<HouseAnchorEntity>of(HouseAnchorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<OpossumEntity>> OPOSSUM = register("opossum",
			EntityType.Builder.<OpossumEntity>of(OpossumEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.4f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<MinkEntity>> MINK = register("mink",
			EntityType.Builder.<MinkEntity>of(MinkEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.9f, 0.9f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		BasicPlayerEntity.init(event);
		HouseAnchorEntity.init(event);
		OpossumEntity.init(event);
		MinkEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BASIC_PLAYER.get(), BasicPlayerEntity.createAttributes().build());
		event.put(HOUSE_ANCHOR.get(), HouseAnchorEntity.createAttributes().build());
		event.put(OPOSSUM.get(), OpossumEntity.createAttributes().build());
		event.put(MINK.get(), MinkEntity.createAttributes().build());
	}
}