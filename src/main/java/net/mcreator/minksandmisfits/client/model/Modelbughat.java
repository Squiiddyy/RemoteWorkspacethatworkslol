package net.mcreator.minksandmisfits.client.model;

import net.minecraft.world.entity.Entity;
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

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbughat<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("minksandmisfits", "modelbughat"), "main");
	public final ModelPart Head2;

	public Modelbughat(ModelPart root) {
		this.Head2 = root.getChild("Head2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head2 = partdefinition.addOrReplaceChild("Head2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -8.0F, -4.4F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(20, 12).addBox(-3.0F, -5.5F, -4.3F, 2.0F, 3.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(16, 17)
						.addBox(-3.0F, -5.5F, 4.5F, 2.0F, 5.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(20, 15).addBox(1.0F, -5.5F, -4.3F, 2.0F, 3.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(16, 12)
						.addBox(1.0F, -5.5F, 4.5F, 2.0F, 5.0F, 0.05F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-4.6F, -6.5F, -2.0F, 0.1F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 18)
						.addBox(1.95F, -11.0F, 0.0F, 0.05F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 21).addBox(-2.05F, -11.0F, 0.0F, 0.05F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 21)
						.addBox(-2.05F, -12.0F, -1.0F, 0.05F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 21).addBox(1.95F, -12.0F, -1.0F, 0.05F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -0.5F, 0.0F));
		PartDefinition cube_r1 = Head2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 12).addBox(0.4F, -5.0F, -2.0F, 0.1F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -1.5F, 0.0F, 0.0F, 3.1416F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}