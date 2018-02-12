package se.resonantri.stargazerutil.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import se.resonantri.stargazerutil.client.gui.GuiBookBindingTable;
import se.resonantri.stargazerutil.client.gui.GuiScribeTable;
import se.resonantri.stargazerutil.common.container.BookBindingTableContainer;
import se.resonantri.stargazerutil.common.container.ScribeTableContainer;
import se.resonantri.stargazerutil.common.tiles.TileBookBindingTable;
import se.resonantri.stargazerutil.common.tiles.TileScribeTable;

public class GuiProxy implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (te instanceof TileScribeTable) {
            return new ScribeTableContainer(player.inventory, (TileScribeTable) te);
        }

        if (te instanceof TileBookBindingTable) {
            return new BookBindingTableContainer(player.inventory, (TileBookBindingTable) te);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (te instanceof TileScribeTable) {
            TileScribeTable scribeTable = (TileScribeTable) te;
            return new GuiScribeTable(scribeTable, new ScribeTableContainer(player.inventory, scribeTable));
        }

        if (te instanceof TileBookBindingTable) {
            TileBookBindingTable bookBindingTable = (TileBookBindingTable) te;
            return new GuiBookBindingTable(bookBindingTable, new BookBindingTableContainer(player.inventory, bookBindingTable));
        }

        return null;
    }

}
