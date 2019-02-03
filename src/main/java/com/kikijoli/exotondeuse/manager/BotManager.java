/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.manager;

import com.kikijoli.exotondeuse.business.actions.Bot;
import com.kikijoli.exotondeuse.business.drawable.Mower;
import java.util.ArrayList;

/**
 *
 * @author Arthur JOSSEAU
 */
public class BotManager {

    private static final ArrayList<Bot> bots = new ArrayList<>();

    public static ArrayList<Bot> getBots() {
        return bots;
    }

    public static void createBots(Mower mower) {
        String cmd = mower.getCommand().trim();
        String[] split = cmd.split("");
        for (String s : split) {
            getBots().add(new Bot(mower, s));
        }
    }
}
