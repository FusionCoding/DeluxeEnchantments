package de.fusion.deluxeenchantments;

import co.aikar.taskchain.BukkitTaskChainFactory;
import co.aikar.taskchain.TaskChain;
import co.aikar.taskchain.TaskChainFactory;
import com.google.gson.GsonBuilder;
import de.fusion.deluxeenchantments.config.ConfigManager;
import de.fusion.deluxeenchantments.gson.DeluxeEffect;
import de.fusion.deluxeenchantments.gson.DeluxeItem;
import de.fusion.deluxeenchantments.gson.DeluxeItemType;
import de.fusion.deluxeenchantments.gson.Effects;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeluxeEnchantments extends JavaPlugin {

    private ExecutorService executorService = Executors.newCachedThreadPool();
    private static DeluxeEnchantments instance;
    private static ConfigManager configuration;
    private boolean running;
    private static TaskChainFactory taskChainFactory;


    @Override
    public void onLoad() {
        instance = this;
        running = true;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        taskChainFactory = BukkitTaskChainFactory.create(this);

        File config = new File(getDataFolder(), "config.yml");
        if (!getDataFolder().exists()) getDataFolder().mkdir();
        if (!config.exists())
            saveResource("config.yml", true);
        configuration = new ConfigManager(config).build();
        log("Loaded DeluxeEnchantments by FusionCoding");

        PluginManager pm = Bukkit.getPluginManager();

        DeluxeItem item = new DeluxeItem();
        item.setCountKills(true);
        item.setDisplayName("&aBest Sword Ever");
        List<DeluxeEffect> l = new ArrayList<>();
        l.add(new DeluxeEffect(Effects.DOUBLE_HIT, "5"));
        l.add(new DeluxeEffect(Effects.LIFE_STEALING, "70"));
        l.add(new DeluxeEffect(Effects.PERMANENT, "SPEED#30#2#5"));
        l.add(new DeluxeEffect(Effects.EFFECT_TO_SELF, "SPEED#30#2#5"));
        item.setEffects(l);
        List<String> l2 = new ArrayList<>();
        l2.add("SHARPNESS#1");
        item.setEnchantments(l2);
        item.setItemType(DeluxeItemType.WEAPON);
        item.setLore("This is best sword i swear");
        item.setMaterial(Material.DIAMOND_SWORD.name());
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(item));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        running = false;
    }


    public void log(String message) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + message);
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public static DeluxeEnchantments getInstance() {
        return instance;
    }

    public static ConfigManager getConfiguration() {
        return configuration;
    }

    public static String getPrefix() {
        return getConfiguration().getPath("General.Prefix").getString();
    }

    public static <T> TaskChain<T> newChain() {
        return taskChainFactory.newChain();
    }

    public static <T> TaskChain<T> newSharedChain(String name) {
        return taskChainFactory.newSharedChain(name);
    }
}
