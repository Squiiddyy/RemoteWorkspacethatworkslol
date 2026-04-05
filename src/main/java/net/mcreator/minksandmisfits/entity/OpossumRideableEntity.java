package net.mcreator.minksandmisfits.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.minksandmisfits.procedures.OpossumRideableSitCheckProcedure;
import net.mcreator.minksandmisfits.procedures.OpossumRideableRightclickedOnEntityProcedure;
import net.mcreator.minksandmisfits.procedures.OpossumRideablePlaybackConditionProcedure;
import net.mcreator.minksandmisfits.procedures.OpossumRideableOnInitialEntitySpawnProcedure;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModItems;
import net.mcreator.minksandmisfits.init.MinksandmisfitsModEntities;

import javax.annotation.Nullable;

public class OpossumRideableEntity extends TamableAnimal {
	public static final EntityDataAccessor<Boolean> DATA_Sitting = SynchedEntityData.defineId(OpossumRideableEntity.class, EntityDataSerializers.BOOLEAN);
	public final AnimationState animationState0 = new AnimationState();

	public OpossumRideableEntity(EntityType<OpossumRideableEntity> type, Level world) {
		super(type, world);
		xpReward = 2;
		setNoAi(false);
		refreshDimensions();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Sitting, false);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1.25, (float) 10, (float) 1.5) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new TemptGoal(this, 1, Ingredient.of(MinksandmisfitsModItems.GRAPE.get()), false) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new TemptGoal(this, 1, Ingredient.of(MinksandmisfitsModItems.ROASTED_BUG.get()), false) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(6, new TemptGoal(this, 1, Ingredient.of(Items.APPLE), false) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new TemptGoal(this, 1, Ingredient.of(Items.SALMON), false) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new FloatGoal(this));
		this.goalSelector.addGoal(9, new BreathAirGoal(this));
		this.goalSelector.addGoal(10, new BreedGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, Spider.class, true, true) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(12, new NearestAttackableTargetGoal(this, FleaEntity.class, true, true) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(13, new NearestAttackableTargetGoal(this, CaveSpider.class, true, true) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(14, new NearestAttackableTargetGoal(this, Silverfish.class, true, true) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(15, new NearestAttackableTargetGoal(this, Endermite.class, true, true) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(16, new PanicGoal(this, 1.25) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(17, new MeleeAttackGoal(this, 1.36, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < 3.0625 && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(18, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(19, new RandomSwimmingGoal(this, 1, 40) {
			@Override
			public boolean canUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = OpossumRideableEntity.this.getX();
				double y = OpossumRideableEntity.this.getY();
				double z = OpossumRideableEntity.this.getZ();
				Entity entity = OpossumRideableEntity.this;
				Level world = OpossumRideableEntity.this.level();
				return super.canContinueToUse() && OpossumRideableSitCheckProcedure.execute(entity);
			}
		});
	}

	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float f) {
		return super.getPassengerAttachmentPoint(entity, dimensions, f).add(0, -0.2f, 0);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("minksandmisfits:minkhiss"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.silverfish.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.silverfish.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		OpossumRideableOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ());
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("DataSitting", this.entityData.get(DATA_Sitting));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataSitting"))
			this.entityData.set(DATA_Sitting, compound.getBoolean("DataSitting"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						FoodProperties foodproperties = itemstack.getFoodProperties(this);
						float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
						this.heal(nutrition);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.sidedSuccess(this.level().isClientSide());
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.sidedSuccess(this.level().isClientSide());
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		OpossumRideableRightclickedOnEntityProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(OpossumRideablePlaybackConditionProcedure.execute(this), this.tickCount);
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		OpossumRideableEntity retval = MinksandmisfitsModEntities.OPOSSUM_RIDEABLE.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(new ItemStack(Items.SALMON), new ItemStack(Items.APPLE), new ItemStack(MinksandmisfitsModItems.GRAPE.get()), new ItemStack(MinksandmisfitsModItems.ROASTED_BUG.get())).test(stack);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(1.25f);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(MinksandmisfitsModEntities.OPOSSUM_RIDEABLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.24);
		builder = builder.add(Attributes.MAX_HEALTH, 8);
		builder = builder.add(Attributes.ARMOR, 0.5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 20);
		builder = builder.add(Attributes.FOLLOW_RANGE, 20);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.4);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.2);
		return builder;
	}
}