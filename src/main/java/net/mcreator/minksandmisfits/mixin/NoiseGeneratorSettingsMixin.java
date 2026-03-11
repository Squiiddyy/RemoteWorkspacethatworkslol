package net.mcreator.minksandmisfits.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements MinksandmisfitsModBiomes.MinksandmisfitsModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> minksandmisfits_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.minksandmisfits_dimensionTypeReference != null) {
			retval = MinksandmisfitsModBiomes.adaptSurfaceRule(retval, this.minksandmisfits_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setminksandmisfitsDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.minksandmisfits_dimensionTypeReference = dimensionType;
	}
}