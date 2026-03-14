// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBugWings<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bugwings"), "main");
	private final ModelPart body;
	private final ModelPart WingL;
	private final ModelPart WingR;

	public ModelBugWings(ModelPart root) {
		this.body = root.getChild("body");
		this.WingL = this.body.getChild("WingL");
		this.WingR = this.body.getChild("WingR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(3.25F, -0.5F, 0.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.25F, -0.5F, 0.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 20.5F, 11.0F));

		PartDefinition WingL = body.addOrReplaceChild("WingL", CubeListBuilder.create(),
				PartPose.offset(3.0F, 1.5F, 0.0F));

		PartDefinition WingR = body.addOrReplaceChild("WingR", CubeListBuilder.create(),
				PartPose.offset(-3.0F, 1.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}