package com.elesia.eltrader.core.manager;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of ElTrader (ElTrader).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class ElTrader extends com.elesia.eltrader.api.manager.ElTrader {

    private String flatName;
    private String affichage;
    private Location loc;
    private Map<ItemStack, ItemStack> trades;
    private Server server;

    public ElTrader(String flatName, String aff, Location loc, Map<ItemStack, ItemStack> echanges, Server server){
        super(flatName, aff, loc, echanges, server);
    }

}
