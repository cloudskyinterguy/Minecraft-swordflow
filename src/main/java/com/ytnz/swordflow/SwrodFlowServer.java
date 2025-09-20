package com.ytnz.swordflow;

import com.ytnz.registries.EntityRegsitries;
import com.ytnz.sword.Sword;
import com.ytnz.sword.SwordCurve;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = SwordFlow.MODID)
public class SwrodFlowServer {
    static  boolean isSwordUsed = false;
    public static List<Sword> swords = new ArrayList<>();

    @SubscribeEvent
    static void playerTick(PlayerTickEvent.Pre event) {
        if (event.getEntity() instanceof ServerPlayer){
            ServerPlayer player = (ServerPlayer) event.getEntity();
            ServerLevel level = (ServerLevel) player.level();
            List<LivingEntity> nextedEnities = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(4));
            for (Object livingEntity : nextedEnities) {
                if (isSwordUsed && !(livingEntity instanceof Sword)) {
                    LivingEntity target = (LivingEntity) livingEntity;
                    target.hurtOrSimulate(level.damageSources().playerAttack(player),1);
                }

                if (livingEntity instanceof Sword){
                    isSwordUsed = true;
                }
            }

            SwordCurve.SwordMove(swords,player.getPosition(0.5f));
        }
    }

    @SubscribeEvent
    static void swordGenerateRecord(EntityJoinLevelEvent event){
        if (event.getEntity() instanceof Sword){
            swords.add((Sword) event.getEntity());
        }
    }

    @SubscribeEvent
    static void RotateModelFromServer(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof Sword) {
            Sword sword = (Sword) event.getEntity();
            sword.setXRot(200);
            sword.setYRot(200);
        }
    }

    @SubscribeEvent
    static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegsitries.SWORD_ENTITY_TYPE.get(), Sword.createAttributes().build());
    }
}


