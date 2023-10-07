package satisfyu.vinery.world;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import satisfyu.vinery.VineryIdentifier;

public class VineryPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TREE_CHERRY_PLACED_KEY = registerKey("tree_cherry");
    
    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new VineryIdentifier(name));
    }
}
