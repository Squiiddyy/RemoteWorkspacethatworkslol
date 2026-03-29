package net.mcreator.minksandmisfits.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.minksandmisfits.procedures.MinkDashOnKeyPressedProcedure;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public record MinkDashMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<MinkDashMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "key_mink_dash"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MinkDashMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MinkDashMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new MinkDashMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<MinkDashMessage> type() {
		return TYPE;
	}

	public static void handleData(final MinkDashMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			MinkDashOnKeyPressedProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinksandmisfitsMod.addNetworkMessage(MinkDashMessage.TYPE, MinkDashMessage.STREAM_CODEC, MinkDashMessage::handleData);
	}
}