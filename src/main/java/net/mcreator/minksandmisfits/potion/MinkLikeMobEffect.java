package net.mcreator.minksandmisfits.potion;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinkLikeMobEffect extends MobEffect {
	public MinkLikeMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_like_0"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_like_1"), -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_like_2"), 1, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.WATER_MOVEMENT_EFFICIENCY, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_like_3"), 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_like_4"), 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.OXYGEN_BONUS, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_like_5"), 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}