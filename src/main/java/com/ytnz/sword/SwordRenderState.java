package com.ytnz.sword;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.BlockPos;

public class SwordRenderState extends LivingEntityRenderState {

    public BlockPos getPosition() {
        return Minecraft.getInstance().player.blockPosition();
    }

}
