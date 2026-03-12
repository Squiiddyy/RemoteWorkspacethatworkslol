package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.MinkEntity;

public class MinkHasArmorProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof MinkEntity _datEntI ? _datEntI.getEntityData().get(MinkEntity.DATA_Armor) : 0) == 1;
	}
}