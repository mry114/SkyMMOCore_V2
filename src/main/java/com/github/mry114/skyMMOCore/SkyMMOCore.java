package com.github.mry114.skyMMOCore;

import com.github.mry114.skyMMOCore.bukkit.listener.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMMOCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
