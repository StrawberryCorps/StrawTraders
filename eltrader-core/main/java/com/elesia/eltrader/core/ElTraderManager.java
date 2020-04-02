package com.elesia.eltrader.core;

import com.elesia.eltrader.core.listeners.player.PlayerInteract;
import com.elesia.eltrader.core.manager.ElTrader;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        getServer().getPluginManager().registerEvents(new PlayerInteract(this),this);
    }

    public void ajouterTrader(String flatName, String aff, Location loc, Map<ItemStack, ItemStack> echanges, Server server){
        list.add(new ElTrader(flatName, aff, loc, echanges, server));
    }

    @Override
    public String getPrefix() { return "§8[§9ElTrader§8] §r"; }

}
