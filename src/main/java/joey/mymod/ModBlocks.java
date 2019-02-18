package joey.mymod;

import joey.mymod.inscriber.BlockInscriber;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("mysticrunes:inscriber")
    public static BlockInscriber blockInscriber;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockInscriber.initModel();
    }

}
