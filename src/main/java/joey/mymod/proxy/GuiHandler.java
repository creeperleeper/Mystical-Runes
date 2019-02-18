package joey.mymod.proxy;

import joey.mymod.inscriber.ContainerInscriber;
import joey.mymod.inscriber.GuiInscriber;
import joey.mymod.inscriber.TileInscriber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileInscriber) {
            return new ContainerInscriber(player.inventory, (TileInscriber) te);
        }
        return null;
    }
    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileInscriber) {
            TileInscriber containerTileEntity = (TileInscriber) te;
            return new GuiInscriber(containerTileEntity, new ContainerInscriber(player.inventory, containerTileEntity));
        }
        return null;
    }
}
