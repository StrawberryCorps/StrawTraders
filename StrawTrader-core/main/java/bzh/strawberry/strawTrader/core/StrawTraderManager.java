package bzh.strawberry.strawTrader.core;

import bzh.strawberry.strawTrader.api.utils.ItemCreator;
import bzh.strawberry.strawTrader.core.commands.StrawtraderCommand;
import bzh.strawberry.strawTrader.core.listeners.entity.EntityDamage;
import bzh.strawberry.strawTrader.core.listeners.player.PlayerBlock;
import bzh.strawberry.strawTrader.core.manager.StrawTrader;
import org.bukkit.Location;
import org.bukkit.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of StrawTrader (ElTraderManager).
 * StrawTrader can not be copied and/or distributed without the express permission of Uicias.
 */

public class StrawTraderManager extends bzh.strawberry.strawTrader.api.StrawTraderManager {

    public static StrawTraderManager INSTANCE;
    private static List<StrawTrader> list;

    public void onEnable(){
        INSTANCE = this;
        list = new ArrayList<>();
        getServer().getLogger().info(getPrefix() + "Enabling StrawTrader plugin...");
        getServer().getPluginManager().registerEvents(new EntityDamage(this),this);
        getServer().getPluginManager().registerEvents(new PlayerBlock(this),this);
        Objects.requireNonNull(getServer().getPluginCommand("eltrader")).setExecutor(new StrawTraderManager());
        getServer().getLogger().info(getPrefix() + "Done enabling StrawTrader plugin...");
    }

    public void ajouterTrader(String flatName, String aff, Location loc, Map<ItemCreator, ItemCreator> echanges, Server server){

        if(getByFlatName(flatName) == null){
            list.add(new StrawTrader(flatName, aff, loc, echanges, server));
        }
        else{
            server.getLogger().info("   -> Error while creating this trader, a trader with this name already exists... " + flatName);
        }

    }

    public StrawTrader getByFlatName(String nom){ return list.stream().filter(trader -> trader.getFlatName().equalsIgnoreCase(nom)).findFirst().orElse(null); }

    public void killAllTraders(){

        List<StrawTrader> copy = new ArrayList<>(list);
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
