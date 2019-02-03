/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.exception;

import com.kikijoli.exotondeuse.util.Direction;

/**
 *
 * @author Arthur JOSSEAU
 */
public class MowerCommandException extends Exception {

    public MowerCommandException() {
        super("Mower command is not valid : only \"" + Direction.LEFT + "\"  or \"" + Direction.RIGHT + "\" or \"" + Direction.FORWARD + "\" are allowed");
    }

}
