package baunsu.shepmod.entity;

import baunsu.shepmod.ShepMod;
import baunsu.shepmod.entity.custom.ShepEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ShepEntity> SHEP = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ShepMod.MOD_ID, "shep"),
            EntityType.Builder.create(ShepEntity::new, SpawnGroup.CREATURE)
                    .setDimensions(1f,1f).build());
}
