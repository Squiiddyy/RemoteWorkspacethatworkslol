package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

import net.mcreator.minksandmisfits.entity.CrayfishEntity;

public class CrayfishRenderer extends MobRenderer<CrayfishEntity, SlimeModel<CrayfishEntity>> {
	public CrayfishRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel<CrayfishEntity>(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CrayfishEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/" + entity.getTexture() + ".png");
	}
}