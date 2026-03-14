package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.OpossumRideableEntity;
import net.mcreator.minksandmisfits.entity.OpossumEntity;

import java.util.Comparator;

public class OpossumOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((findEntityInWorldRange(world, OpossumEntity.class, x, y, z, 4)) instanceof LivingEntity _livEnt1 && _livEnt1.isBaby()) {
			entity.startRiding((findEntityInWorldRange(world, OpossumRideableEntity.class, x, y, z, 4)));
		}
		if (!((findEntityInWorldRange(world, OpossumEntity.class, x, y, z, 4)) instanceof LivingEntity _livEnt5 && _livEnt5.isBaby())) {
			entity.stopRiding();
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}