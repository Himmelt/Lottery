package org.soraworld.lottery.config;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.soraworld.lottery.constant.Constant;
import org.soraworld.lottery.economy.Economy;
import org.soraworld.violet.config.IIConfig;

import javax.annotation.Nonnull;
import java.io.File;

public class Config extends IIConfig {

    public Config(File path, Plugin plugin) {
        super(path, plugin);
    }

    protected void loadOptions() {

    }

    protected void saveOptions() {

    }

    public void afterLoad() {
        Economy.checkEconomy(this);
    }

    @Nonnull
    protected ChatColor defaultChatColor() {
        return ChatColor.DARK_AQUA;
    }

    @Nonnull
    protected String defaultChatHead() {
        return "[" + Constant.PLUGIN_NAME + "] ";
    }

    public String defaultAdminPerm() {
        return Constant.PERM_ADMIN;
    }

}
