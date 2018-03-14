package se.resonantri.stargazerutil.compat.skillable.traits.customtraits.alchemy;

import codersafterdark.reskillable.skill.base.Trait;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable.AcceleratedCost;

public class UnlockableAccelerated extends Trait {
    public UnlockableAccelerated() {
        super("Accelerated", 4, 2, AcceleratedCost, "Alchemy:16");
    }

    @Override
    public void onPlayerTick(PlayerTickEvent event) {
        event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2));
        event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 10, 2));
    }
}