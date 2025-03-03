package bzh.strawberry.strawTrader.api.manager;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of StrawTrader (StrawTrader).
 * StrawTrader can not be copied and/or distributed without the express permission of Uicias.
 */

import bzh.strawberry.strawTrader.api.utils.ItemCreator;
import org.bukkit.Location;
import org.bukkit.Server;

import java.util.Map;

public abstract class StrawTrader {

    private String flatname;
    private String affichage;
    private Location location;
    private Map<ItemCreator, ItemCreator> trades;
    private Server server;

    public StrawTrader(String flatName, String aff, Location loc, Map<ItemCreator, ItemCreator> echanges, Server server) {
        this.flatname = flatName;
        this.affichage = aff;
        this.location = loc;
        this.trades = echanges;
        this.server = server;
    }

    public String getFlatName() { return this.flatname; }

    public abstract String kill();

}
