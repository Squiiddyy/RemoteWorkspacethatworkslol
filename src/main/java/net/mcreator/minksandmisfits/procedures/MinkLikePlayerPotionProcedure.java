package net.mcreator.minksandmisfits.procedures;

import org.joml.Vector3f;

import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.EntityModel;

import net.mcreator.minksandmisfits.network.MinksandmisfitsModVariables;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModHumanoidModels;

import javax.annotation.Nullable;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Collection;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class MinkLikePlayerPotionProcedure {
	@SubscribeEvent
	public static void onPlayerRendered(RenderPlayerEvent.Pre event) {
		execute(event, event.getEntity(), (EntityModel) event.getRenderer().getModel(), event);
	}

	public static void offsetScale(PlayerModel model, Vector3f offset) {
		model.head.offsetScale(offset);
		model.head.y += offset.x() > 0 ? 0.05 : -0.05;
		model.body.offsetScale(offset);
		model.leftArm.offsetScale(offset);
		model.rightArm.offsetScale(offset);
		model.leftLeg.offsetScale(offset);
		model.rightLeg.offsetScale(offset);
		model.hat.offsetScale(offset);
		model.hat.y += offset.x() > 0 ? 0.05 : -0.05;
		model.jacket.offsetScale(offset);
		model.leftSleeve.offsetScale(offset);
		model.rightSleeve.offsetScale(offset);
		model.leftPants.offsetScale(offset);
		model.rightPants.offsetScale(offset);
	}

	public static Collection<Runnable> capes = new ConcurrentLinkedQueue<>();

	public static void renderHumanoid(RenderPlayerEvent playerRenderEvent, PlayerModel model, VertexConsumer vertexConsumer) {
		PoseStack poseStack = playerRenderEvent.getPoseStack();
		((HumanoidModel) playerRenderEvent.getRenderer().getModel()).copyPropertiesTo(model);
		AbstractClientPlayer eventEntity_ = (AbstractClientPlayer) playerRenderEvent.getEntity();
		float partialTick = playerRenderEvent.getPartialTick();
		model.attackTime = eventEntity_.getAttackAnim(partialTick);
		float limbSwing = eventEntity_.walkAnimation.position(partialTick);
		float limbSwingAmount = eventEntity_.walkAnimation.speed(partialTick);
		float ageInTicks = eventEntity_.tickCount + partialTick;
		float interpolatedBodyYaw = Mth.rotLerp(partialTick, eventEntity_.yBodyRotO, eventEntity_.yBodyRot);
		float interpolatedHeadYaw = Mth.rotLerp(partialTick, eventEntity_.yHeadRotO, eventEntity_.yHeadRot);
		float netHeadYaw = interpolatedHeadYaw - interpolatedBodyYaw;
		float headPitch = Mth.lerp(partialTick, eventEntity_.xRotO, eventEntity_.getXRot());
		poseStack.pushPose();
		model.prepareMobModel(eventEntity_, limbSwing, limbSwingAmount, partialTick);
		CompoundTag playerData = eventEntity_.getPersistentData();
		float oldAnimationProgress = 0;
		float oldAgeInTicks = 0;
		if (playerData.contains("PlayerAnimationProgress")) {
			oldAnimationProgress = playerData.getFloat("PlayerAnimationProgress");
			oldAgeInTicks = playerData.getFloat("LastTickTime");
		}
		model.setupAnim(eventEntity_, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		if (playerData.contains("PlayerAnimationProgress") && playerData.getFloat("PlayerAnimationProgress") > 0) {
			playerData.putFloat("PlayerAnimationProgress", oldAnimationProgress);
			playerData.putFloat("LastTickTime", oldAgeInTicks);
		} else if (oldAnimationProgress > 0) {
			model.setupAnim(eventEntity_, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
		playerRenderEvent.getRenderer().setupRotations(eventEntity_, poseStack, ageInTicks, interpolatedBodyYaw, partialTick, 0);
		poseStack.scale(-0.938f, -0.938f, 0.938f);
		poseStack.translate(0.0D, -1.501, 0.0D);
		Vector3f offset = new Vector3f(0.015f);
		offsetScale(model, offset);
		if (!capes.isEmpty()) {
			capes.forEach(cape -> cape.run());
			capes.clear();
		}
		model.renderToBuffer(poseStack, vertexConsumer, playerRenderEvent.getPackedLight(), LivingEntityRenderer.getOverlayCoords(eventEntity_, 0));
		offset.negate();
		offsetScale(model, offset);
		poseStack.popPose();
	}

	public static void renderEntity(RenderPlayerEvent playerRenderEvent, EntityModel model, VertexConsumer vertexConsumer) {
		PoseStack poseStack = playerRenderEvent.getPoseStack();
		playerRenderEvent.getRenderer().getModel().copyPropertiesTo(model);
		AbstractClientPlayer eventEntity_ = (AbstractClientPlayer) playerRenderEvent.getEntity();
		float partialTick = playerRenderEvent.getPartialTick();
		float limbSwing = eventEntity_.walkAnimation.position(partialTick);
		float limbSwingAmount = eventEntity_.walkAnimation.speed(partialTick);
		float ageInTicks = eventEntity_.tickCount + partialTick;
		float interpolatedBodyYaw = Mth.rotLerp(partialTick, eventEntity_.yBodyRotO, eventEntity_.yBodyRot);
		float interpolatedHeadYaw = Mth.rotLerp(partialTick, eventEntity_.yHeadRotO, eventEntity_.yHeadRot);
		float netHeadYaw = interpolatedHeadYaw - interpolatedBodyYaw;
		float headPitch = Mth.lerp(partialTick, eventEntity_.xRotO, eventEntity_.getXRot());
		poseStack.pushPose();
		playerRenderEvent.getRenderer().setupRotations(eventEntity_, poseStack, ageInTicks, interpolatedBodyYaw, partialTick, 0);
		poseStack.scale(-0.938f, -0.938f, 0.938f);
		poseStack.translate(0.0D, -1.501, 0.0D);
		model.prepareMobModel(eventEntity_, limbSwing, limbSwingAmount, partialTick);
		model.setupAnim(eventEntity_, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		model.renderToBuffer(poseStack, vertexConsumer, playerRenderEvent.getPackedLight(), LivingEntityRenderer.getOverlayCoords(eventEntity_, 0));
		poseStack.popPose();
	}

	public static void execute(Entity entity, EntityModel entityModel, RenderPlayerEvent playerRenderEvent) {
		execute(null, entity, entityModel, playerRenderEvent);
	}

	private static void execute(@Nullable Event event, Entity entity, EntityModel entityModel, RenderPlayerEvent playerRenderEvent) {
		if (entity == null || entityModel == null || playerRenderEvent == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MinksandmisfitsModMobEffects.MINK_LIKE)) {
			{
				ResourceLocation texture = MinksandmisfitsModVariables.MinkkLikeTexture;
				renderHumanoid(playerRenderEvent, MinksandmisfitsModHumanoidModels.MINK_LIKE_MODEL, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
			}
			{
				ResourceLocation texture = MinksandmisfitsModVariables.InvisibleSkin;
				renderHumanoid(playerRenderEvent, (PlayerModel) entityModel, playerRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)));
			}
			((PlayerModel) entityModel).rightSleeve.visible = false;
			((PlayerModel) entityModel).leftSleeve.visible = false;
			((PlayerModel) entityModel).hat.visible = false;
			((PlayerModel) entityModel).rightLeg.visible = false;
			((PlayerModel) entityModel).rightPants.visible = false;
			((PlayerModel) entityModel).leftLeg.visible = false;
			((PlayerModel) entityModel).leftPants.visible = false;
			((PlayerModel) entityModel).jacket.visible = false;
			MinksandmisfitsModHumanoidModels.MINK_LIKE_MODEL.head.visible = true;
			MinksandmisfitsModHumanoidModels.MINK_LIKE_MODEL.leftArm.visible = true;
			MinksandmisfitsModHumanoidModels.MINK_LIKE_MODEL.rightArm.visible = true;
		}
	}
}