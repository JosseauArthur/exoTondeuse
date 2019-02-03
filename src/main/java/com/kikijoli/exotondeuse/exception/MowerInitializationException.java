/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.exception;

import com.kikijoli.exotondeuse.util.Cardinality;

/**
 *
 * @author Arthur JOSSEAU
 */
public class MowerInitializationException extends Exception {

    public MowerInitializationException() {
        super("Mower command initialization is not valid : exemple : \"1 1 " + Cardinality.NORTH + "\"");
    }

}
