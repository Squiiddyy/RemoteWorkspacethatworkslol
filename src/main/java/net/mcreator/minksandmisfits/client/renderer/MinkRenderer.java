package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.minksandmisfits.entity.MinkEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class MinkRenderer extends MobRenderer<MinkEntity, PigModel<MinkEntity>> {
	public MinkRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<MinkEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	protected void scale(MinkEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.6f, 0.6f, 0.6f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(MinkEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/mink.png");
	}
}