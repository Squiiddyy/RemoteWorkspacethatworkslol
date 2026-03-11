package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;

import net.mcreator.minksandmisfits.entity.HouseAnchorEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class HouseAnchorRenderer extends MobRenderer<HouseAnchorEntity, SlimeModel<HouseAnchorEntity>> {
	public HouseAnchorRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel<HouseAnchorEntity>(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	@Override
	protected void scale(HouseAnchorEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.1f, 0.1f, 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(HouseAnchorEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/steve-texture_orig.png");
	}

	@Override
	protected boolean isBodyVisible(HouseAnchorEntity entity) {
		return false;
	}
}