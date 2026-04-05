package net.mcreator.minksandmisfits.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.registries.Registries;

import net.mcreator.minksandmisfits.init.MinksandmisfitsModMobEffects;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModEntities;
import net.mcreator.minksandmisfits.entity.SuperSlashEntity;
import net.mcreator.minksandmisfits.MinksandmisfitsMod;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class MinklikeSuperSlashProcedure {
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickEmpty event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		PacketDistributor.sendToServer(new MinklikeSuperSlashMessage());
		execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	@EventBusSubscriber
	public record MinklikeSuperSlashMessage() implements CustomPacketPayload {
		public static final Type<MinklikeSuperSlashMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MinksandmisfitsMod.MODID, "procedure_minklike_super_slash"));
		public static final StreamCodec<RegistryFriendlyByteBuf, MinklikeSuperSlashMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MinklikeSuperSlashMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new MinklikeSuperSlashMessage());

		@Override
		public Type<MinklikeSuperSlashMessage> type() {
			return TYPE;
		}

		public static void handleData(final MinklikeSuperSlashMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute(context.player().level(), context.player().getX(), context.player().getY(), context.player().getZ(), context.player());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			MinksandmisfitsMod.addNetworkMessage(MinklikeSuperSlashMessage.TYPE, MinklikeSuperSlashMessage.STREAM_CODEC, MinklikeSuperSlashMessage::handleData);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MinksandmisfitsModMobEffects.SUPER_SLASH_COOLDOWN)) && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MinksandmisfitsModMobEffects.MINK_LIKE)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MinksandmisfitsModMobEffects.SUPER_SLASH_COOLDOWN, 100, 0, false, false));
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof ServerLevel projectileLevel) {
				Projectile _entityToSpawn = initArrowProjectile(new SuperSlashEntity(MinksandmisfitsModEntities.SUPER_SLASH.get(), 0, 0, 0, projectileLevel, createArrowWeaponItemStack(projectileLevel, 0, (byte) 5)), entity, 20, true, false, false,
						AbstractArrow.Pickup.DISALLOWED);
				_entityToSpawn.setPos(x, (y + 1), z);
				_entityToSpawn.shoot((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z), (float) 0.81, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
		ItemStack weapon = new ItemStack(Items.ARROW);
		if (knockback > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
		if (piercing > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), piercing);
		return weapon;
	}
}