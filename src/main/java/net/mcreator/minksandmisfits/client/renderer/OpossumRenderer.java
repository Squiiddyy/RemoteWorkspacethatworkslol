package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.minksandmisfits.entity.OpossumEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class OpossumRenderer extends MobRenderer<OpossumEntity, PigModel<OpossumEntity>> {
	public OpossumRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<OpossumEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	protected void scale(OpossumEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.8f, 0.8f, 0.8f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(OpossumEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/pigbase2.png");
	}
}