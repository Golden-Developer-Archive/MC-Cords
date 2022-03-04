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

public class Cords implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            DecimalFormat f = new DecimalFormat("0.00");
            double x = p.getLocation().getX();
            double y = p.getLocation().getY();
            double z = p.getLocation().getZ();

            String world = p.getLocation().getWorld().getName();
            switch (world) {
                case "nether" -> world = "Nether";
                case "end" -> world = "End";
                case "world" -> world = "Oberwelt";
            }

            if (args.length == 0) {
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§8--------- CORDS ---------");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§6Spieler: " + p.getName());
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§6X: " + f.format(x));
                Bukkit.broadcastMessage("§6Y: " + f.format(y));
                Bukkit.broadcastMessage("§6Z: " + f.format(z));
                Bukkit.broadcastMessage("§6Welt: " + world + "!");
                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage("§8-------------------------");
                Bukkit.broadcastMessage("");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.sendMessage("");
                    target.sendMessage("§8--------------------------");
                    target.sendMessage("");
                    target.sendMessage("§6Spieler: " + p.getName());
                    target.sendMessage("");
                    target.sendMessage("§6X: " + f.format(x));
                    target.sendMessage("§6Y: " + f.format(y));
                    target.sendMessage("§6Z: " + f.format(z));
                    target.sendMessage("§6Welt: " + world + "!");
                    target.sendMessage("");
                    target.sendMessage("§8--------------------------");
                    target.sendMessage("");
                } else {
                    p.sendMessage(Main.Prefix + "§c Der Spieler konnte nicht gefunden werden!");
                }
            } else {
                p.sendMessage(Main.Prefix + "§4 Bitte nutze /Cords oder /Cords <Spieler> !");
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
