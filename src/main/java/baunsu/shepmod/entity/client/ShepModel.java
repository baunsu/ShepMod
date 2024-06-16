package baunsu.shepmod.entity.client;

import baunsu.shepmod.entity.custom.ShepEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ShepModel<T extends ShepEntity> extends SinglePartEntityModel<T> {
	private final ModelPart shep;

	public ShepModel(ModelPart root) {
		this.shep = root.getChild("shep");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData shep = modelPartData.addChild("shep", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 24.0F, -0.5F));

		ModelPartData body = shep.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, -5.5F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -9.5F, -1.5F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(16, 0).cuboid(-1.5F, -10.0F, -1.75F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create().uv(18, 7).cuboid(0.0F, -2.75F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(24, 8).cuboid(-0.75F, -1.75F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -6.5F, 0.5F));

		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create().uv(18, 12).cuboid(0.0F, -2.5F, -1.0F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(24, 13).cuboid(-0.75F, -1.5F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -6.75F, 0.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create().uv(12, 12).cuboid(-0.75F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.5F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create().uv(12, 0).cuboid(2.0F, -5.5F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create().uv(12, 8).cuboid(-2.0F, -5.5F, 0.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData left_leg = body.addChild("left_leg", ModelPartBuilder.create().uv(0, 0).cuboid(2.75F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.5F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(ShepEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		shep.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return shep;
	}
}