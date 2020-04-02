package com.elesia.eltrader.core.listeners.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerInteract implements Listener {

    public PlayerInteract(JavaPlugin plugin){
        plugin.getLogger().info("   -> Enregistrement du listener " + PlayerInteract.class.getName());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){

    }

}
