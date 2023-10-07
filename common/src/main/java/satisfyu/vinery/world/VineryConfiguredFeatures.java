package satisfyu.vinery.world;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import satisfyu.vinery.VineryIdentifier;


public class VineryConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> CHERRY_KEY = registerKey("cherry");
    public static final ResourceKey<ConfiguredFeature<?,?>> CHERRY_VARIANT_KEY = registerKey("cherry_variant");

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registry.CONFIGURED_FEATURE_REGISTRY, new VineryIdentifier(name));
    }

}

