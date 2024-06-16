package baunsu.shepmod.entity.client;

import baunsu.shepmod.ShepMod;
import baunsu.shepmod.entity.custom.ShepEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ShepRenderer extends MobEntityRenderer<ShepEntity, ShepModel<ShepEntity>> {

    private static final Identifier TEXTURE = new Identifier(ShepMod.MOD_ID, "textures/entity/sheptexture.png");

    public ShepRenderer(EntityRendererFactory.Context context) {
        super(context, new ShepModel<>(context.getPart(ModModeLayers.SHEP)), 0.6f);
    }

    @Override
    public Identifier getTexture(ShepEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(ShepEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
