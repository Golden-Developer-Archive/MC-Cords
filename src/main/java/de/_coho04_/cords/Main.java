package de._coho04_.cords;

import de._coho04_.cords.commands.Cords;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String Prefix = "[Cords] ";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(Prefix + "§a Cords nun Online");
        getCommand("cords").setExecutor(new Cords());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4 Cords nun Online");
    }
}
