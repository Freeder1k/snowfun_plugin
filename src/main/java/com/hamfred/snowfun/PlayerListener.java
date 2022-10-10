package com.hamfred.snowfun;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerListener implements Listener {
    private final NamespacedKey key;

    public PlayerListener(Snowfun instance) {
        key = new NamespacedKey(instance, "launcher");
    }

    @EventHandler
    public void onPlayerMove(PlayerInteractEvent event) {
        Action a = event.getAction();
        if ((a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) && event.getItem() != null) {
            ItemStack stick = event.getItem();
            PersistentDataContainer container = stick.getItemMeta().getPersistentDataContainer();

            if (container.has(key, PersistentDataType.BYTE) && container.get(key, PersistentDataType.BYTE) == (byte) 1) {
                Location loc = event.getPlayer().getEyeLocation();
                Snowball snowball = loc.getWorld().spawn(loc, Snowball.class);
                snowball.setVelocity(loc.getDirection());
            }
        }
    }
}
