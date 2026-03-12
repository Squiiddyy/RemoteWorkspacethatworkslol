package net.mcreator.minksandmisfits.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minksandmisfits.procedures.SoftFallOnEffectActiveTickProcedure;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public class SoftFallMobEffect extends MobEffect {
	public SoftFallMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.soft_fall_0"), 1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.soft_fall_1"), -0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		SoftFallOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, MinksandmisfitsModMobEffects.SOFT_FALL.get());
	}
}