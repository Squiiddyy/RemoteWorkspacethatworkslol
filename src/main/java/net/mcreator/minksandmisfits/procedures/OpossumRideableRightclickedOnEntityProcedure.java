package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.OpossumRideableEntity;

public class OpossumRideableRightclickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
				&& (entity instanceof OpossumRideableEntity _datEntL1 && _datEntL1.getEntityData().get(OpossumRideableEntity.DATA_Sitting)) == false) {
			if (entity instanceof OpossumRideableEntity _datEntSetL)
				_datEntSetL.getEntityData().set(OpossumRideableEntity.DATA_Sitting, true);
		} else {
			if (entity instanceof OpossumRideableEntity _datEntSetL)
				_datEntSetL.getEntityData().set(OpossumRideableEntity.DATA_Sitting, false);
		}
	}
}