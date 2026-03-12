package net.mcreator.minksandmisfits.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public class SnowBoostMobEffect extends MobEffect {
	public SnowBoostMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.snow_boost_0"), 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_EFFICIENCY, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.snow_boost_1"), 1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
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
		}, MinksandmisfitsModMobEffects.SNOW_BOOST.get());
	}
}