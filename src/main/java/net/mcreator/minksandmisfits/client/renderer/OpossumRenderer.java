package net.mcreator.minksandmisfits.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.minksandmisfits.procedures.TotemCheckProcedure;
import net.mcreator.minksandmisfits.procedures.CollarCheckProcedure;
import net.mcreator.minksandmisfits.entity.OpossumEntity;
import net.mcreator.minksandmisfits.client.model.animations.OpossumAnimation;
import net.mcreator.minksandmisfits.client.model.ModelOpossum;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OpossumRenderer extends MobRenderer<OpossumEntity, ModelOpossum<OpossumEntity>> {
	public OpossumRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelOpossum.LAYER_LOCATION)), 0.55f);
		this.addLayer(new RenderLayer<OpossumEntity, ModelOpossum<OpossumEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/opcollar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, OpossumEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
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
		this.addLayer(new RenderLayer<OpossumEntity, ModelOpossum<OpossumEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("minksandmisfits:textures/entities/optotem.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, OpossumEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
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
	}

	@Override
	protected void scale(OpossumEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.25f, 1.25f, 1.25f);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}

	@Override
	public ResourceLocation getTextureLocation(OpossumEntity entity) {
		return ResourceLocation.parse("minksandmisfits:textures/entities/optexturenew.png");
	}

	private static final class AnimatedModel extends ModelOpossum<OpossumEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<OpossumEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(OpossumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, OpossumAnimation.OppossumSit, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(OpossumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}