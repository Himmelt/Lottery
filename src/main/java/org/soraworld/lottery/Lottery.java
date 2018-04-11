package org.soraworld.lottery;

import org.bukkit.event.Listener;
import org.soraworld.lottery.command.CommandLottery;
import org.soraworld.lottery.config.Config;
import org.soraworld.lottery.constant.Constant;
import org.soraworld.lottery.listener.EventListener;
import org.soraworld.violet.VioletPlugin;
import org.soraworld.violet.command.IICommand;
import org.soraworld.violet.config.IIConfig;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Lottery extends VioletPlugin {

    @Nonnull
    protected IIConfig registerConfig(File path) {
        return new Config(path, this);
    }

    @Nonnull
    protected List<Listener> registerEvents(IIConfig config) {
        ArrayList<Listener> listeners = new ArrayList<>();
        if (config instanceof Config) listeners.add(new EventListener((Config) config));
        return listeners;
    }

    @Nullable
    protected IICommand registerCommand(IIConfig config) {
        if (config instanceof Config) return new CommandLottery(Constant.PLUGIN_ID, null, (Config) config, this);
        return null;
    }

    protected void afterEnable() {

    }

    protected void beforeDisable() {

    }

}
