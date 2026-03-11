package net.mcreator.minksandmisfits.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

public class BasicPlayerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.9) {
			entity.setCustomName(Component.literal("Steve"));
		} else if (Math.random() < 0.22) {
			entity.setCustomName(Component.literal("Steven"));
		}
		if (Math.random() < 0.15) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack2 = new ItemStack(Items.WOODEN_PICKAXE).copy();
				_setstack2.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack2);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if (Math.random() < 0.25) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack3 = new ItemStack(Items.TORCH).copy();
				_setstack3.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack3);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}