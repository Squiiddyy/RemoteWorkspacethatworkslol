package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.minksandmisfits.entity.FleaEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class FleaRenderer extends HumanoidMobRenderer<FleaEntity, HumanoidModel<FleaEntity>> {
	public FleaRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<FleaEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	protected void scale(FleaEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.4f, 0.4f, 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(FleaEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/mink.png");
	}
}