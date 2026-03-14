package net.mcreator.minksandmisfits.procedures;

import net.neoforged.neoforge.client.event.RenderArmEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.minksandmisfits.network.MinksandmisfitsModVariables;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class MinkLikePlayerPotionArmProcedure {
	@SubscribeEvent
	public static void onArmRendered(RenderArmEvent event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerRenderer renderer = (PlayerRenderer) mc.getEntityRenderDispatcher().getRenderer(mc.player);
		execute(event, event, mc.player, (EntityModel) renderer.getModel(), event.getPoseStack());
	}

	public static void execute(RenderArmEvent armRenderEvent, Entity entity, EntityModel entityModel, PoseStack poseStack) {
		execute(null, armRenderEvent, entity, entityModel, poseStack);
	}

	private static void execute(@Nullable Event event, RenderArmEvent armRenderEvent, Entity entity, EntityModel entityModel, PoseStack poseStack) {
		if (armRenderEvent == null || entity == null || entityModel == null || poseStack == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MinksandmisfitsModMobEffects.MINK_LIKE)) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			{
				ResourceLocation texture = MinksandmisfitsModVariables.MinkkLikeTexture;
				ModelPart part = armRenderEvent.getArm() == HumanoidArm.LEFT ? ((PlayerModel) entityModel).leftArm : ((PlayerModel) entityModel).rightArm;
				part.resetPose();
				part.render(poseStack, armRenderEvent.getMultiBufferSource().getBuffer(RenderType.entityCutoutNoCull(texture)), armRenderEvent.getPackedLight(), OverlayTexture.NO_OVERLAY);
			}
		}
	}
}