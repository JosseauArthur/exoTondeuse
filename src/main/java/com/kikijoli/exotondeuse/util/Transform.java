/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.util;

import com.kikijoli.exotondeuse.manager.EntityManager;

/**
 *
 * @author troïmaclure
 */
public class Transform {

    public static int transformPoint(int y) {
        return Math.abs(y - (EntityManager.getGarden().getHeight() - 1));
    }
}
