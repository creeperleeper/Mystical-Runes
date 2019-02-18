package joey.mymod.Items;

import joey.mymod.MysticRune;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Slate extends Item {

    public Slate() {
        setRegistryName("slate");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(MysticRune.MODID + ".slate");// Used for localization (en_US.lang)
        setCreativeTab(MysticRune.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }
}