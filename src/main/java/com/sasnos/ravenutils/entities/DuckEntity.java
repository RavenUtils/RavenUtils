package com.sasnos.ravenutils.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

public class DuckEntity extends ChickenEntity {
  private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.BREAD);
  public boolean chickenJockey = false;

  public DuckEntity(EntityType<? extends ChickenEntity> type, World worldIn) {
    super(type, worldIn);
  }

  public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
    return MobEntity
        .createMobAttributes()
        .add(Attributes.MOVEMENT_SPEED, 0.3F)
        .add(Attributes.MAX_HEALTH, 8.0D)
        .add(Attributes.ATTACK_DAMAGE, 2.0D);
  }

  @Override
  protected void registerGoals() {
    this.goalSelector.addGoal(0, new SwimGoal(this));
    this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
    this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
    this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
    this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
    this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
    this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
  }

  // todo adjust
  /*
  @Override
  public ChickenEntity createChild(ServerWorld world, AgeableEntity mate) {
    return EntityType.DUCK.create(world);
  }
  */

  // todo add suitable sounds
  /*
  @Override
  protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_DUCK_AMBIENT;
  }

  @Override
  protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
    return SoundEvents.ENTITY_DUCK_HURT;
  }

  @Override
  protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_DUCK_DEATH;
  }

  @Override
  public ChickenEntity createChild(ServerWorld world, AgeableEntity mate) {
    return EntityType.DUCK.create(world);
  }
  */
}
