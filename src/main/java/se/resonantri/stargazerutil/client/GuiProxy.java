package se.resonantri.stargazerutil.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import se.resonantri.stargazerutil.client.gui.GuiBinding;
import se.resonantri.stargazerutil.client.gui.GuiScribing;
import se.resonantri.stargazerutil.common.containers.ContainerBinding;
import se.resonantri.stargazerutil.common.containers.ContainerScribing;
import se.resonantri.stargazerutil.common.tiles.TileBinding;
import se.resonantri.stargazerutil.common.tiles.TileScribing;

public class GuiProxy implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (te instanceof TileScribing) {
            return new ContainerScribing(player.inventory, (TileScribing) te);
        }

        if (te instanceof TileBinding) {
            return new ContainerBinding(player.inventory, (TileBinding) te);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (te instanceof TileScribing) {
            TileScribing scribeTable = (TileScribing) te;
            return new GuiScribing(scribeTable, new ContainerScribing(player.inventory, scribeTable));
        }

        if (te instanceof TileBinding) {
            TileBinding bookBindingTable = (TileBinding) te;
            return new GuiBinding(bookBindingTable, new ContainerBinding(player.inventory, bookBindingTable));
        }

        return null;
    }

}
