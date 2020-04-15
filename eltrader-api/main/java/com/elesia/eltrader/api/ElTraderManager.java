package com.elesia.eltrader.api;

import com.elesia.eltrader.api.manager.ElTrader;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of ElTrader (ElTraderManager).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public abstract class ElTraderManager extends JavaPlugin {

    private static ElTraderManager INSTANCE;

    public ElTraderManager(){INSTANCE = this;}

    public static ElTraderManager getInstance(){ return INSTANCE; }

    public static String getPrefix() { return "§8[§9ElTrader§8] §r"; }

    public abstract void ajouterTrader(String flatName, String aff, Location loc, Map<ItemStack, ItemStack> echanges, Server server);

    public abstract void killAllTraders();

    public abstract ElTrader getByFlatName(String name);

    public abstract List<String> getEveryFlat();

    public abstract void removeByFlat(String nom);

}
