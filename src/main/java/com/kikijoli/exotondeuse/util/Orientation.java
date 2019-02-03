/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.util;

import java.util.HashMap;

/**
 *
 * @author Arthur JOSSEAU
 */
public class Orientation {

    public final static int NORTH = 0;
    public final static int WEST = 1;
    public final static int SOUTH = 2;
    public final static int EAST = 3;

    private static HashMap<String, Integer> orientations = new HashMap<>();

    static {
        orientations.put(Cardinality.NORTH, NORTH);
        orientations.put(Cardinality.WEST, WEST);
        orientations.put(Cardinality.SOUTH, SOUTH);
        orientations.put(Cardinality.EAST, EAST);
    }

    /**
     *
     * @param st
     * @return N = 0 , W = 1 , S = 2 , E = 3
     * <br> return 0 by default
     */
    public static int parseOrientation(String st) {
        return orientations.getOrDefault(st, NORTH);
    }

    /**
     *
     * @param st
     * @return 0 = N , 1 = W , 2 = S , 3 = E
     * <br> return null if not found
     */
    public static String getOrientationString(int orientation) {
        for (String string : orientations.keySet()) {
            if (orientations.get(string).equals(orientation)) {
                return string;
            }
        }
        return null;
    }
}
