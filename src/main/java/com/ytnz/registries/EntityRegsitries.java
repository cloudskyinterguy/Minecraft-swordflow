package com.ytnz.registries;

import com.ytnz.sword.Sword;
import com.ytnz.swordflow.SwordFlow;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntityRegsitries {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.createEntities(SwordFlow.MODID);

    public static final Supplier<EntityType<Sword>> SWORD_ENTITY_TYPE = ENTITY_TYPES.register(
            "sword",
            ()-> {
                return EntityType.Builder.of(Sword::new, MobCategory.MISC)
                        .sized(1.0F, 1.0F)
                        .fireImmune()
                        .clientTrackingRange(3)
                        .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("swordflow", "sword")));
            }
    );
}
