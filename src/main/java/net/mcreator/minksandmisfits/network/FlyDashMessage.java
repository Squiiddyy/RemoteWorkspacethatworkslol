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

import net.mcreator.minksandmisfits.procedures.FlyDashOnKeyPressedProcedure;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

@EventBusSubscriber
public record FlyDashMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<FlyDashMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "key_fly_dash"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FlyDashMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FlyDashMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new FlyDashMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FlyDashMessage> type() {
		return TYPE;
	}

	public static void handleData(final FlyDashMessage message, final IPayloadContext context) {
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

			FlyDashOnKeyPressedProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MinksandmisfitsMod.addNetworkMessage(FlyDashMessage.TYPE, FlyDashMessage.STREAM_CODEC, FlyDashMessage::handleData);
	}
}