package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * Created by tckz916 on 2015/08/13.
 */
public class SetloreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        ItemStack itemStack = player.getItemInHand();
        if (itemStack.getType().equals(Material.AIR)) {
            Util.sendmessage(player, "&cアイテムが見つかりません。");
            return true;
        }
        if (args.length == 0) {
            Util.sendmessage(player, "&c名前を指定してください。");
            return true;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        String lore = Util.build(args, 0);
        assert lore != null;
        itemMeta.setLore(Arrays.asList(lore.split(";")));
        itemStack.setItemMeta(itemMeta);
        Util.sendmessage(player, "&b" + itemStack.getType().name() + "&7の説明を&r" + lore + "&7に変更しました。");
        return true;
    }
}
