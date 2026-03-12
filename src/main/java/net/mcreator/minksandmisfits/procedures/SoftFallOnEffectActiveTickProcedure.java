package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

public class SoftFallOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.POWDER_SNOW || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POWDER_SNOW) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.SNOW_BOOST, 1, 0, false, false));
		}
	}
}