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
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.minksandmisfits.procedures.*;
import net.mcreator.minksandmisfits.entity.MinkEntity;
import net.mcreator.minksandmisfits.client.model.animations.minkAnimation;
import net.mcreator.minksandmisfits.client.model.Modelmink;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MinkRenderer extends MobRenderer<MinkEntity, Modelmink<MinkEntity>> {
	public MinkRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelmink.LAYER_LOCATION)), 0.4f);
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
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
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
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minktext1somber.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IsSomberColorProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minktext1albinofinal.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IsColor3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
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
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minkcollar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CollarCheckProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
				}
			}
		});
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minktotem.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (TotemCheckProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
				}
			}
		});
		this.addLayer(new RenderLayer<MinkEntity, Modelmink<MinkEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/minktextsombereyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MinkEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IsSomberColorProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	protected void scale(MinkEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(MinkEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/minktext1.png");
	}

	private static final class AnimatedModel extends Modelmink<MinkEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MinkEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MinkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, minkAnimation.MinkSit, ageInTicks, 1f);
				if (MinkPlaybackConditionProcedure.execute(entity))
					this.animateWalk(minkAnimation.MinkSwim, limbSwing, limbSwingAmount, 1f, 100f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(MinkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}