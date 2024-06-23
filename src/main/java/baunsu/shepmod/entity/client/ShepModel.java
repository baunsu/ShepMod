package baunsu.shepmod.entity.client;

import baunsu.shepmod.entity.animation.ModAnimations;
import baunsu.shepmod.entity.custom.ShepEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ShepModel<T extends ShepEntity> extends SinglePartEntityModel<T> {
	private final ModelPart shep;
	private final ModelPart head;

	public ShepModel(ModelPart root) {
		this.shep = root.getChild("shep");
		this.head = shep.getChild("body").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData shep = modelPartData.addChild("shep", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = shep.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 0.0F, -0.5F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, -4.75F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F))
				.uv(16, 0).cuboid(-1.5F, -4.5F, -1.5F, 3.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 16).cuboid(1.5F, -3.5F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(8, 16).cuboid(-2.5F, -3.5F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 22).cuboid(-1.5F, -3.5F, 1.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -4.75F, 0.5F));

		ModelPartData right_ear = head.addChild("right_ear", ModelPartBuilder.create(), ModelTransform.pivot(3.75F, -1.75F, 0.0F));

		ModelPartData ear_muff_r1 = right_ear.addChild("ear_muff_r1", ModelPartBuilder.create().uv(24, 13).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.75F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData left_ear = head.addChild("left_ear", ModelPartBuilder.create(), ModelTransform.of(-3.1107F, -1.75F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData ear_muff_r2 = left_ear.addChild("ear_muff_r2", ModelPartBuilder.create().uv(24, 13).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.1393F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create().uv(12, 12).cuboid(-0.75F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.5F));

		ModelPartData left_arm = body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(2.4368F, -4.5402F, 0.5F));

		ModelPartData left_arm_r1 = left_arm.addChild("left_arm_r1", ModelPartBuilder.create().uv(12, 0).cuboid(1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.9368F, 2.5402F, 0.5F, 0.0F, 0.0F, -0.4363F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.pivot(-1.4679F, -4.5402F, 0.5F));

		ModelPartData right_arm_r1 = right_arm.addChild("right_arm_r1", ModelPartBuilder.create().uv(12, 8).cuboid(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0208F, 0.9941F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData left_leg = body.addChild("left_leg", ModelPartBuilder.create().uv(0, 0).cuboid(2.75F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -2.0F, 0.5F));

		ModelPartData butt = body.addChild("butt", ModelPartBuilder.create().uv(0, 14).cuboid(0.75F, -3.25F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(4, 14).cuboid(-0.75F, -3.25F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(ShepEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.SHEP_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
	}

	private void setHeadAngles (float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * 0.01745F;
		this.head.pitch = headPitch * 0.01745F;
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