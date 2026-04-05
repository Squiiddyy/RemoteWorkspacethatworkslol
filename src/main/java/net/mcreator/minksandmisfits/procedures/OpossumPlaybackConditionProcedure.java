package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.OpossumEntity;

public class OpossumPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof OpossumEntity _datEntL0 && _datEntL0.getEntityData().get(OpossumEntity.DATA_Sitting)) == true;
	}
}