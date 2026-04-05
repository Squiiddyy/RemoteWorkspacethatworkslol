package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.entity.OpossumEntity;

public class OpossumRightclickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
				&& (entity instanceof OpossumEntity _datEntL1 && _datEntL1.getEntityData().get(OpossumEntity.DATA_Sitting)) == false) {
			if (entity instanceof OpossumEntity _datEntSetL)
				_datEntSetL.getEntityData().set(OpossumEntity.DATA_Sitting, true);
		} else {
			if (entity instanceof OpossumEntity _datEntSetL)
				_datEntSetL.getEntityData().set(OpossumEntity.DATA_Sitting, false);
		}
	}
}