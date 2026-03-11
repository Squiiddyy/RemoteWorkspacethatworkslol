package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;

public class HouseAnchorOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setInvisible(true);
	}
}