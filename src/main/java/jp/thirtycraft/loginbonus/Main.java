package jp.thirtycraft.loginbonus;

import jp.thirtycraft.loginbonus.events.LoginBonus;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new LoginBonus(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
