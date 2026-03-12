/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.minksandmisfits.client.particle.EatbugParticle;

@EventBusSubscriber(Dist.CLIENT)
public class MinksandmisfitsModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(MinksandmisfitsModParticleTypes.EATBUG.get(), EatbugParticle::provider);
	}
}