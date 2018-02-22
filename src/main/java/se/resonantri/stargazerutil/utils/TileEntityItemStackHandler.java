package se.resonantri.stargazerutil.utils;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityItemStackHandler extends ItemStackHandler {
    private TileEntity tile;

    public TileEntityItemStackHandler(TileEntity tile, int size) {
        super(size);
        this.tile = tile;
    }

    @Override
    protected void onContentsChanged(int SLOT) {
        tile.markDirty();
    }
}
