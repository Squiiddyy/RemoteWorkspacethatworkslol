package net.mcreator.minksandmisfits.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class SinkerMobEffect extends MobEffect {
	public SinkerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.sinker_0"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.WATER_MOVEMENT_EFFICIENCY, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.sinker_1"), 5, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}