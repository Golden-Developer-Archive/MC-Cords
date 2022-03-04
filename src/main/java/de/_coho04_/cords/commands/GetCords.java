package de._coho04_.cords.commands;

import de._coho04_.cords.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GetCords implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    String world = p.getLocation().getWorld().getName();
                    switch (world) {
                        case "nether" -> world = "Nether";
                        case "end" -> world = "End";
                        case "world" -> world = "Oberwelt";
                    }

                    double x = target.getLocation().getX();
                    double y = target.getLocation().getY();
                    double z = target.getLocation().getZ();

                    DecimalFormat f = new DecimalFormat("0.00");

                    p.sendMessage("");
                    p.sendMessage("§8--------------------------");
                    p.sendMessage("");
                    p.sendMessage("§6Spieler: " + target.getName());
                    p.sendMessage("");
                    p.sendMessage("§6X: " + f.format(x));
                    p.sendMessage("§6Y: " + f.format(y));
                    p.sendMessage("§6Z: " + f.format(z));
                    p.sendMessage("§6Welt: " + world + "!");
                    p.sendMessage("");
                    p.sendMessage("§8--------------------------");
                    p.sendMessage("");
                } else {
                    p.sendMessage(Main.Prefix + "§c Der Spieler konnte nicht gefunden werden!");
                }
            } else {
                p.sendMessage(Main.Prefix + "§4 Bitte nutze /GetCords <Spieler> !");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§c Um den Command nutzen zu können musst du ein Spieler sein!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            for (Player p : Bukkit.getOnlinePlayers()) {
                list.add(p.getName());
            }
            return list;
        }
        return null;
    }
}