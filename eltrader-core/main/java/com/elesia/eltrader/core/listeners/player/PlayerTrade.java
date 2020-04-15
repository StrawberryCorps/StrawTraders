package com.elesia.eltrader.core.listeners.player;

import com.elesia.eltrader.api.ElTraderManager;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

/*
 * Copyright (c) 13/14/2020 12:00. Author of this file Uicias
 * This file is part of ElTrader (PlayerBlock).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public class PlayerTrade implements Listener {

    public PlayerTrade(Plugin plugin){plugin.getLogger().info("    ->Enregistrement du listener " + PlayerTrade.class.getName()); }

    @EventHandler
    public void onPlayerTrade(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if(event.getClickedInventory() != null) {
            ItemStack item = event.getClickedInventory().getContents()[event.getSlot()];

            if(item != null && item.getItemMeta() != null && item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ElTraderManager.getInstance(), "titre-queteLeg"), PersistentDataType.STRING)){
                //check le give de titre
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "titreadmin " + player.getName() + " grant " + item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(ElTraderManager.getInstance(), "titre-queteLeg"), PersistentDataType.STRING));
                ItemMeta meta = item.getItemMeta();
                meta.getPersistentDataContainer().remove(new NamespacedKey(ElTraderManager.getInstance(), "titre-queteLeg"));
                item.setItemMeta(meta);
                Bukkit.broadcastMessage(ElTraderManager.getPrefix() + "§e" + player.getName() + "§c a fini la quête légendaire !");
            }
        }

    }

}
