/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.exotondeuse.business.logical;

import com.kikijoli.exotondeuse.business.drawable.Lawn;
import com.kikijoli.exotondeuse.business.drawable.Mower;
import com.kikijoli.exotondeuse.interfaces.IDrawable;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Arthur JOSSEAU
 */
public class Garden implements IDrawable {

    private int width, height;
    private ArrayList<Mower> mowers = new ArrayList<>();
    private Lawn[][] lawns;

    public Garden(int width, int height) {
        this.width = width;
        this.height = height;
        this.lawns = new Lawn[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.lawns[i][j] = new Lawn(i, j);
            }
        }
    }

    public Garden(int width, int height, ArrayList<Mower> mowers) {
        this(width, height);
        this.mowers = mowers;
    }

    @Override
    public void draw(Graphics2D g) {
        for (Lawn[] arrlawn : lawns) {
            for (Lawn la : arrlawn) {
                la.draw(g);
            }
        }
        mowers.stream().forEach((mower) -> {
            mower.draw(g);
        });
    }

    public void addMower(Mower mower) {
        mowers.add(mower);
    }

    public ArrayList<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(ArrayList<Mower> mowers) {
        this.mowers = mowers;
    }

    public Lawn[][] getLawns() {
        return lawns;
    }

    public void setLawns(Lawn[][] lawns) {
        this.lawns = lawns;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    

}
