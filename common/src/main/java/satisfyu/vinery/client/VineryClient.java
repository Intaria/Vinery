package satisfyu.vinery.client;

import de.cristelknight.doapi.terraform.TerraformSignHelper;
import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import satisfyu.vinery.client.gui.FermentationBarrelGui;
import satisfyu.vinery.client.gui.WinePressGui;
import satisfyu.vinery.client.model.MuleModel;
import satisfyu.vinery.client.render.entity.MuleRenderer;
import satisfyu.vinery.client.render.entity.WanderingWinemakerRenderer;
import satisfyu.vinery.event.KeyInputHandler;
import satisfyu.vinery.network.VineryNetwork;
import satisfyu.vinery.registry.VineryBlockEntityTypes;
import satisfyu.vinery.registry.VineryEntites;
import satisfyu.vinery.registry.VineryScreenHandlerTypes;

import static satisfyu.vinery.registry.ObjectRegistry.*;

@Environment(EnvType.CLIENT)
public class VineryClient {

    public static void onInitializeClient() {
        KeyInputHandler.register();
        VineryNetwork.registerS2CPackets();
        RenderTypeRegistry.register(RenderType.cutout(),
                RED_GRAPE_BUSH.get(), WHITE_GRAPE_BUSH.get(), CHERRY_DOOR.get(), FERMENTATION_BARREL.get(),
                MELLOHI_WINE.get(), CLARK_WINE.get(), BOLVAR_WINE.get(), CHERRY_WINE.get(),
                KING_DANIS_WINE.get(), CHENET_WINE.get(), NOIR_WINE.get(), APPLE_CIDER.get(),
                APPLE_WINE.get(), SOLARIS_WINE.get(), JELLIE_WINE.get(), AEGIS_WINE.get(), KELP_CIDER.get(),
                SAVANNA_RED_GRAPE_BUSH.get(), SAVANNA_WHITE_GRAPE_BUSH.get(),
                CHORUS_WINE.get(), STAL_WINE.get(), MAGNETIC_WINE.get(), STRAD_WINE.get(), JUNGLE_WHITE_GRAPE_BUSH.get(),
                JUNGLE_RED_GRAPE_BUSH.get(), TAIGA_RED_GRAPE_BUSH.get(), TAIGA_WHITE_GRAPE_BUSH.get(),
                GRAPEVINE_STEM.get(), GRAPEVINE_LATTICE.get(), WINE_BOX.get(),
                WINE_PRESS.get(), CHERRY_SAPLING.get(), APPLE_TREE_SAPLING.get(),
                KITCHEN_SINK.get(), APPLE_LEAVES.get(), POTTED_APPLE_TREE_SAPLING.get(),
                POTTED_CHERRY_TREE_SAPLING.get(), RED_WINE.get(), PRAETORIAN_WINE.get(),
                CRISTEL_WINE.get(), VILLAGERS_FRIGHT.get(), EISWEIN.get(), CREEPERS_CRUSH.get(),
                GLOWING_WINE.get(), JO_SPECIAL_MIXTURE.get(), MEAD.get(), BOTTLE_MOJANG_NOIR.get(),
                OAK_WINE_RACK_MID.get(), DARK_OAK_WINE_RACK_MID.get(), BIRCH_WINE_RACK_MID.get(),
                SPRUCE_WINE_RACK_MID.get(), JUNGLE_WINE_RACK_MID.get(), MANGROVE_WINE_RACK_MID.get(), CHERRY_WINE_RACK_MID.get(),
                ACACIA_WINE_RACK_MID.get()
                );

        ClientStorageTypes.init();
        RenderTypeRegistry.register(RenderType.translucent(), WINDOW.get());


        ColorHandlerRegistry.registerItemColors((stack, tintIndex) -> FoliageColor.get(0.5, 1.0), APPLE_LEAVES_ITEM);

        ColorHandlerRegistry.registerBlockColors((state,world,pos,tintIndex)->{
                    if(world== null || pos == null){
                        return -1;
                    }
                    return BiomeColors.getAverageFoliageColor(world,pos);
                }, TAIGA_WHITE_GRAPE_BUSH.get(), TAIGA_RED_GRAPE_BUSH.get()
        );

        ColorHandlerRegistry.registerBlockColors((state,world,pos,tintIndex)->{
                    if(world== null || pos == null){
                        return -1;
                    }
                    return BiomeColors.getAverageFoliageColor(world,pos);
                }, SAVANNA_RED_GRAPE_BUSH.get(), SAVANNA_WHITE_GRAPE_BUSH.get(), JUNGLE_RED_GRAPE_BUSH.get(), JUNGLE_WHITE_GRAPE_BUSH.get(),
                   GRAPEVINE_STEM.get(), GRAPEVINE_LATTICE.get(),APPLE_LEAVES.get()
        );



        MenuRegistry.registerScreenFactory(VineryScreenHandlerTypes.FERMENTATION_BARREL_GUI_HANDLER.get(), FermentationBarrelGui::new);
        MenuRegistry.registerScreenFactory(VineryScreenHandlerTypes.WINE_PRESS_SCREEN_HANDLER.get(), WinePressGui::new);
    }


    public static void preInitClient(){
        TerraformSignHelper.regsterSignSprite(CHERRY_SIGN_TEXTURE);

        EntityModelLayerRegistry.register(MuleModel.LAYER_LOCATION, MuleModel::getTexturedModelData);

        EntityRendererRegistry.register(VineryEntites.MULE, MuleRenderer::new);
        EntityRendererRegistry.register(VineryEntites.WANDERING_WINEMAKER, WanderingWinemakerRenderer::new);
    }

    public static Player getClientPlayer() {
        return Minecraft.getInstance().player;
    }
}