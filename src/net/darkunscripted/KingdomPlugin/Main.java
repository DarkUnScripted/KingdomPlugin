package net.darkunscripted.KingdomPlugin;

import net.darkunscripted.KingdomPlugin.commands.KingdomCommand;
import net.darkunscripted.KingdomPlugin.commands.SkillCommand;
import net.darkunscripted.KingdomPlugin.events.*;
import net.darkunscripted.KingdomPlugin.managers.FarmingSkill;
import net.darkunscripted.KingdomPlugin.managers.Kingdom;
import net.darkunscripted.KingdomPlugin.managers.MiningSkill;
import net.darkunscripted.KingdomPlugin.managers.WoodcutterSkill;
import net.darkunscripted.KingdomPlugin.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommands();
        registerManagers();
        registerEvents();
        getConfig();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
    }

    public void registerCommands(){
        getCommand("kingdom").setExecutor(new KingdomCommand());
        getCommand("skill").setExecutor(new SkillCommand());
    }

    public void registerManagers(){
        new FarmingSkill();
        new MiningSkill();
        new WoodcutterSkill();
        new Kingdom();
        new Utils();
    }

    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new Chat(), this);
        getServer().getPluginManager().registerEvents(new Death(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);
        getServer().getPluginManager().registerEvents(new Break(), this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
        getServer().getPluginManager().registerEvents(new Move(), this);
    }
}
