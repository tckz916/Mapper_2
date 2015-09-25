package com.github.tckz916.mapper.command.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class EnchantmentTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }

        List<String> list = new ArrayList<>();

        if (args.length == 1) {
            List<String> ench = new ArrayList<>();
            for (Enchantment enchantment : Enchantment.values()) {
                ench.add(enchantment.getName());
            }
            StringUtil.copyPartialMatches(args[0], ench, list);
        }

        Collections.sort(list);

        return list;
    }
}
