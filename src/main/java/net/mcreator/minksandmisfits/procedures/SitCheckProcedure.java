package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.MinkEntity;

public class SitCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !((entity instanceof MinkEntity _datEntL0 && _datEntL0.getEntityData().get(MinkEntity.DATA_Sitting)) == true);
	}
}