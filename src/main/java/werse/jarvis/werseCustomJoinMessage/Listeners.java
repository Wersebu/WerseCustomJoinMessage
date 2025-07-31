package werse.jarvis.werseCustomJoinMessage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Listeners implements Listener {

    private final JavaPlugin plugin;
    private final boolean first_join_enabled;
    private final String first_join_message;
    private final String join_msg;
    private final String leave_msg;



    public Listeners(JavaPlugin plugin) {
        this.plugin = plugin;
        this.first_join_enabled = plugin.getConfig().getBoolean("general.first_join.enabled");
        this.first_join_message = plugin.getConfig().getString("general.first_join.first_join_message");
        this.join_msg = plugin.getConfig().getString("general.join_message");
        this.leave_msg = plugin.getConfig().getString("general.leave_message");
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        String userName = player.getName();
        String firstJoinFormated = ColorChat.applyColors(first_join_message.replace("%player%", userName));
        String joinMsgFormated = ColorChat.applyColors(join_msg.replace("%player%", userName));
        String customJoinMSG = ColorChat.applyColors(getPermissionJoinMessage(player).replace("%player%", userName));
        if (first_join_enabled) {
            if (!player.hasPlayedBefore()) {
                Bukkit.getServer().broadcastMessage(firstJoinFormated);
                event.setJoinMessage(null);
                return;
            }
        }


        if (!customJoinMSG.equalsIgnoreCase(" ")) {
            event.setJoinMessage(null);
            Bukkit.getServer().broadcastMessage(customJoinMSG);
        } else {
            event.setJoinMessage(null);
            Bukkit.getServer().broadcastMessage(joinMsgFormated);
        }



    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String userName = player.getName();
        String leaveMSGFormated = ColorChat.applyColors(leave_msg.replace("%player%", userName));
        String customQuitMSG = ColorChat.applyColors(getPermissionQuitMessage(player).replace("%player%", userName));


        if (!customQuitMSG.equalsIgnoreCase(" ")) {
            event.setQuitMessage(null);
            Bukkit.getServer().broadcastMessage(customQuitMSG);
        } else {
            event.setQuitMessage(null);
            Bukkit.getServer().broadcastMessage(leaveMSGFormated);
        }

    }

    private String getPermissionJoinMessage(Player player) {
        ConfigurationSection customSection = plugin.getConfig().getConfigurationSection("custom_message");
        if (customSection != null) {
            for (String key : customSection.getKeys(false)) {
                String perm = customSection.getString(key + ".permission");
                if (perm != null && player.hasPermission(perm)) {
                    String customJoinMessage = customSection.getString(key + ".join_message");
                    return customJoinMessage;
                }
            }
        }
        return " ";
    }

    private String getPermissionQuitMessage(Player player) {
        ConfigurationSection customSection = plugin.getConfig().getConfigurationSection("custom_message");
        if (customSection != null) {
            for (String key : customSection.getKeys(false)) {
                String perm = customSection.getString(key + ".permission");
                if (perm != null && player.hasPermission(perm)) {
                    String customQuitMessage = customSection.getString(key + ".leave_message");
                    return customQuitMessage;
                }
            }
        }
        return " ";
    }
}
