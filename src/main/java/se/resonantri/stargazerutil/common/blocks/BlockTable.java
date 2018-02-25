package se.resonantri.stargazerutil.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import se.resonantri.stargazerutil.utils.Constants;
import se.resonantri.stargazerutil.utils.CreativeTab;

public class BlockTable extends Block{

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyTType TTYPE = PropertyTType.create("ttype");

    public BlockTable() {
        super(Material.WOOD);
        setUnlocalizedName(Constants.MODID + ".table");
        setRegistryName("table");
        setCreativeTab(CreativeTab.stargazerUtils);
        setHardness(7.5f);
        setSoundType(SoundType.WOOD);
//        this.setDefaultState(this.getDefaultState().withProperty(BASE, true));
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
    /*    if ((world.getBlockState(pos.offset(placer.getHorizontalFacing().rotateYCCW())).getBlock()==ModBlocks.blockTable) && (world.getBlockState(pos.offset(placer.getHorizontalFacing().rotateYCCW(),1)).getValue(FACING)==placer.getHorizontalFacing()))
        {return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing()).withProperty(TTYPE,ENUM_TTYPE.RIGHT);}
        else
        {return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing()).withProperty(TTYPE,ENUM_TTYPE.SINGLE)}*/
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing()).withProperty(TTYPE,ENUM_TTYPE.SINGLE);
        /*world.setBlockState(pos.offset(placer.getHorizontalFacing().rotateYCCW()), ModBlocks.blockTable.getDefaultState().withProperty(FACING, placer.getHorizontalFacing()).withProperty(TTYPE,ENUM_TTYPE.LEFT));
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing()).withProperty(TTYPE,ENUM_TTYPE.RIGHT);*/
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState candidate = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateYCCW()));
        if ((candidate.getBlock()==ModBlocks.blockTable) && (candidate.getValue(FACING)==state.getValue(FACING)) && (candidate.getValue(TTYPE)==ENUM_TTYPE.SINGLE)){
            worldIn.setBlockState(pos, state.withProperty(TTYPE, ENUM_TTYPE.RIGHT));
            worldIn.setBlockState(pos.offset(state.getValue(FACING).rotateYCCW()), candidate.withProperty(TTYPE, ENUM_TTYPE.LEFT));
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (state.getValue(TTYPE)!=ENUM_TTYPE.SINGLE){
            IBlockState candidate = state.getValue(TTYPE)==ENUM_TTYPE.RIGHT ? worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateYCCW())) : worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateY()));
            if (candidate.getBlock()!=ModBlocks.blockTable) {
                worldIn.setBlockState(pos, state.withProperty(TTYPE,ENUM_TTYPE.SINGLE));
            }
        }
    }    

    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        if (face==EnumFacing.UP)
            {return BlockFaceShape.SOLID;}
        else
            {return BlockFaceShape.UNDEFINED;}
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{FACING, TTYPE});
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return (state.getValue(FACING)).getHorizontalIndex()+((state.getValue(TTYPE)).ordinal()<<2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FACING,EnumFacing.getHorizontal(meta&0b11)).withProperty(TTYPE, ENUM_TTYPE.values()[meta >> 2]);
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
    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {return FULL_BLOCK_AABB;}
}
