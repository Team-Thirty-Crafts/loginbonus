package jp.thirtycraft.loginbonus.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LoginBonus extends JavaPlugin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.GREEN + "サーバーへようこそ! ログインボーナスはこちらです。50枚のコインをプレゼント!");
        // ボーナスをプレイヤーのゲーム内通貨に加算する（該当する場合）。
    }
}