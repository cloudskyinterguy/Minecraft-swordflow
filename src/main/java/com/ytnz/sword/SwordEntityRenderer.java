package com.ytnz.sword;

import com.mojang.blaze3d.vertex.PoseStack;
import com.ytnz.swordflow.SwordFlow;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;

public class SwordEntityRenderer extends LivingEntityRenderer<Sword, SwordRenderState,SwordModel> {

    public SwordEntityRenderer(EntityRendererProvider.Context context) {
        super(context,new SwordModel(context.bakeLayer(SwordModel.SWORD_MODEL_LAYER_KEY)),0.5f);
        this.addLayer(new SwordRenderLayer(this, context.getModelSet()));
    }

    @Override
    public void render(SwordRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SwordRenderState swordRenderState) {
        return ResourceLocation.fromNamespaceAndPath(SwordFlow.MODID,"textures/entity/" + Sword.SWORD_ENTITY_NAME + ".png");
    }

    @Override
    public void extractRenderState(Sword p_entity, SwordRenderState reusedState, float partialTick) {
        super.extractRenderState(p_entity, reusedState, partialTick);

    }

    @Override
    public SwordRenderState createRenderState() {
        return new SwordRenderState();
    }



}
