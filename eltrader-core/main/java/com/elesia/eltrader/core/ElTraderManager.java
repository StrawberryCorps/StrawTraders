package com.elesia.eltrader.core;

import com.elesia.eltrader.core.commands.ElTraderCommand;
import com.elesia.eltrader.core.listeners.entity.EntityDamage;
import com.elesia.eltrader.core.listeners.player.PlayerBlock;
import com.elesia.eltrader.core.listeners.player.PlayerTrade;
import com.elesia.eltrader.core.manager.ElTrader;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of ElTrader (ElTraderManager).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public class ElTraderManager extends com.elesia.eltrader.api.ElTraderManager {

    public static ElTraderManager INSTANCE;
    private static List<ElTrader> list;

    public void onEnable(){
        INSTANCE = this;
        list = new ArrayList<>();
        getServer().getLogger().info(getPrefix() + "Activation du plugin de traders...");
        getServer().getPluginManager().registerEvents(new EntityDamage(this),this);
        getServer().getPluginManager().registerEvents(new PlayerBlock(this),this);
        getServer().getPluginManager().registerEvents(new PlayerTrade(this),this);
        Objects.requireNonNull(getServer().getPluginCommand("eltrader")).setExecutor(new ElTraderCommand());
    }

    public void ajouterTrader(String flatName, String aff, Location loc, Map<ItemStack, ItemStack> echanges, Server server){

        if(getByFlatName(flatName) == null){
            list.add(new ElTrader(flatName, aff, loc, echanges, server));
        }
        else{
            server.getLogger().info("   -> Echec à l'ajout du trader, un trader existe déjà avec ce nom... " + flatName);
        }

    }

    public ElTrader getByFlatName(String nom){ return list.stream().filter(trader -> trader.getFlatName().equalsIgnoreCase(nom)).findFirst().orElse(null); }

    public void killAllTraders(){

        List<ElTrader> copy = new ArrayList<>(list);
        copy.forEach( ent -> removeByFlat(ent.kill()));

    }

    public List<String> getEveryFlat() {
        List<String> ret = new ArrayList<>();

        list.forEach(ent -> {
            ret.add(ent.getFlatName());
        });
        return ret;
    }

    public void removeByFlat(String nom){ list.stream().filter(item -> item.getFlatName().equalsIgnoreCase(nom)).findFirst().ifPresent(t -> list.remove(t)); }

}
