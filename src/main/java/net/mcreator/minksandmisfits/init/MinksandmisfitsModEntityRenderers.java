/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.minksandmisfits.client.renderer.OpossumRenderer;
import net.mcreator.minksandmisfits.client.renderer.MinkRenderer;
import net.mcreator.minksandmisfits.client.renderer.HouseAnchorRenderer;
import net.mcreator.minksandmisfits.client.renderer.BasicPlayerRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class MinksandmisfitsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MinksandmisfitsModEntities.BASIC_PLAYER.get(), BasicPlayerRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.HOUSE_ANCHOR.get(), HouseAnchorRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.MINK.get(), MinkRenderer::new);
		event.registerEntityRenderer(MinksandmisfitsModEntities.OPOSSUM.get(), OpossumRenderer::new);
	}
}