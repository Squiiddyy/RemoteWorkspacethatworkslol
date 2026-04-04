package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.minksandmisfits.entity.OpossumRideableEntity;
import net.mcreator.minksandmisfits.entity.OpossumEntity;

import java.util.Comparator;

public class OpossumOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isInWaterOrBubble() && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER) && (findEntityInWorldRange(world, OpossumEntity.class, x, y, z, 4)) instanceof LivingEntity _livEnt4
				&& _livEnt4.isBaby()) {
			entity.startRiding((findEntityInWorldRange(world, OpossumRideableEntity.class, x, y, z, 4)));
		}
		if (!((findEntityInWorldRange(world, OpossumEntity.class, x, y, z, 4)) instanceof LivingEntity _livEnt8 && _livEnt8.isBaby())) {
			entity.stopRiding();
		}
		if (entity.isInWaterOrBubble()) {
			entity.stopRiding();
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}