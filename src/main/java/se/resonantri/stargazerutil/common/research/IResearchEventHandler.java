package se.resonantri.stargazerutil.common.research;

import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.CropGrowEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public interface IResearchEventHandler {

    //Block Event
    default void onBlockDrops(HarvestDropsEvent event) {
    }

    default void onBlockBreak(BreakEvent event) {
    }

    default void onPlaceBlock(PlaceEvent event) {
    }

    default void onGrowth(CropGrowEvent event) {
    }


    //Living Event
    default void onMobDrops(LivingDropsEvent event) {
    }

    default void onKillMob(LivingDeathEvent event) {
    }

    default void onMobBreakBlock(LivingDestroyBlockEvent event) {
    }

    default void onJump(LivingJumpEvent event) {
    }

    default void onEntityTravelDimension(EntityTravelToDimensionEvent event) {
    }

    default void onHitByProjectile(ProjectileImpactEvent event) {
    }


    //Tick Event
    default void onPlayerTick(PlayerTickEvent event) {
    }

}
