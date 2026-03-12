// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelmink<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "mink"), "main");
	private final ModelPart MainHead;
	private final ModelPart body;
	private final ModelPart FrontLegR;
	private final ModelPart FrontLegL;
	private final ModelPart BackLegR;
	private final ModelPart BackLegL;
	private final ModelPart tail;

	public Modelmink(ModelPart root) {
		this.MainHead = root.getChild("MainHead");
		this.body = root.getChild("body");
		this.FrontLegR = root.getChild("FrontLegR");
		this.FrontLegL = root.getChild("FrontLegL");
		this.BackLegR = root.getChild("BackLegR");
		this.BackLegL = root.getChild("BackLegL");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MainHead = partdefinition.addOrReplaceChild("MainHead",
				CubeListBuilder.create().texOffs(18, 17)
						.addBox(-2.5F, -2.0F, -4.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(36, 0)
						.addBox(-1.5F, 0.0F, -5.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 13.0F, -5.0F));

		PartDefinition earL_r1 = MainHead.addOrReplaceChild("earL_r1",
				CubeListBuilder.create().texOffs(36, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -1.0F, -1.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition earR_r1 = MainHead.addOrReplaceChild("earR_r1",
				CubeListBuilder.create().texOffs(36, 3).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -1.0F, -1.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-2.5F, -1.0F, -3.0F, 5.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 18.0F, -2.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(18, 26).addBox(-3.5F, -3.0F, -1.0F, 4.0F, 8.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, -3.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition FrontLegR = partdefinition.addOrReplaceChild("FrontLegR", CubeListBuilder.create().texOffs(0, 31)
				.addBox(-0.8F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 21.0F, -3.0F));

		PartDefinition FrontLegL = partdefinition.addOrReplaceChild("FrontLegL", CubeListBuilder.create().texOffs(8, 31)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 21.0F, -3.0F));

		PartDefinition BackLegR = partdefinition.addOrReplaceChild("BackLegR", CubeListBuilder.create().texOffs(32, 26)
				.addBox(-0.9F, -1.0F, -1.1F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 21.0F, 7.0F));

		PartDefinition BackLegL = partdefinition.addOrReplaceChild("BackLegL", CubeListBuilder.create().texOffs(32, 32)
				.addBox(-1.1F, -1.0F, -1.1F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 21.0F, 7.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 17).addBox(
				0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 18.5F, 8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		MainHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLegR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontLegL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLegR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLegL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.BackLegL.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.FrontLegR.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.tail.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.BackLegR.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.FrontLegL.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.MainHead.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.MainHead.xRot = headPitch / (180F / (float) Math.PI);
	}
}