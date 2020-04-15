package com.elesia.eltrader.core.listeners.player;

import com.elesia.eltrader.api.ElTraderManager;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

/*
 * Copyright (c) 13/14/2020 12:00. Author of this file Uicias
 * This file is part of ElTrader (PlayerBlock).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public class PlayerBlock implements Listener {

    public PlayerBlock(Plugin plugin){plugin.getLogger().info("    ->Enregistrement du listener " + PlayerBlock.class.getName());}

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){

        ItemStack item;
        if(event.getHand() == EquipmentSlot.HAND)
            item = event.getPlayer().getInventory().getItemInMainHand();
        else if(event.getHand() == EquipmentSlot.OFF_HAND)
            item = event.getPlayer().getInventory().getItemInOffHand();
        else return;

        if(event.getBlock() != null && item.getItemMeta() != null && item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(ElTraderManager.getInstance(), "quete"), PersistentDataType.STRING))
            event.setCancelled(true);

    }

}
