package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class PlayerheadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            getSkull(player, player.getName());
        } else {
            getSkull(player, args[0]);
        }
        return true;
    }

    private void getSkull(Player player, String name) {
        Inventory inventory = player.getInventory();
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullmeta = (SkullMeta) itemStack.getItemMeta();
        skullmeta.setOwner(name);
        itemStack.setItemMeta(skullmeta);
        inventory.addItem(itemStack);
        Util.sendmessage(player, "&b" + name + "&7の頭を手に入れました。");
    }
}
