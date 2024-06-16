package baunsu.shepmod;

import baunsu.shepmod.entity.ModEntities;
import baunsu.shepmod.entity.client.ModModeLayers;
import baunsu.shepmod.entity.client.ShepModel;
import baunsu.shepmod.entity.client.ShepRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ShepModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SHEP, ShepRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModeLayers.SHEP, ShepModel::getTexturedModelData);
    }
}
