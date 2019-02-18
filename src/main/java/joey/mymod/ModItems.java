package joey.mymod;

import joey.mymod.Items.Slate;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder("mysticrunes:slate")
    public static Slate slate;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        slate.initModel();
    }

}