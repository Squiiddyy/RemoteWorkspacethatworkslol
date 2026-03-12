package net.mcreator.minksandmisfits.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DinoflagellateAdditionalPlacinggrowthConditionProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		boolean foundLocation = false;
		double randomRotation = 0;
		double sourcePosition = 0;
		double placePosition = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MinksandmisfitsModBlocks.DINOFLAGELLATE.get()) {
			if (true) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
	}
}