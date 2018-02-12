package se.resonantri.stargazerutil.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.common.tiles.TileScribeTable;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

import javax.annotation.Nonnull;

public class BlockScribeTable extends Block {
    public static final int GUI_ID = 1;
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockScribeTable() {
        super(Material.WOOD);
        setUnlocalizedName(Constants.MODID + ".scribetable");
        setRegistryName("scribetable");
        setCreativeTab(CreativeTab.stargazerUtils);
        setHardness(7.5f);
        setSoundType(SoundType.WOOD);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    @Nonnull
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState blockState) {
        return new TileScribeTable();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }

        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileScribeTable)) {
            return false;
        }

        player.openGui(StargazerUtil.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
