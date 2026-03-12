package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.minksandmisfits.entity.MinkEntity;

public class MinkOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof MinkEntity _datEntSetI)
			_datEntSetI.getEntityData().set(MinkEntity.DATA_Color, Mth.nextInt(RandomSource.create(), 1, 2));
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("minksandmisfits:somber_shore"))) {
			if (entity instanceof MinkEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MinkEntity.DATA_Color, 3);
		}
	}
}