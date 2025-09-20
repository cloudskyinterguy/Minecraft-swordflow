package com.ytnz.sword;

import com.ytnz.swordflow.SwordFlow;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import java.util.Random;
import java.util.Timer;

public class Sword extends LivingEntity {
    public static final String SWORD_ENTITY_NAME = "sword";

    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50.0) // 最大生命值：50（默认20）
                .add(Attributes.MOVEMENT_SPEED, 0.5) // 移动速度：0.5（默认0.7）
                .add(Attributes.ATTACK_DAMAGE, 10.0) // 攻击力：10（默认2）
                .add(Attributes.FOLLOW_RANGE, 40.0); // 追踪范围：40（默认32）
    }

    public Sword(EntityType<?> entityType, Level level) {
        super((EntityType<? extends LivingEntity>) entityType, level);

    }


    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
    }

    @Override
    public void tick() {
        super.tick();
        setNoGravity(true);
        setXRot(100);
        setCustomName(null);
        setCustomNameVisible(false);
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float v) {
        return false;
    }

    @Override
    public HumanoidArm getMainArm() {
        return null;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
}
