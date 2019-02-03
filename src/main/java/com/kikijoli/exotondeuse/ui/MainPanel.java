/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.ui;

import com.kikijoli.exotondeuse.manager.EntityManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Arthur JOSSEAU
 */
public class MainPanel extends JPanel {

    public MainPanel() {
        super(true);
    }

    public void paintComponent(Graphics gr) {

        Graphics2D g = (Graphics2D) gr;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHints(rh);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        EntityManager.getGarden().draw(g);
    }

}
