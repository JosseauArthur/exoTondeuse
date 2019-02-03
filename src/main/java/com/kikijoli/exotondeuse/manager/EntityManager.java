/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.manager;

import com.kikijoli.exotondeuse.business.logical.Garden;
import com.kikijoli.exotondeuse.business.drawable.Mower;
import com.kikijoli.exotondeuse.exception.MowerCommandException;
import com.kikijoli.exotondeuse.exception.MowerInitializationException;
import com.kikijoli.exotondeuse.exception.SizeNotValidException;
import static com.kikijoli.exotondeuse.manager.CommandManager.MOWER_COMMAND_ALLOWED;
import com.kikijoli.exotondeuse.util.Direction;
import com.kikijoli.exotondeuse.util.Orientation;
import com.kikijoli.exotondeuse.util.Transform;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Arthur JOSSEAU
 */
public class EntityManager {

    private static Garden currentGarden;

    public static Garden getGarden() {
        if (currentGarden == null) {
            currentGarden = new Garden(0, 0, new ArrayList<>());
        }
        return currentGarden;
    }

    public static void setGarden(Garden garden) {
        currentGarden = garden;
    }

    public static void addMower(Mower mower) {
        currentGarden.addMower(mower);
    }

    private static void checkMowerCommand(String behavior) throws MowerCommandException {
        for (int j = 0; j < behavior.length(); j++) {
            if (!MOWER_COMMAND_ALLOWED.contains(Character.toString(behavior.charAt(j)).toUpperCase())) {
                throw new MowerCommandException();
            }
        }
    }

    public static Point checkSize(String size) throws SizeNotValidException {
        int width = 0;
        int height = 0;

        String[] sizes = size.trim().split(" ");
        if (sizes.length != 2) {
            throw new SizeNotValidException();
        }
        try {
            //Integer value needed
            width = Integer.parseInt(sizes[0]);
            height = Integer.parseInt(sizes[1]);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            throw new SizeNotValidException();
        }
        return new Point(width, height);
    }

    public static ArrayList<Mower> addMowers(String[] splitCommandLine) throws MowerInitializationException, MowerCommandException {
        //remove size command from array   
        ArrayList<Mower> mowers = new ArrayList<>();
        String[] mowersCommand = Arrays.copyOfRange(splitCommandLine, 1, splitCommandLine.length);
        for (int i = 0; i < mowersCommand.length; i += 2) {
            Mower m = createMower(mowersCommand, i);
            if (m != null) {
                mowers.add(m);
            }
        }
        return mowers;
    }

    public static Mower createMower(String[] mowersCommand, int i) throws MowerInitializationException, MowerCommandException {

        int x, y;
        String orientation;
        String behavior; //for mower bot 
        //need couple of line
        if (i > mowersCommand.length - 2) {
            //not throw exception , errors are tolerated here. (personal choice)
            System.err.println("Mower cannot be create, arguments missing");
            return null;
        }
        String[] mowerInit = mowersCommand[i].trim().split(" ");
        if (mowerInit.length != 3) {
            throw new MowerInitializationException();
        }
        try {
            x = Integer.parseInt(mowerInit[0]);
            y = Integer.parseInt(mowerInit[1]);
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            throw new MowerInitializationException();
        }
        orientation = mowerInit[2];
        behavior = mowersCommand[i + 1].trim();
        checkMowerCommand(behavior);
        //After validation, add one; for the bot to have a behavior that signals the end
        behavior += Direction.END;
        return new Mower(x, y, Orientation.parseOrientation(orientation), behavior);
    }

    public static void mowerMove(Mower mower) {
        // move in garden lawn [][] with indexes
        int x = mower.x + (mower.getOrientation() == Orientation.EAST ? 1 : mower.getOrientation() == Orientation.WEST ? (-1) : 0);
        int y = mower.y + (mower.getOrientation() == Orientation.SOUTH ? -1 : mower.getOrientation() == Orientation.NORTH ? (1) : 0);
        try {
            //put x and y to mower, if ArrayOutOfBoundException, do nothiong and print it
            mower.setLocation(getGarden().getLawns()[x][y].getLocation());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid mower movement, cannot move to : " + (x + 1) + " : " + (y + 1));
        }
    }

    public static void changeMowerOrientation(Mower mower, String target) {
        int currentOrientation = mower.getOrientation();
        switch (target.toUpperCase()) {
            case Direction.LEFT:
                currentOrientation = currentOrientation + 1 > Orientation.EAST ? Orientation.NORTH : currentOrientation + 1;
                break;
            case Direction.RIGHT:
                currentOrientation = currentOrientation - 1 < Orientation.NORTH ? Orientation.EAST : currentOrientation - 1;
                break;
        }
        mower.setOrientation(currentOrientation);
    }

    public static void mowerFinish(Mower mower) {
        System.out.println("mower location : " + (mower.x + 1) + " " + (mower.y + 1) + " " + Orientation.getOrientationString(mower.getOrientation()));
    }
}
