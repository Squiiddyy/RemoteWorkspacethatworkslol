package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.OpossumRideableEntity;

public class OpossumRideablePlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof OpossumRideableEntity _datEntL0 && _datEntL0.getEntityData().get(OpossumRideableEntity.DATA_Sitting)) == true;
	}
}