package jp.thirtycraft.loginbonus.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoginBonus extends JavaPlugin implements Listener {
    private Map<Player, Date> lastLoginTime = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Date now = new Date();
        Date last = lastLoginTime.get(player);

        int daysSinceLastLogin = (int) ((now.getTime() - last.getTime()) / (24 * 60 * 60 * 1000));
        int bonusAmount = 1 + (daysSinceLastLogin + 1);

        if (last == null || daysSinceLastLogin >= 1) {
            player.sendMessage(ChatColor.GREEN + "ログインボーナスで" + bonusAmount + "個のアイテムをプレゼント!");
            player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, bonusAmount));
        }

        lastLoginTime.put(player, now);
    }

}
