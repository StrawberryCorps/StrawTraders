package bzh.strawberry.strawTrader.core.commands;

import bzh.strawberry.strawTrader.api.StrawTraderManager;
import bzh.strawberry.strawTrader.api.manager.StrawTrader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

/*
 * Copyright (c) 12/14/2020 17:00. Author of this file Uicias
 * This file is part of StrawTrader (StrawtraderCommand).
 * StrawTrader can not be copied and/or distributed without the express permission of Uicias.
 */

public class StrawtraderCommand implements CommandExecutor {

    public StrawtraderCommand() {
        bzh.strawberry.strawTrader.core.StrawTraderManager.INSTANCE.getLogger().info("   -> Enregistrement de la commande " + StrawtraderCommand.class.getName());
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length != 0) {

            if (strings[0].equalsIgnoreCase("rm") || strings[0].equalsIgnoreCase("remove")) {

                if (strings.length == 1) {
                    ((Player) commandSender).sendMessage(StrawTraderManager.getPrefix() + "§cUsage : /" + s + " " + strings[0] + "<all | {nom}>");
                    return true;
                }

                if (strings[1].equalsIgnoreCase("all")) {
                    StrawTraderManager.getInstance().killAllTraders();
                    ((Player) commandSender).sendMessage(StrawTraderManager.getPrefix() + "§7Vous venez de tuer tout les traders.");
                } else {
                    StrawTrader t = StrawTraderManager.getInstance().getByFlatName(strings[1]);

                    if (t != null) {
                        t.kill();
                        StrawTraderManager.getInstance().removeByFlat(strings[1]);
                    } else {
                        ((Player) commandSender).sendMessage(StrawTraderManager.getPrefix() + "§cAucun trader trouvé avec ce nom ");
                        return false;
                    }

                }

            } else if (strings[0].equalsIgnoreCase("ls") || strings[0].equalsIgnoreCase("list")) {

                Iterator<String> it = StrawTraderManager.getInstance().getEveryFlat().iterator();

                String msg = "§8[";

                while (it.hasNext()) {
                    msg = msg.concat("§7" + it.next());
                    if (it.hasNext())
                        msg = msg.concat("§8,");
                }
                msg = msg.concat("§8]");

                ((Player) commandSender).sendMessage(StrawTraderManager.getPrefix() + msg);
                return true;
            }
        } else {
            ((Player) commandSender).sendMessage(StrawTraderManager.getPrefix() + "§cUsage : /" + s + " <list | remove>");
        }
        return true;
    }
}
