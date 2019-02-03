/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.business.drawable;

import com.kikijoli.exotondeuse.interfaces.IDrawable;
import com.kikijoli.exotondeuse.util.Size;
import com.kikijoli.exotondeuse.util.Transform;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Arthur JOSSEAU
 */
public abstract class Entity extends Point implements IDrawable {

    private Color color;

    public Entity(Color color, int x, int y) {
        super(x, y);
        this.color = color;
    }

    /**
     *
     * Need transform => The starting point of java is at the top left, contrary
     * to the request that places it at the bottom left
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        Rectangle r = new Rectangle(x * Size.ENTITY_SIZE, Transform.transformPoint(y) * Size.ENTITY_SIZE, Size.ENTITY_SIZE, Size.ENTITY_SIZE);
        g.fill(r);
        g.setColor(Color.BLACK);
        g.draw(r);
        g.setColor(Color.BLUE);
        g.drawString((x + 1) + " " + (y + 1), x * Size.ENTITY_SIZE, Transform.transformPoint(y) * Size.ENTITY_SIZE + 10);
    }
}
