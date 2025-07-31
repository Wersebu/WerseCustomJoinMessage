package werse.jarvis.werseCustomJoinMessage;

import org.bukkit.plugin.java.JavaPlugin;

public final class WerseCustomJoinMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleColors.displayStartupMessage(this);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Listeners(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
