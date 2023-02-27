package jp.thirtycraft.loginbonus;

import jp.thirtycraft.loginbonus.events.LoginBonus;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    JavaPlugin plugin = this;
    Logger logger = Logger.getLogger("lb");

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new LoginBonus(), this);
        logger.info("login bonusが正常に起動しました");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
