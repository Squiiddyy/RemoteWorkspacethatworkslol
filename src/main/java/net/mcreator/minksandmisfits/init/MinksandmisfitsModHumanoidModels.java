package net.mcreator.minksandmisfits.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.Minecraft;

import net.mcreator.minksandmisfits.client.model.ModelMinkLike;

import java.util.Map;
import java.util.Collections;

@EventBusSubscriber(Dist.CLIENT)
public class MinksandmisfitsModHumanoidModels {
	public static PlayerModel MINK_LIKE_MODEL;

	@SubscribeEvent
	public static void initModels(EntityRenderersEvent.AddLayers event) {
		ModelMinkLike mink_like_model_temp = new ModelMinkLike(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMinkLike.LAYER_LOCATION));
		MINK_LIKE_MODEL = new PlayerModel(new ModelPart(Collections.emptyList(),
				Map.ofEntries(Map.entry("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("head", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("body", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_sleeve", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("left_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("right_pants", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("jacket", new ModelPart(Collections.emptyList(), Collections.emptyMap())),
						Map.entry("cloak", new ModelPart(Collections.emptyList(), Collections.emptyMap())), Map.entry("ear", new ModelPart(Collections.emptyList(), Collections.emptyMap())))),
				false);
	}
}