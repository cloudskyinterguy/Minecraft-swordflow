package com.ytnz.sword;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

public class SwordRenderLayer extends RenderLayer<SwordRenderState,SwordModel> {
    private SwordModel model;

    public SwordRenderLayer(RenderLayerParent<SwordRenderState, SwordModel> renderer, EntityModelSet entityModelSet) {
        super(renderer);
        this.model = new SwordModel(entityModelSet.bakeLayer(SwordModel.SWORD_MODEL_LAYER_KEY));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, SwordRenderState swordRenderState, float v, float v1) {
        model.renderToBuffer(poseStack,multiBufferSource.getBuffer(RenderType.CUTOUT), 8, 0);
    }
}
