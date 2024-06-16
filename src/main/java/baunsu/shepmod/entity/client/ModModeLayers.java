package baunsu.shepmod.entity.client;

import baunsu.shepmod.ShepMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModeLayers {
    public static final EntityModelLayer SHEP =
            new EntityModelLayer(new Identifier(ShepMod.MOD_ID, "shep"), "main");
}
