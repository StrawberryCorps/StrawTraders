package bzh.strawberry.strawTrader.core.listeners.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

/*
 * Copyright (c) 12/14/2020 23:00. Author of this file Uicias
 * This file is part of StrawTrader (EntityDamage).
 * StrawTrader can not be copied and/or distributed without the express permission of Uicias
 */

public class EntityDamage implements Listener {

    public EntityDamage(Plugin plugin){plugin.getLogger().info("    ->Registered listener " + EntityDamage.class.getName());}

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e ){

        Entity ent = e.getEntity();
//        if(ent instanceof WanderingTrader && !ent.getCustomName().equals("") && !((WanderingTrader) ent).hasAI())
//            e.setCancelled(true);

    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e ){

        Entity src = e.getDamager();
        Entity target = e.getEntity();

//        if(target instanceof WanderingTrader && !target.getCustomName().equals("") && !((WanderingTrader) target).hasAI() && src instanceof Player && ((Player) src).getGameMode() != GameMode.CREATIVE)
//            e.setCancelled(true);
    }

}
