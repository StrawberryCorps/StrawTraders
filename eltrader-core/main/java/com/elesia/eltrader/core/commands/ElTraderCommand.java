package com.elesia.eltrader.core.commands;

import com.elenox.api.command.AbstractCommand;
import com.elenox.api.player.ElAccesLevel;
import com.elenox.api.util.SymbolUtils;
import com.elesia.eltrader.api.ElTraderManager;
import com.elesia.eltrader.api.manager.ElTrader;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

/*
 * Copyright (c) 12/14/2020 17:00. Author of this file Uicias
 * This file is part of ElTrader (ElTraderCommand).
 * ElTrader can not be copied and/or distributed without the express permission of Elesia SAS.
 */

public class ElTraderCommand extends AbstractCommand {

    public ElTraderCommand() {
        super(ElTraderManager.getInstance(), false, ElAccesLevel.ADMINISTRATEUR);
        plugin.getLogger().info("   -> Enregistrement de la commande " + ElTraderCommand.class.getName());
    }

    @Override
    protected boolean onCommand(CommandSender commandSender, String s, String[] strings) {

        if (strings.length != 0) {

            if (strings[0].equalsIgnoreCase("rm") || strings[0].equalsIgnoreCase("remove")) {

                if (strings.length == 1) {
                    ((Player) commandSender).sendMessage(ElTraderManager.getPrefix() + "§cUsage : /" + s + " " + strings[0] + "<all | {nom}>");
                    return true;
                }

                if (strings[1].equalsIgnoreCase("all")) {
                    ElTraderManager.getInstance().killAllTraders();
                    ((Player) commandSender).sendMessage(ElTraderManager.getPrefix() + "§7Vous venez de tuer tout les traders.");
                } else {
                    ElTrader t = ElTraderManager.getInstance().getByFlatName(strings[1]);

                    if (t != null) {
                        t.kill();
                        ElTraderManager.getInstance().removeByFlat(strings[1]);
                    } else {
                        ((Player) commandSender).sendMessage(ElTraderManager.getPrefix() + "§cAucun trader trouvé avec ce nom " + SymbolUtils.DEATH);
                        return false;
                    }

                }

            } else if (strings[0].equalsIgnoreCase("ls") || strings[0].equalsIgnoreCase("list")) {

                Iterator<String> it = ElTraderManager.getInstance().getEveryFlat().iterator();

                String msg = "§8[";

                while (it.hasNext()) {
                    msg = msg.concat("§7" + it.next());
                    if (it.hasNext())
                        msg = msg.concat("§8,");
                }
                msg = msg.concat("§8]");

                ((Player) commandSender).sendMessage(ElTraderManager.getPrefix() + msg);
                return true;
            }
        } else {
            ((Player) commandSender).sendMessage(ElTraderManager.getPrefix() + "§cUsage : /" + s + " <list | remove>");
        }
        return true;
    }
}
