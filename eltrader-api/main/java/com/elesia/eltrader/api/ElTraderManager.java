package com.elesia.eltrader.api;

import org.bukkit.plugin.java.JavaPlugin;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of ElTrader (ElTraderManager).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public abstract class ElTraderManager extends JavaPlugin {

    private static ElTraderManager INSTANCE;

    public ElTraderManager(){INSTANCE = this;}

    public static ElTraderManager getInstance(){ return INSTANCE; }

    public abstract String getPrefix();

}
