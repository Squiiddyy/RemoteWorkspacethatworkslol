package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModItems;
import net.mcreator.minksandmisfits.entity.MinkEntity;

public class MinkRightclickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) == true
				&& !(sourceentity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(Items.SHEARS))) {
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(Items.SHEARS, 1500);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fishing_bobber.throw")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.75);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.fishing_bobber.throw")), SoundSource.NEUTRAL, (float) 0.8, (float) 0.75, false);
				}
			}
			if (Math.random() < 0.65) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, (float) 0.9, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, (float) 0.9, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinksandmisfitsModItems.MINK_FUR.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinksandmisfitsModItems.MINK_ARMOR.get() && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)
				&& (entity instanceof MinkEntity _datEntI ? _datEntI.getEntityData().get(MinkEntity.DATA_Armor) : 0) != 1) == true) {
			if (!(getEntityGameType(sourceentity) == GameType.CREATIVE)) {
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			}
			if (entity instanceof MinkEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MinkEntity.DATA_Armor, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.wolf_armor.repair")), SoundSource.NEUTRAL, (float) 0.8, (float) 1.1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.wolf_armor.repair")), SoundSource.NEUTRAL, (float) 0.8, (float) 1.1, false);
				}
			}
			if (entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(Attributes.ARMOR))
				_livingEntity17.getAttribute(Attributes.ARMOR).setBaseValue(14);
			if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))
				_livingEntity18.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(7);
			if (entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE))
				_livingEntity19.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5);
			if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE))
				_livingEntity20.getAttribute(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE).setBaseValue(0.5);
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}