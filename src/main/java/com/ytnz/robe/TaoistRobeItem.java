package com.ytnz.robe;

import com.ytnz.swordflow.SwordFlow;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;

public class TaoistRobeItem extends Item {
    public static final String TAOIST_ROBE_NAME = "taoist_robe";

    public TaoistRobeItem() {
        super(new Properties().component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST)
                .setEquipSound(SoundEvents.ARMOR_EQUIP_GENERIC)
                //设置equip的位置
                .setAsset(ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(SwordFlow.MODID, TAOIST_ROBE_NAME)))
                .setAllowedEntities(EntityType.PLAYER)
                .build()
        ));
    }
}
