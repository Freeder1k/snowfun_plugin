package com.hamfred.snowfun;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class LauncherCommand implements CommandExecutor {
    private final Snowfun plugin;
    private final ItemStack launcher;

    LauncherCommand(Snowfun instance) {
        plugin = instance;

        ItemStack launcher = new ItemStack(Material.STICK);
        ItemMeta meta = launcher.getItemMeta();
        meta.setDisplayName("§bSnowball Launcher");

        NamespacedKey key = new NamespacedKey(plugin, "launcher");
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);

        launcher.setItemMeta(meta);


        this.launcher = new ItemStack(launcher);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            p.getInventory().addItem(launcher);
            commandSender.sendMessage("Enjoy!");
        }
        return true;
    }
}
