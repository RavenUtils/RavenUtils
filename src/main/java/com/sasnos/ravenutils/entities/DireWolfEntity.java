package com.sasnos.ravenutils.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DireWolfEntity extends WolfEntity {

  public DireWolfEntity(EntityType<? extends WolfEntity> type, World worldIn) {
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
    super.registerGoals();
    this.goalSelector.addGoal(1, new SwimGoal(this));
    // todo add goals
    // this.goalSelector.addGoal(2, new WolfEntity.AvoidEntityGoal(this, IronGolemEntity.class, 24.0F, 1.5D, 1.5D));
    // this.goalSelector.addGoal(3, new WolfEntity.AvoidEntityGoal(this, PillagerEntity.class, 12.0F, 1.5D, 1.5D));
    this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
    this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
    this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 8.0F));
    this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
    this.targetSelector.addGoal(3, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, PREY_SELECTOR));
    this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
  }

  @Override
  protected SoundEvent getAmbientSound() {
    if (this.random.nextInt(3) == 0) {
      return this.isTame() && this.getHealth() < 10.0F ? SoundEvents.WOLF_WHINE : SoundEvents.WOLF_PANT;
    } else {
      return SoundEvents.WOLF_GROWL;
    }
  }

  // todo Direwolf is no tamable or breedable!
}
