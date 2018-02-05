package se.resonantri.stargazerutil.compat.tinkers.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static se.resonantri.stargazerutil.utils.UtilityMethods.tryPercentage;

public class TraitInfernal extends AbstractTrait {
    public TraitInfernal() {
        super("infernal", 0xffffff);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (player instanceof EntityPlayer) {
            if (!world.isRaining() && !player.isInWater() && !world.canSeeSky(player.getPosition())) {
                if (wasEffective) {
                    if (tryPercentage(0.15D)) {
                        player.setFire(2);
                    }
                }
            }
        }
    }
}
