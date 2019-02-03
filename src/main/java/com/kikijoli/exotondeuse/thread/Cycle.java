/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.thread;

import com.kikijoli.exotondeuse.manager.BotManager;
import com.kikijoli.exotondeuse.manager.UiManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur JOSSEAU
 */
public class Cycle implements Runnable {

    public final static int DELAY = 1000;

    @Override
    public void run() {
        UiManager.getFrame().executeBtn.setEnabled(false);
        //FIFO strategy
        while (!BotManager.getBots().isEmpty()) {
            UiManager.getMainPanel().repaint();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cycle.class.getName()).log(Level.SEVERE, null, ex);
            }
            //act first
            BotManager.getBots().get(0).act();
            //remove first
            BotManager.getBots().remove(0);
            UiManager.getMainPanel().repaint();
        }
        UiManager.getMainPanel().repaint();
        UiManager.getFrame().executeBtn.setEnabled(true);
    }

}
