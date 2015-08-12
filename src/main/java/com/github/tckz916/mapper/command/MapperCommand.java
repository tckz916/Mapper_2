package com.github.tckz916.mapper.command;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tckz916 on 2015/08/12.
 */
public class MapperCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        String helpmsg = "&7----- &bCommand Help &7-----";

        ArrayList<String> cmdhelp = new ArrayList<>();
        cmdhelp.add("&7/putchest&f&f: &bターゲットしてるチェスト内に所持アイテムを追加します。");
        cmdhelp.add("&7/clearchest&f: &bターゲットしてるチェスト内のアイテムを削除します。");
        cmdhelp.add("&7/playerhead <name>&f: &bプレイヤーの頭を取得します。");
        cmdhelp.add("&7/getmaterial&f: &b所持アイテムのMaterialを取得します。");
        cmdhelp.add("&7/enchantment <ench> <lvl>&f: &b所持アイテムにエンチャントを付与します。");
        cmdhelp.add("&7/getenchantment&f: &b所持アイテムのエンチャント効果を取得します。");
        cmdhelp.add("&7/setname <name>&f: &b所持アイテムの名前を変更します。");
        cmdhelp.add("&7/setlore <lore>&f: &b所持アイテムの説明を変更します。&7(&f&l;&7で改行が可能です。)");
        Collections.sort(cmdhelp);

        Util.sendmessage(player, helpmsg);
        int i = 0;
        while (i < cmdhelp.size()) {
            Util.sendmessage(player, cmdhelp.get(i));
            i++;
        }
        return true;
    }
}
