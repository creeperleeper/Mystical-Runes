package joey.mymod.proxy;

import joey.mymod.Items.Slate;
import joey.mymod.MysticRune;
import joey.mymod.inscriber.BlockInscriber;
import joey.mymod.ModBlocks;
import joey.mymod.inscriber.TileInscriber;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(MysticRune.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }


    //Blocks
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockInscriber()); //Registers the Inscriber as a block
        GameRegistry.registerTileEntity(TileInscriber.class, MysticRune.MODID + "_inscriber"); //Inscriber Tile Entity

    }


    //Items
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockInscriber).setRegistryName(BlockInscriber.INSCRIBER)); //Registers the Inscriber as an item
        event.getRegistry().register(new Slate()); //Registers the Slate as an item

    }
}