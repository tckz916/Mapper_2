package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.EnderChest;

import java.util.HashSet;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class PutchestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (player.getItemInHand().equals(Material.AIR)) {
            Util.sendmessage(player, "&cアイテムが見つかりません。");
            return true;
        }

        @SuppressWarnings("deprecation")
        Block block = player.getTargetBlock((HashSet<Byte>) null, 10);
        if (!(block.getType().equals(Material.CHEST)
                || block.getType().equals(Material.TRAPPED_CHEST))) {
            Util.sendmessage(player, "&cチェストが見つかりません。");
            return true;
        }

        ItemStack itemstack = player.getItemInHand();
        Inventory inventory = ((Chest) block.getState()).getInventory();

        int i = 0;
        int count = 0;
        while (true) {
            int slot = inventory.firstEmpty();
            if (slot == -1 || (i != 0 && count < i)) {
                break;
            }
            inventory.setItem(slot, itemstack);
            count++;
        }

        Util.sendmessage(player, "&b" + itemstack.getType().name() + "&7を&b" + count + "&7個追加しました。");
        return true;
    }
}
