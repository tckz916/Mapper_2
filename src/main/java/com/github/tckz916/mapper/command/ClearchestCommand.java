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

import java.util.HashSet;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class ClearchestCommand implements CommandExecutor {

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
        if (!block.getType().equals(Material.CHEST)) {
            Util.sendmessage(player, "&cチェストが見つかりません。");
            return true;
        }

        Inventory inventory = ((Chest) block.getState()).getInventory();

        inventory.clear();
        Util.sendmessage(player, "&7インベントリ内のアイテムを削除しました。");
        return true;
    }
}
