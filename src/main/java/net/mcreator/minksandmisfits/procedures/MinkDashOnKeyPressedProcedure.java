package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import net.mcreator.minksandmisfits.network.MinksandmisfitsModVariables;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class MinkDashOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((getEntityGameType(entity) == GameType.SURVIVAL || getEntityGameType(entity) == GameType.ADVENTURE) && MinksandmisfitsModVariables.WorldVariables.get(world).Dashes > 0 && entity instanceof LivingEntity _livEnt2
				&& _livEnt2.hasEffect(MinksandmisfitsModMobEffects.MINK_LIKE) && !entity.onGround()) {
			MinksandmisfitsModVariables.WorldVariables.get(world).Dashes = MinksandmisfitsModVariables.WorldVariables.get(world).Dashes - 1;
			MinksandmisfitsModVariables.WorldVariables.get(world).markSyncDirty();
			if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.JUMP) && (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.JUMP) ? _livEnt.getEffect(MobEffects.JUMP).getAmplifier() : 0) == 0) {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			} else if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.JUMP) && (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.JUMP) ? _livEnt.getEffect(MobEffects.JUMP).getAmplifier() : 0) == 1) {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			} else {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			}
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