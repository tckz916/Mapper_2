package com.github.tckz916.mapper.listener;

import com.github.tckz916.mapper.util.Util;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * Created by tckz916 on 2015/08/13.
 */
public class BlockListener implements Listener {

    @EventHandler
    public void onSign(SignChangeEvent event) {
        for (int i = 0; i <= 3; i++) {
            event.setLine(i, Util.coloring(event.getLine(i)));
        }
    }

}
