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
public class ModelOpossum<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minksandmisfits", "model_opossum"), "main");
	public final ModelPart opossum;
	public final ModelPart tailop;
	public final ModelPart backlegright;
	public final ModelPart backlegleft;
	public final ModelPart bodyop;
	public final ModelPart head;
	public final ModelPart frontlegleft;
	public final ModelPart frontlegright;

	public ModelOpossum(ModelPart root) {
		this.opossum = root.getChild("opossum");
		this.tailop = this.opossum.getChild("tailop");
		this.backlegright = this.opossum.getChild("backlegright");
		this.backlegleft = this.opossum.getChild("backlegleft");
		this.bodyop = this.opossum.getChild("bodyop");
		this.head = this.opossum.getChild("head");
		this.frontlegleft = this.opossum.getChild("frontlegleft");
		this.frontlegright = this.opossum.getChild("frontlegright");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition opossum = partdefinition.addOrReplaceChild("opossum", CubeListBuilder.create(), PartPose.offset(-0.5F, 18.5F, 1.0F));
		PartDefinition tailop = opossum.addOrReplaceChild("tailop", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, 4.0F));
		PartDefinition cube_r1 = tailop.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -3.0F, 0.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition backlegright = opossum.addOrReplaceChild("backlegright", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 3.0F));
		PartDefinition backlegleft = opossum.addOrReplaceChild("backlegleft", CubeListBuilder.create().texOffs(44, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 3.0F));
		PartDefinition bodyop = opossum.addOrReplaceChild("bodyop", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.5F, -6.0F, 7.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(24, 16)
				.addBox(-3.0F, -4.0F, -6.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 34).addBox(3.0F, -4.0F, -6.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition head = opossum.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(24, 34).addBox(-3.5F, -2.5F, -5.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(36, 0).addBox(-2.5F, 0.5F, -7.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, -6.0F));
		PartDefinition earL_r1 = head.addOrReplaceChild("earL_r1", CubeListBuilder.create().texOffs(32, 44).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, -1.5F, -2.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition earR_r1 = head.addOrReplaceChild("earR_r1", CubeListBuilder.create().texOffs(24, 44).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -1.5F, -2.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition frontlegleft = opossum.addOrReplaceChild("frontlegleft", CubeListBuilder.create().texOffs(36, 9).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, -4.0F));
		PartDefinition frontlegright = opossum.addOrReplaceChild("frontlegright", CubeListBuilder.create().texOffs(36, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, -4.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		opossum.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.backlegleft.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.tailop.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.backlegright.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.frontlegleft.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.frontlegright.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}