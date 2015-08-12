package com.github.tckz916.mapper.util;

import org.bukkit.entity.Player;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class Util {
    public static String coloring(String str) {
        return str.replaceAll("&([0-9a-fk-or])", "\u00A7$1");
    }

    public static String build(String[] strings, int start) {
        if (strings.length >= start + 1) {
            String str = strings[start];
            if (strings.length >= start + 2) {
                for (int i = start + 1; i < strings.length; i++) {
                    str = str + " " + strings[i];
                }
            }
            return coloring(str);
        } else {
            return null;
        }
    }

    public static void sendmessage(Player player, String msg) {
        player.sendMessage(coloring(msg));
    }


}
