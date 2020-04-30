package com.elesia.eltrader.api.utils;

import com.elesia.eltrader.api.ElTraderManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

/*
 * Copyright (c) 13/04/2020 23:30. Author of this file Uicias
 * This file is part of ElTrader (ItemCreator).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public class ItemCreator {

    public static ItemStack creerItemQuete(Material mat){
        return creerItemQuete(new ItemStack(mat));
    }
    public static ItemStack creerItemQuete(Material mat, int amount, String name){
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return creerItemQuete(item);
    }

    public static ItemStack creerItemQuete(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(new NamespacedKey(ElTraderManager.getInstance(), "quete"), PersistentDataType.STRING, "oui");
        item.setItemMeta(meta);

        return item;

    }

}
