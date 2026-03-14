package net.mcreator.minksandmisfits.procedures;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.minksandmisfits.network.MinksandmisfitsModVariables;
import net.mcreator.minksandmisfits.client.model.ModelMinkLike;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class SetMinklikeProcedure {
	@SubscribeEvent
	public static void afterModelRegistration(EntityRenderersEvent.AddLayers event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		MinksandmisfitsModVariables.MinkLikeModel = new ModelMinkLike(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMinkLike.LAYER_LOCATION));
		MinksandmisfitsModVariables.MinkkLikeTexture = ResourceLocation.fromNamespaceAndPath("minksandmisfits", "textures/entities/minklike.png");
		MinksandmisfitsModVariables.InvisibleSkin = ResourceLocation.fromNamespaceAndPath("minksandmisfits", "textures/entities/invisibleskin.png");
	}
}