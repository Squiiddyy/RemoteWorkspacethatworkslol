package net.mcreator.minksandmisfits.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

public class SlowDecentMobEffect extends MobEffect {
	public SlowDecentMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.GRAVITY, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.slow_decent_0"), -0.75, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.slow_decent_1"), 5, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "effect.slow_decent_2"), -0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}