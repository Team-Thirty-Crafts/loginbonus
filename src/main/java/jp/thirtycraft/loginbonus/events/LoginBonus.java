package jp.thirtycraft.loginbonus.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LoginBonus implements Listener {
    private Map<Player, Date> lastLoginTime = new HashMap<>();
    private Material[] materials = {
            Material.IRON_INGOT
    }; // Material.(ItemID)

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Date now = new Date();
        Date last = lastLoginTime.get(player);

        int daysSinceLastLogin = (int) ((now.getTime() - last.getTime()) / (24 * 60 * 60 * 1000));

        if (last == null || daysSinceLastLogin >= 1) {
            Random random = new Random();
            int randomIndex = random.nextInt(materials.length);
            Material randomMaterial = materials[randomIndex];

            player.sendMessage(ChatColor.GREEN + "ログインボーナスで" + randomMaterial + "をプレゼント!");
            player.getInventory().addItem(new ItemStack(randomMaterial, 1));
        }

        lastLoginTime.put(player, now);
    }
}

