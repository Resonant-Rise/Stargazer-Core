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
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.StargazerUtil;
import se.resonantri.stargazerutil.common.tiles.TileBinding;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

import javax.annotation.Nonnull;

public class BlockBinding extends Block {
    public static final int GUI_ID = Constants.GUI_ENUM.BINDING.ordinal();
//    public static final PropertyBool BASE = PropertyBool.create("base");
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D);

    public BlockBinding() {
        super(Material.WOOD);
        setUnlocalizedName(Constants.MODID + ".binding");
        setRegistryName("binding");
        setCreativeTab(CreativeTab.stargazerUtils);
        setHardness(7.5f);
        setSoundType(SoundType.WOOD);
//        this.setDefaultState(this.getDefaultState().withProperty(BASE, true));
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

//    @Override
//    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
//        if (canPlaceBlockAtCheck(worldIn, pos, worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 1.0D, false).getHeldItem(EnumHand.MAIN_HAND), worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 1.0D, false))){
//            return true;
//        }
//        return false;
//    }

//    public boolean canPlaceBlockAtCheck(World world, @Nonnull BlockPos blockPos, ItemStack stack, EntityPlayer player) {
//        if (getBlockFromItem(stack.getItem()) instanceof BlockBookBindingTable){
//            EnumFacing facing = EnumFacing.fromAngle(player.rotationYaw);
//            if (facing.getAxis()== EnumFacing.Axis.Z){
//                return world.getBlockState(blockPos.add(1,0,0)).getBlock().isReplaceable(world, blockPos.add(1,0,0))||world.getBlockState(blockPos.add(-1, 0, 0)).getBlock().isReplaceable(world, blockPos.add(-1, 0, 0));
//            } else {
//                return world.getBlockState(blockPos.add(0,0,1)).getBlock().isReplaceable(world, blockPos.add(0,0,1))||world.getBlockState(blockPos.add(0,0,-1)).getBlock().isReplaceable(world, blockPos.add(0, 0, -1));
//            }
//        }
//        return true;
//    }

//    @Override
//    public void breakBlock(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
//        BlockPos secondBlockPos = pos.offset((EnumFacing)state.getValue(FACING));
//        if((EnumFacing)state.getValue(FACING) == EnumFacing.UP || EnumFacing.DOWN) {
//            secondBlockPos = pos.offset((EnumFacing)state.getValue(FACING));
//        }
//        world.setBlockState(secondBlockPos, Blocks.AIR.getDefaultState());
//    }

    @Override
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BLOCK_AABB;
    }

    protected boolean isFull(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullBlock(IBlockState state) {
        return isFull(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return isFull(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isNormalCube(IBlockState state) {
        return isFull(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return isFull(state);
    }

    @Override
    public boolean hasTileEntity(IBlockState blockState) {
        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    @Nonnull
    public TileEntity createTileEntity(@Nonnull World world, @Nonnull IBlockState blockState) {
        return new TileBinding();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }

        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof TileBinding)) {
            return false;
        }

        player.openGui(StargazerUtil.instance, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
