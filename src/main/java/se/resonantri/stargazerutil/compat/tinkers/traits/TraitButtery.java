package se.resonantri.stargazerutil.compat.tinkers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitButtery extends AbstractTrait {
    int x = 0;

    public TraitButtery() {
        super("buttery", 0xF6CB4C);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (isSelected) {
            if (x < 20) {
                x++;
                if (x >= 20) {
                    if (entity instanceof EntityPlayer) {
                        tool.damageItem(1, (EntityLivingBase) entity);
                        ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 2));
                    }
                    x = 0;
                }
            }
        }
    }
}