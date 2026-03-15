package net.mcreator.minksandmisfits.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.minksandmisfits.procedures.LongLifeOnEffectActiveTickProcedure;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModParticleTypes;

public class LongLifeMobEffect extends MobEffect {
	public LongLifeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9702062);
	}

	@Override
	public ParticleOptions createParticleOptions(MobEffectInstance mobEffectInstance) {
		return (SimpleParticleType) (MinksandmisfitsModParticleTypes.LIFE_PART.get());
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		LongLifeOnEffectActiveTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}