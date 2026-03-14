package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModItems;

public class FlyDashOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == MinksandmisfitsModItems.BUG_CHESTPLATE.get()
				&& !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(MinksandmisfitsModItems.BUG_CHESTPLATE.get()))) {
			entity.setDeltaMovement(new Vec3(0, 0.6, 0));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(MinksandmisfitsModItems.BUG_CHESTPLATE.get(), 500);
		}
	}
}