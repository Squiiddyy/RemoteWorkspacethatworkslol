package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.minksandmisfits.entity.MuskRatEntity;

public class MuskRatRenderer extends MobRenderer<MuskRatEntity, PigModel<MuskRatEntity>> {
	public MuskRatRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<MuskRatEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MuskRatEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/" + entity.getTexture() + ".png");
	}
}