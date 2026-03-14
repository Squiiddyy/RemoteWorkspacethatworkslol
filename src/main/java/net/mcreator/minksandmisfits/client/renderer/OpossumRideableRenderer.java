package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.minksandmisfits.entity.OpossumRideableEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class OpossumRideableRenderer extends MobRenderer<OpossumRideableEntity, SilverfishModel<OpossumRideableEntity>> {
	public OpossumRideableRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel<OpossumRideableEntity>(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
	}

	@Override
	protected void scale(OpossumRideableEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.1f, 1.1f, 1.1f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(OpossumRideableEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/" + entity.getTexture() + ".png");
	}
}