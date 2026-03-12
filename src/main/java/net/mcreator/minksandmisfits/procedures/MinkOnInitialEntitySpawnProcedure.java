package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.minksandmisfits.entity.MinkEntity;

public class MinkOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof MinkEntity _datEntSetI)
			_datEntSetI.getEntityData().set(MinkEntity.DATA_Color, Mth.nextInt(RandomSource.create(), 1, 2));
	}
}