package baunsu.shepmod;

import baunsu.shepmod.entity.ModEntities;
import baunsu.shepmod.entity.custom.ShepEntity;
import baunsu.shepmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShepMod implements ModInitializer {
	public static final String MOD_ID = "shepmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		FabricDefaultAttributeRegistry.register(ModEntities.SHEP, ShepEntity.createShepAttributes());
	}
}