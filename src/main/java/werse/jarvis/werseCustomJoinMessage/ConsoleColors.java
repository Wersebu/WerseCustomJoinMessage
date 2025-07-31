package werse.jarvis.werseCustomJoinMessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsoleColors {

    private static String colorize(String hex, String message) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        return String.format("\u001B[38;2;%d;%d;%dm%s\u001B[0m", r, g, b, message);
    }

    public static void displayStartupMessage(JavaPlugin plugin) {

        String version = plugin.getDescription().getVersion();

        Bukkit.getLogger().info(colorize("#FB08D7","╭───────────────────────────────────╮"));
        Bukkit.getLogger().info(colorize("#FB08D7","│                                   │"));
        Bukkit.getLogger().info(colorize("#FB08D7","│") + colorize("#08FB85","  WerseCustomJoinMessage") + colorize("#FB08D7","           │"));
        Bukkit.getLogger().info(colorize("#FB08D7","│") + colorize("#FB08D7","                                   │"));
        Bukkit.getLogger().info(colorize("#FB08D7","│")  + colorize("#08F1FB","  Powered by xxWersebuxx") + colorize("#FB08D7","           │"));
        Bukkit.getLogger().info(colorize("#FB08D7","│                                   │"));
        Bukkit.getLogger().info(colorize("#FB08D7","╰───────────────────────────────────╯"));
        Bukkit.getLogger().info(colorize("#FB08D7","│" + colorize("#08FBC0","  Version ") + version));
        Bukkit.getLogger().info(colorize("#FB08D7","╰───────────────────────────────────"));
        Bukkit.getLogger().info("");
    }
}
