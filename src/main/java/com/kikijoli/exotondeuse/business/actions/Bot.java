/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.business.actions;

import com.kikijoli.exotondeuse.business.drawable.Mower;
import com.kikijoli.exotondeuse.manager.EntityManager;

/**
 *
 * @author Arthur JOSSEAU
 */
public class Bot {

    private final Mower mower;
    private final String target;

    public Bot(Mower mower, String target) {
        this.mower = mower;
        this.target = target;
    }

    public void act() {

        switch (target.toUpperCase()) {

            case ";":
                EntityManager.mowerFinish(mower);
                break;
            case "A":
                EntityManager.mowerMove(mower);
                break;
            default:
                EntityManager.changeMowerOrientation(mower, target);
                break;
        }
    }
}
