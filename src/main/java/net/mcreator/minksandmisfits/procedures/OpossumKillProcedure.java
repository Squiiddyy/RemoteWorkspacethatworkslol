package net.mcreator.minksandmisfits.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModParticleTypes;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModItems;
import net.mcreator.minksandmisfits.entity.OpossumEntity;
import net.mcreator.minksandmisfits.entity.FleaEntity;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OpossumKillProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof Spider || entity instanceof CaveSpider || entity instanceof Silverfish || entity instanceof Endermite || entity instanceof FleaEntity) && (sourceentity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)
				&& sourceentity instanceof OpossumEntity) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinksandmisfitsModItems.BUG_REMAINS.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (MinksandmisfitsModParticleTypes.EATBUG.get()), x, y, z, 6, 0.5, 0.5, 0.5, 0.5);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.8, false);
				}
			}
			MinksandmisfitsMod.queueServerWork(6, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MinksandmisfitsModParticleTypes.EATBUG.get()), x, y, z, 6, 0.5, 0.5, 0.5, 0.5);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.8, false);
					}
				}
			});
			MinksandmisfitsMod.queueServerWork(12, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (MinksandmisfitsModParticleTypes.EATBUG.get()), x, y, z, 6, 0.5, 0.5, 0.5, 0.5);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.eat")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.8, false);
					}
				}
			});
		}
		if (entity instanceof Endermite && (sourceentity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && sourceentity instanceof OpossumEntity) {
			if (Math.random() < 0.65) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.ENDER_PEARL));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}