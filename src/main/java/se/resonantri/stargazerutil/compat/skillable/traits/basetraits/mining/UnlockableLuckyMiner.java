package se.resonantri.stargazerutil.compat.skillable.traits.basetraits.mining;

import codersafterdark.reskillable.base.ConditionHelper;
import codersafterdark.reskillable.skill.base.Trait;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import java.util.HashMap;
import java.util.Map;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable.LuckyMinerCost;
import static se.resonantri.stargazerutil.utils.UtilityMethods.nextIntInclusive;
import static se.resonantri.stargazerutil.utils.UtilityMethods.tryPercentage;

public class UnlockableLuckyMiner extends Trait {

    public static final Map<Block, ItemStack> map = new HashMap<>();
    public static int fortuneLevel;

    static {
        map.put(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD, nextIntInclusive(1, 1 + fortuneLevel)));
        map.put(Blocks.LAPIS_ORE, new ItemStack(Items.DYE, nextIntInclusive(1, 1 + fortuneLevel), 4));
        map.put(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE, nextIntInclusive(1, 1 + fortuneLevel)));
        map.put(Blocks.LIT_REDSTONE_ORE, new ItemStack(Items.REDSTONE, nextIntInclusive(1, 1 + fortuneLevel)));
        map.put(Blocks.QUARTZ_ORE, new ItemStack(Items.QUARTZ, nextIntInclusive(1, 1 + fortuneLevel)));
    }

    public UnlockableLuckyMiner() {
        super("lucky_miner", 2, 2, LuckyMinerCost, "mining:16");
    }

    @Override
    public void onBlockDrops(HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        IBlockState blockState = event.getState();
        fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItem(player.getActiveHand()));
        if (ConditionHelper.hasRightTool(player, blockState, "pickaxe", Item.ToolMaterial.IRON.getHarvestLevel())) {
            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItem(player.getActiveHand())) == 0) {
                if (tryPercentage(0.50d)) {
                    ItemStack stack = map.get(blockState.getBlock());
                    if (stack != null && !stack.isEmpty()) {
                        event.getDrops().add(stack.copy());
                    }
                }
            }
        }
    }
}
