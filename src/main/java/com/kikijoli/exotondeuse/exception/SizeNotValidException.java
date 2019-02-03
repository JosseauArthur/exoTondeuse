/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.exception;

/**
 *
 * @author Arthur JOSSEAU
 */
public class SizeNotValidException extends Exception {

    public SizeNotValidException() {
        super("size is not valid :  ex \"5 5\"");
    }

}
