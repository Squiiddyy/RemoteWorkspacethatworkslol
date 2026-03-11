package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class MinkSwimProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.isInWater() && !(entity instanceof Mob _mobEnt1 && _mobEnt1.isAggressive())) == true;
	}
}