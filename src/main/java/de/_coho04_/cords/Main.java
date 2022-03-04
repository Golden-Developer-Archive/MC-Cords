package de._coho04_.cords;

import de._coho04_.cords.commands.Cords;
import de._coho04_.cords.commands.GetCords;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String Prefix = "[§aCords§r] ";

    @Override
    public void onEnable() {
        PluginCommand cords = getCommand("cords");
        cords.setExecutor(new Cords());
        cords.setTabCompleter(new Cords());

        PluginCommand getCords = getCommand("getCords");
        getCords.setExecutor(new GetCords());
        getCords.setTabCompleter(new GetCords());

        Bukkit.getConsoleSender().sendMessage(Prefix + "§a Cords nun Online");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4 Cords nun Offline");
    }
}
