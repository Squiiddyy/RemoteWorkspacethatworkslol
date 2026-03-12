package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.minksandmisfits.procedures.MinkHasArmorProcedure;
import net.mcreator.minksandmisfits.procedures.IsColor2Procedure;
import net.mcreator.minksandmisfits.procedures.IsColor1Procedure;
import net.mcreator.minksandmisfits.entity.MinkEntity;
import net.mcreator.minksandmisfits.client.model.Modelmink;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MinkRenderer extends MobRenderer<MinkEntity, Modelmink<MinkEntity>> {
	public MinkRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmink<MinkEntity>(context.bakeLayer(Modelmink.LAYER_LOCATION)), 0.4f);
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minktext1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IsColor1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelmink(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmink.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minktext1white.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IsColor2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelmink(Minecraft.getInstance().getEntityModels().bakeLayer(Modelmink.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minkarmor.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (MinkHasArmorProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
				}
			}
		});
	}

	@Override
	protected void scale(MinkEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9f, 0.9f, 0.9f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(MinkEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/minktext1.png");
	}
}