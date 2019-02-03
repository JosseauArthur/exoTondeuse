/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse;

import com.kikijoli.exotondeuse.manager.UiManager;

/**
 *
 * @author Arthur JOSSEAU
 */
public class ExoTondeuse {

    /**
     * Hi, there are some errors in the specifications, especially concerning
     * the notion of "y" which starts at the bottom left while in java it starts
     * at the top left, so the north can not be y + 1 but y-1 . I made it
     * transparent for the user but the code becomes more complex. As well as
     * the expected result of the first mower which can not be 1 3 N. Indeed if
     * one is the course of the mower respecting the rule described in the
     * specification: "If the position after movement is outside the lawn , the
     * mower does not move, keeps its orientation and processes the following
     * command ", then the final position of the mower 1 will be 2 3 N. I made a
     * graphical interface for clarity, challenge but also for more fun! Good
     * reading :)
     */
    public static void main(String[] args) {
        UiManager.initialize();
    }

}
