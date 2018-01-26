package se.resonantri.stargazerutil.compat.skillable.traits.customtraits.alchemy;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import vazkii.skillable.skill.base.Trait;

import static se.resonantri.stargazerutil.utils.StargazerConfig.StargazerConfigs.Skillable.acceleratedCost;

public class TraitAccelerated extends Trait {
    public TraitAccelerated() {
        super("accelerated", 4, 2, acceleratedCost, "alchemy:16");
    }

    @Override
    public void onPlayerTick(PlayerTickEvent event){
        event.player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10, 2));
        event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 10, 2));
    }
}