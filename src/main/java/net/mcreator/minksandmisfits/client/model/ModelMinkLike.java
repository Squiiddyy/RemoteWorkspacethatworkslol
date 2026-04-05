package net.mcreator.minksandmisfits.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelMinkLike<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minksandmisfits", "model_mink_like"), "main");
	public final ModelPart minklike;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;
	public final ModelPart Waist;
	public final ModelPart Head;
	public final ModelPart earL;
	public final ModelPart earR;
	public final ModelPart Body;
	public final ModelPart tail;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;

	public ModelMinkLike(ModelPart root) {
		this.minklike = root.getChild("minklike");
		this.RightLeg = this.minklike.getChild("RightLeg");
		this.LeftLeg = this.minklike.getChild("LeftLeg");
		this.Waist = this.minklike.getChild("Waist");
		this.Head = this.Waist.getChild("Head");
		this.earL = this.Head.getChild("earL");
		this.earR = this.Head.getChild("earR");
		this.Body = this.Waist.getChild("Body");
		this.tail = this.Body.getChild("tail");
		this.RightArm = this.Waist.getChild("RightArm");
		this.LeftArm = this.Waist.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition minklike = partdefinition.addOrReplaceChild("minklike", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition RightLeg = minklike.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition LeftLeg = minklike.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(26, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.8F, 0.0F, 0.0F));
		PartDefinition Waist = minklike.addOrReplaceChild("Waist", CubeListBuilder.create(), PartPose.offset(1.9F, 0.0F, 0.0F));
		PartDefinition Head = Waist.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition earL = Head.addOrReplaceChild("earL", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, 1.0F));
		PartDefinition earL_r1 = earL.addOrReplaceChild("earL_r1", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));
		PartDefinition earR = Head.addOrReplaceChild("earR", CubeListBuilder.create(), PartPose.offset(-2.0F, -7.0F, 1.0F));
		PartDefinition earR_r1 = earR.addOrReplaceChild("earR_r1", CubeListBuilder.create().texOffs(16, 35).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
		PartDefinition Body = Waist.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(26, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 16).addBox(1.0F, -5.0F, -1.0F, 0.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 12.0F, 2.0F));
		PartDefinition RightArm = Waist.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 45).addBox(-3.0F, 9.0F, -2.01F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, -10.0F, 0.0F));
		PartDefinition LeftArm = Waist.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(42, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 47).addBox(-1.0F, 9.0F, -2.01F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, -10.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		minklike.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.tail.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}