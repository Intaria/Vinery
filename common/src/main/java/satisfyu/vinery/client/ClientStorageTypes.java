package satisfyu.vinery.client;

import de.cristelknight.doapi.client.render.block.storage.StorageBlockEntityRenderer;
import de.cristelknight.doapi.client.render.block.storage.StorageTypeRenderer;
import net.minecraft.resources.ResourceLocation;
import satisfyu.vinery.client.render.block.storage.*;
import satisfyu.vinery.registry.VineryStorageTypes;

public class ClientStorageTypes {

    public static ResourceLocation registerStorageType(ResourceLocation location, StorageTypeRenderer renderer){
        return StorageBlockEntityRenderer.registerStorageType(location, renderer);
    }

    public static void init(){
        registerStorageType(VineryStorageTypes.FOUR_BOTTLE, new FourBottleRenderer());
        registerStorageType(VineryStorageTypes.NINE_BOTTLE, new NineBottleRenderer());
        registerStorageType(VineryStorageTypes.WINE_BOTTLE, new WineBottleRenderer());
        registerStorageType(VineryStorageTypes.BIG_BOTTLE, new BigBottleRenderer());
    }

}
