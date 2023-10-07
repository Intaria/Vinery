package satisfyu.vinery.fabric.world;

import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import satisfyu.vinery.VineryIdentifier;
import satisfyu.vinery.world.VineryPlacedFeatures;

import java.util.function.Predicate;


public class VineryBiomeModification {

    public static void init() {
        BiomeModification world = BiomeModifications.create(new VineryIdentifier("world_features"));
        
        Predicate<BiomeSelectionContext> treeBiomes = getVinerySelector("spanws_cherry_tree");

        world.add(ModificationPhase.ADDITIONS, treeBiomes, ctx -> ctx.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VineryPlacedFeatures.TREE_CHERRY_PLACED_KEY));
    }

    private static Predicate<BiomeSelectionContext> getVinerySelector(String path) {
        return BiomeSelectors.tag(TagKey.create(Registry.BIOME_REGISTRY, new VineryIdentifier(path)));
    }



}
