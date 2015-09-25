package com.github.tckz916.mapper;

import com.github.tckz916.mapper.command.*;
import com.github.tckz916.mapper.command.tabcomplete.EnchantmentTabComplete;
import com.github.tckz916.mapper.listener.BlockListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class Mapper extends JavaPlugin {

    private static Mapper instance;

    private PluginManager pm = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        registercommand();
        registerlistener();

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }


    private void registercommand() {
        getCommand("mapper").setExecutor(new MapperCommand());
        getCommand("putchest").setExecutor(new PutchestCommand());
        getCommand("clearchest").setExecutor(new ClearchestCommand());
        getCommand("playerhead").setExecutor(new PlayerheadCommand());
        getCommand("getmaterial").setExecutor(new GetmaterialCommand());
        getCommand("enchantment").setExecutor(new EnchantmentCommand());
        getCommand("enchantment").setTabCompleter(new EnchantmentTabComplete());
        getCommand("getenchantment").setExecutor(new GetenchantmentCommand());
        getCommand("setname").setExecutor(new SetnameCommand());
        getCommand("setlore").setExecutor(new SetloreCommand());
    }

    private void registerlistener() {
        pm.registerEvents(new BlockListener(), this);
    }

    public static Mapper getInstance() {
        return instance;
    }
}
