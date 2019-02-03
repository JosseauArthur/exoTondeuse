/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.business.drawable;

import com.kikijoli.exotondeuse.util.Orientation;
import com.kikijoli.exotondeuse.util.Size;
import com.kikijoli.exotondeuse.util.Transform;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Arthur JOSSEAU
 */
public class Mower extends Entity {

    private int orientation;
    private String command;

    public Mower(int x, int y, int orientation, String command) {
        //-1 because this program expects 1 to be the beginning instead of 0 (array's beginning)
        super(Color.RED, x - 1, y - 1);

        this.orientation = orientation;
        this.command = command;
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        g.setColor(Color.BLACK);
        drawOrientation(g);
    }

    private void drawOrientation(Graphics2D g) {
        int pointSize = 10;
        switch (orientation) {
            case Orientation.NORTH:
                g.fillRect((x * Size.ENTITY_SIZE) + (Size.ENTITY_SIZE / 2) - pointSize / 2, (Transform.transformPoint(y) * Size.ENTITY_SIZE), pointSize, pointSize);
                break;
            case Orientation.SOUTH:
                g.fillRect((x * Size.ENTITY_SIZE) + (Size.ENTITY_SIZE / 2) - pointSize / 2, (Transform.transformPoint(y) * Size.ENTITY_SIZE) + Size.ENTITY_SIZE - pointSize, pointSize, pointSize);
                break;
            case Orientation.EAST:
                g.fillRect((x * Size.ENTITY_SIZE) + Size.ENTITY_SIZE - pointSize, (Transform.transformPoint(y) * Size.ENTITY_SIZE) + Size.ENTITY_SIZE / 2 - (pointSize / 2), pointSize, pointSize);
                break;
            case Orientation.WEST:
                g.fillRect((x * Size.ENTITY_SIZE), (Transform.transformPoint(y) * Size.ENTITY_SIZE) + Size.ENTITY_SIZE / 2 - pointSize / 2, pointSize, pointSize);
                break;
        }
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
