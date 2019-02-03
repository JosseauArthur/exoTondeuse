/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.manager;

import com.kikijoli.exotondeuse.business.logical.Garden;
import com.kikijoli.exotondeuse.business.drawable.Mower;
import com.kikijoli.exotondeuse.exception.EmptyLineException;
import com.kikijoli.exotondeuse.exception.MowerCommandException;
import com.kikijoli.exotondeuse.exception.MowerInitializationException;
import com.kikijoli.exotondeuse.exception.SizeNotValidException;
import com.kikijoli.exotondeuse.thread.Cycle;
import com.kikijoli.exotondeuse.util.Orientation;
import java.awt.Point;

/**
 *
 * @author Arthur JOSSEAU
 */
public class CommandManager {

    public final static String MOWER_COMMAND_ALLOWED = "GDA";

    public static void analyze(String commandLines) throws EmptyLineException, SizeNotValidException, MowerInitializationException, MowerCommandException {

        if (commandLines.trim().isEmpty()) {
            throw new EmptyLineException();
        }
        String[] splitCommandLine = commandLines.split("\n");
        String size = splitCommandLine[0];
        Point rectSize = EntityManager.checkSize(size);
        EntityManager.setGarden(new Garden(rectSize.x, rectSize.y, EntityManager.addMowers(splitCommandLine)));
        EntityManager.getGarden().getMowers().stream().forEach((mower) -> {
            BotManager.createBots(mower);
        });

        new Thread(new Cycle()).start();
    }

}
