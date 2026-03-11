package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.minksandmisfits.entity.MinkEntity;

public class MinkRenderer extends MobRenderer<MinkEntity, SpiderModel<MinkEntity>> {
	public MinkRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<MinkEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MinkEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/steve-texture_orig.png");
	}
}