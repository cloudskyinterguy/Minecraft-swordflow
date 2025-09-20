package com.ytnz.robe;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ytnz.swordflow.SwordFlow;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TaoistRobeRenderLayer extends RenderLayer{
    private TaoistRobeModel model;

    public TaoistRobeRenderLayer(RenderLayerParent<TaoistRobeRenderState, TaoistRobeModel> renderer, EntityModelSet entityModelSet) {
        super(renderer);
        this.model = new TaoistRobeModel(entityModelSet.bakeLayer(TaoistRobeModel.TAOIST_ROBE_MODEL_KEY));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, EntityRenderState entityRenderState, float v, float v1) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath(SwordFlow.MODID,"equipment/" + TaoistRobeItem.TAOIST_ROBE_NAME + ".png");
        model.copyPropertiesTo((HumanoidModel) this.getParentModel());
        VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(multiBufferSource, RenderType.armorCutoutNoCull(resourceLocation), false);
        model.renderToBuffer(poseStack,vertexConsumer,i, OverlayTexture.NO_OVERLAY);
    }
}
