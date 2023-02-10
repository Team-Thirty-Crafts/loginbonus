package jp.thirtycraft.loginbonus.events;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LoginBonus extends JavaPlugin implements Listener {
    private Map<Player, Date> lastLoginTime = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Date now = new Date();
        Date last = lastLoginTime.get(player);

        if (last == null || now.getTime() - last.getTime() >= 24 * 60 * 60 * 1000) {
            player.sendMessage(ChatColor.GREEN + "サーバーへようこそ! ログインボーナスはこちらです。50枚のコインをプレゼント!");
            // ボーナスをプレイヤーのゲーム内通貨に加算する（該当する場合）。
        }

        lastLoginTime.put(player, now);
    }
}
