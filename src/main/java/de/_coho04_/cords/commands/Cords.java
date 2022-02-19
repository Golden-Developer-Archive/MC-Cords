package de._coho04_.cords.commands;

import de._coho04_.cords.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class Cords implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            DecimalFormat f = new DecimalFormat("0.00");
            if (args.length == 0) {
                double x = p.getLocation().getX();
                double y = p.getLocation().getY();
                double z = p.getLocation().getZ();
                String world = p.getLocation().getWorld().getName();
                switch (world) {
                    case "nether" -> world = "im §6Nether§a!";
                    case "end" -> world = "im §6End§a!";
                    case "world" -> world = "in der §6Oberwelt§a!";
                }
                Bukkit.broadcastMessage(Main.Prefix + "§a Die Koordinaten von §6" + p.getName() + " sind [§6X=" + f.format(x) + "§a] [§6Y=" + f.format(y) + "§a] [§6Z=" + f.format(z) + "§a] " + world);
            } else if (args.length == 1){
                if (p.hasPermission("cords.other")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        double x = target.getLocation().getX();
                        double y = target.getLocation().getY();
                        double z = target.getLocation().getZ();
                        String world = target.getLocation().getWorld().getName();
                        switch (world) {
                            case "nether" -> world = "im §6Nether§a!";
                            case "end" -> world = "im §6End§a!";
                            case "world" -> world = "in der §6Oberwelt§a!";
                        }
                        p.sendMessage(Main.Prefix + "§a Die Koordinaten von §6" + target.getName() + " sind [§6X=" + f.format(x) + "§a] [§6Y=" + f.format(y) + "§a] [§6Z=" + f.format(z) + "§a] " + world);
                    } else {
                        p.sendMessage(Main.Prefix + "§c Der Spieler §6[" + args[0] + "]§r konnte nicht gefunden werden!");
                    }
                } else {
                    p.sendMessage(Main.Prefix + "§6 Bitte nutze /Cords um deine Koordinaten anzuzeigen!");
                }
            } else {
                p.sendMessage(Main.Prefix + "§6 Bitte nutze /Cords um deine Koordinaten anzuzeigen!");
            }
        } else {
            Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§c Um den Command nutzen zu können musst du ein Spieler sein!");
        }
        return false;
    }
}
