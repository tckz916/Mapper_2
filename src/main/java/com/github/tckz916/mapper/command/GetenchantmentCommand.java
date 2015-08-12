package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class GetenchantmentCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        ItemStack itemStack = player.getItemInHand();
        Map<Enchantment, Integer> ench = itemStack.getEnchantments();
        Util.sendmessage(player, "&b" + itemStack.getType().name() + "&7に付与されているエンチャントは...");
        for (Enchantment enchantment : Enchantment.values()) {
            if (ench.get(enchantment) != null) {
                Util.sendmessage(player, "&7エンチャント&f&l: &b" + enchantment.getName() + " &7レベル&f&l: &b" + ench.get(enchantment));
            }
        }
        return true;
    }
}
