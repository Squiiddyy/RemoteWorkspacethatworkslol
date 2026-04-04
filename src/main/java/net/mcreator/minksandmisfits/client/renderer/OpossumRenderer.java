package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.minksandmisfits.entity.OpossumEntity;
import net.mcreator.minksandmisfits.client.model.ModelOpossum;

import com.mojang.blaze3d.vertex.PoseStack;

public class OpossumRenderer extends MobRenderer<OpossumEntity, ModelOpossum<OpossumEntity>> {
	public OpossumRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelOpossum<OpossumEntity>(context.bakeLayer(ModelOpossum.LAYER_LOCATION)), 0.55f);
	}

	@Override
	protected void scale(OpossumEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.2f, 1.2f, 1.2f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(OpossumEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/optexture.png");
	}
}