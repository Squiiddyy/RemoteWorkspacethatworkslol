/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.minksandmisfits.client.renderer.*;

@EventBusSubscriber(Dist.CLIENT)
public class MinksandmisfitsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MinksandmisfitsModEntities.BASIC_PLAYER.get(), BasicPlayerRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.HOUSE_ANCHOR.get(), HouseAnchorRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.OPOSSUM.get(), OpossumRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.MINK.get(), MinkRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.TICK.get(), FleaRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.OPOSSUM_RIDEABLE.get(), OpossumRideableRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.MUSK_RAT.get(), MuskRatRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.CRAYFISH.get(), CrayfishRenderer::new);
	}
}