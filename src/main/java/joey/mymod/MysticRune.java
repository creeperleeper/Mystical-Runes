package joey.mymod;

        import joey.mymod.proxy.CommonProxy;
        import net.minecraft.creativetab.CreativeTabs;
        import net.minecraft.item.ItemStack;
        import net.minecraftforge.fml.common.Mod;
        import net.minecraftforge.fml.common.SidedProxy;
        import net.minecraftforge.fml.common.event.FMLInitializationEvent;
        import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
        import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
        import org.apache.logging.log4j.Logger;

@Mod(modid = MysticRune.MODID, name = MysticRune.MODNAME, version = MysticRune.MODVERSION, dependencies = "required-after:forge@[14.23.5.2768,)", useMetadata = true)
public class MysticRune {

    public static final String MODID = "mysticrunes";
    public static final String MODNAME = "Mystic Runes";
    public static final String MODVERSION= "0.0.1";

    @SidedProxy(clientSide = "joey.mymod.proxy.ClientProxy", serverSide = "joey.mymod.proxy.ServerProxy")
    public static CommonProxy proxy;


    //Creative Tab and Icon
    public static CreativeTabs creativeTab = new CreativeTabs("mysticrunes") {
        @Override
        public ItemStack getTabIconItem() {return new ItemStack(ModBlocks.blockInscriber); }
    };


    @Mod.Instance
    public static MysticRune instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}