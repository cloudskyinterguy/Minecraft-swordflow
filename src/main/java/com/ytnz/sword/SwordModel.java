package com.ytnz.sword;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.ytnz.swordflow.SwordFlow;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SwordModel extends EntityModel<SwordRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation SWORD_MODEL_LAYER_KEY = new ModelLayerLocation(
			ResourceLocation.fromNamespaceAndPath(SwordFlow.MODID, Sword.SWORD_ENTITY_NAME + "model"), "main"
	);
	private final ModelPart bone;


	protected SwordModel(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(8, 8).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 0.0F, 0.4644F, 1.4733F, -0.7592F));

		return LayerDefinition.create(meshdefinition, 32, 32);

	}



}