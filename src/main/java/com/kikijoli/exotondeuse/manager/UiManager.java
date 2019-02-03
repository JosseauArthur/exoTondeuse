/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.manager;

import com.kikijoli.exotondeuse.ui.MainFrame;
import com.kikijoli.exotondeuse.ui.MainPanel;
import javax.swing.JFrame;

/**
 *
 * @author Arthur JOSSEAU
 */
public class UiManager {

    private static MainFrame frame;

    public static void initialize() {
        frame = new MainFrame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static MainFrame getFrame() {
        return frame;

    }

    public static MainPanel getMainPanel() {
        return frame.getMainPanel();
    }
}
