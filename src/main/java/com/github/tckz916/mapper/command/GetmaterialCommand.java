package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class GetmaterialCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        ItemStack itemStack = player.getItemInHand();
        Util.sendmessage(player,"&7Materialは&b" + itemStack.getType().name() + "&7です。");
        return true;
    }
}
