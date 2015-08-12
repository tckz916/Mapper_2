package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class EnchantmentCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            Util.sendmessage(player, "&cエンチャントを指定してください。");
            return true;
        }
        if (args.length == 1) {
            Util.sendmessage(player, "&cレベルを指定してください。");
            return true;
        }
        if (Enchantment.getByName(args[0]) == null) {
            Util.sendmessage(player, "&c不正なエンチャントです。");
            return true;
        }
        int lvl = 0;
        try {
            lvl = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            Util.sendmessage(player, "&c数値を指定してください。");
        }
        ItemStack itemStack = player.getItemInHand();
        if (itemStack.equals(Material.AIR)) {
            Util.sendmessage(player, "&cアイテムが見つかりません。");
            return true;
        }
        itemStack.addUnsafeEnchantment(Enchantment.getByName(args[0]), lvl);
        Util.sendmessage(player, "&b" + itemStack.getType().name() + "&7に&b" + args[0] + "&7レベル&b" + lvl + "&7を付与しました。");
        return true;
    }
}
