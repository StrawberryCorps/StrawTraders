package bzh.strawberry.strawTrader.api.utils;

import bzh.strawberry.strawTrader.api.StrawTraderManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

/*
 * Copyright (c) 13/04/2020 23:30. Author of this file Uicias
 * This file is part of StrawTrader (ItemCreator).
 * StrawTrader can not be copied and/or distributed without the express permission of Uicias.
 */

public class ItemCreator extends ItemStack implements Comparable<ItemCreator> {

    private int position;

    public ItemCreator(Material type, int position) {
        super(type);
        this.position = position;
    }

    public ItemCreator(Material type, int amount, String name, int position) {
        super(type, amount);
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName(name);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(new NamespacedKey(StrawTraderManager.getInstance(), "quete"), PersistentDataType.STRING, "oui");
        super.setItemMeta(meta);
        this.position = position;
    }

    public ItemCreator(Material type, int amount, String name) {
        super(type, amount);
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName(name);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(new NamespacedKey(StrawTraderManager.getInstance(), "quete"), PersistentDataType.STRING, "oui");
        super.setItemMeta(meta);
        this.position = 0;
    }

    public ItemCreator(Material type, int amount, int position) {
        super(type, amount);
        this.position = position;
    }

    @Override
    public int compareTo(ItemCreator o) {
        return Integer.compare(position, o.position);
    }
}
