package com.ytnz.robe;

import com.ytnz.sword.Sword;
import com.ytnz.swordflow.SwordFlow;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class TaoistRobeModel extends EntityModel<TaoistRobeRenderState> {
    private final ModelPart all;
    private final ModelPart font_left;
    private final ModelPart arm_left;
    private final ModelPart font_right;
    private final ModelPart arm_right;
    private final ModelPart shade_right;
    private final ModelPart shade_left;
    private final ModelPart back;
    private final ModelPart bone;

    public static final ModelLayerLocation TAOIST_ROBE_MODEL_KEY = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(SwordFlow.MODID, TaoistRobeItem.TAOIST_ROBE_NAME + "model"), "main"
    );


    protected TaoistRobeModel(ModelPart root) {
        super(root);
        this.all = root.getChild("all");
        this.font_left = this.all.getChild("font_left");
        this.arm_left = this.font_left.getChild("arm_left");
        this.font_right = this.all.getChild("font_right");
        this.arm_right = this.all.getChild("arm_right");
        this.shade_right = this.all.getChild("shade_right");
        this.shade_left = this.all.getChild("shade_left");
        this.back = this.all.getChild("back");
        this.bone = this.all.getChild("bone");
    }

    public static LayerDefinition createTaoistLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, -10.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition font_left = all.addOrReplaceChild("font_left", CubeListBuilder.create().texOffs(0, 52).addBox(-9.0F, -21.0F, -3.0F, 10.0F, 21.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 56).addBox(-3.0F, -25.0F, -7.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.0F, -4.0F));

        PartDefinition arm_left = font_left.addOrReplaceChild("arm_left", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 4.0F));

        PartDefinition font_right = all.addOrReplaceChild("font_right", CubeListBuilder.create().texOffs(52, 10).addBox(-13.0F, -21.0F, -7.0F, 10.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 62).addBox(-11.0F, -26.0F, -15.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arm_right = all.addOrReplaceChild("arm_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition shade_right = all.addOrReplaceChild("shade_right", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, 0.0F, 0.0F, 0.0F, -2.0508F, 0.0F));

        PartDefinition cube_r1 = shade_right.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -20.0F, -2.0F, 5.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5069F, -4.1433F, -4.8611F, 0.0F, -1.0472F, 0.0F));

        PartDefinition shade_left = all.addOrReplaceChild("shade_left", CubeListBuilder.create().texOffs(40, 62).addBox(-25.6375F, -25.1433F, -12.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(54, 63).addBox(-9.6375F, -27.1433F, -14.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(26, 24).addBox(-5.6375F, -24.1433F, -14.0F, 5.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, 0.0F, 0.0F));

        PartDefinition back = all.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(-10.6375F, -24.1433F, -10.0F, 19.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 52).addBox(-8.0F, -28.0F, -10.0F, 13.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-9.6F, -28.0F, -10.0F, 16.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition cube_r2 = back.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 44).addBox(-9.0F, -6.0F, -3.0F, 11.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6671F, -2.5798F, -7.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition cube_r3 = back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(52, 32).addBox(-4.0F, -6.0F, -3.0F, 11.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.0F, -7.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone = all.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void copyPropertiesTo(HumanoidModel model) {
        this.back.copyFrom(model.body);
        this.shade_left.copyFrom(model.leftArm);
    }

}
