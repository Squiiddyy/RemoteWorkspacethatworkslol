package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.Entity;

public class MinkPlaybackConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.isInWaterOrBubble();
	}
}