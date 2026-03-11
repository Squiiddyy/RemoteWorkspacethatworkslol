package net.mcreator.minksandmisfits.potion;

import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class MinkFastSwimmerMobEffect extends MobEffect {
	public MinkFastSwimmerMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
		this.addAttributeModifier(NeoForgeMod.SWIM_SPEED, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_fast_swimmer_0"), 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.WATER_MOVEMENT_EFFICIENCY, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.mink_fast_swimmer_1"), 5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}