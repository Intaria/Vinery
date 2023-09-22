package satisfyu.vinery.registry;

import de.cristelknight.doapi.DoApiExpectPlatform;
import net.minecraft.world.level.block.Block;

public class VineryFlammableBlocks {

    public static void init(){
        add(5, 20, ObjectRegistry.CHERRY_PLANKS.get(), ObjectRegistry.CHERRY_SLAB.get(), ObjectRegistry.CHERRY_STAIRS.get(), ObjectRegistry.CHERRY_FENCE.get(),
                ObjectRegistry.CHERRY_FENCE_GATE.get());

        add(30, 60, ObjectRegistry.CHERRY_LEAVES.get(), ObjectRegistry.GRAPEVINE_LEAVES.get());
    }

    private static void add(int burnOdd, int igniteOdd, Block... blocks){
        DoApiExpectPlatform.addFlammable(burnOdd, igniteOdd, blocks);
    }

}
