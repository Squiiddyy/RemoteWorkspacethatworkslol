package net.mcreator.minksandmisfits.potion;

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
	}
}