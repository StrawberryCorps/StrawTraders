package com.elesia.eltrader.core.manager;

/*
 * Copyright (c) 26/03/2020 19:36. Author of this file Uicias
 * This file is part of ElTrader (ElTrader).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

import com.elesia.eltrader.core.ElTraderManager;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.*;

public class ElTrader extends com.elesia.eltrader.api.manager.ElTrader {

    private String flatName;
    private String affichage;
    private Location loc;
    private Map<ItemStack, ItemStack> trades;
    private Server server;
    private Entity entitee;

    public ElTrader(String flatName, String aff, Location loc, Map<ItemStack, ItemStack> echanges, Server server) {
        super(flatName, aff, loc, echanges, server);

        Entity entite = loc.getWorld().spawnEntity(loc, EntityType.WANDERING_TRADER);

        if (entite != null) {

            this.flatName = flatName;
            this.affichage = aff;
            this.loc = loc;
            this.server = server;
            this.entitee = entite;

            entite.setInvulnerable(true);
            entite.setCustomNameVisible(true);
            entite.setCustomName(aff);
            entite.setSilent(true);
            entite.setPersistent(true);

            ((WanderingTrader) entite).setAI(false);

            //Il est voulu de faire la conversion ici pour rendre la classe plus simple a utiliser à l'extérieur.
            List<MerchantRecipe> listTrades = new ArrayList<>();

            MerchantRecipe echange;

            Set<ItemStack> cles = echanges.keySet();

            for (ItemStack cle : cles) {

                echange = new MerchantRecipe(echanges.get(cle), Integer.MAX_VALUE);
                echange.addIngredient(cle);
                echange.setExperienceReward(false);

                listTrades.add(echange);
            }
            ((WanderingTrader) entite).setRecipes(listTrades);

            for(int i = 0; i < listTrades.size(); i++){
                ((WanderingTrader) entite).setRecipe(i, listTrades.get(i));
            }

            server.getLogger().info("   -> Ajout d'un ElTrader " + aff + " à " + loc.toString() + " avec " + listTrades.size() + " échanges différents...");

        } else {
            server.getLogger().info("   -> " + ElTraderManager.getPrefix() + " Echec de la création du Trader... " + loc.toString());
        }

    }

    public String kill() {
        this.entitee.remove();
        server.getLogger().info("   -> " + ElTraderManager.getPrefix() + " Suppression du Trader... " + flatName);
        return flatName;
    }


}
