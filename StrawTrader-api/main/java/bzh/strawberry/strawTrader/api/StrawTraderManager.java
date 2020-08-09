package bzh.strawberry.strawTrader.api;

import bzh.strawberry.strawTrader.api.manager.StrawTrader;
import bzh.strawberry.strawTrader.api.utils.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of StrawTrader (StrawTraderManager).
 * StrawTrader can not be copied and/or distributed without the express permission of Uicias.
 */

public abstract class StrawTraderManager extends JavaPlugin {

    private static StrawTraderManager INSTANCE;

    public StrawTraderManager(){INSTANCE = this;}

    public static StrawTraderManager getInstance(){ return INSTANCE; }

    public static String getPrefix() { return "§8[§9Trader§8] §r"; }

    public abstract void ajouterTrader(String flatName, String aff, Location loc, Map<ItemCreator, ItemCreator> echanges, Server server);

    public abstract void killAllTraders();

    public abstract StrawTrader getByFlatName(String name);

    public abstract List<String> getEveryFlat();

    public abstract void removeByFlat(String nom);

}
