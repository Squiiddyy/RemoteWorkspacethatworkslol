package net.mcreator.minksandmisfits.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.EntityModel;

import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public class MinksandmisfitsModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MinksandmisfitsMod.MODID);
	public static EntityModel MinkLikeModel = null;
	public static ResourceLocation MinkkLikeTexture = null;
	public static ResourceLocation InvisibleSkin = null;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}
}