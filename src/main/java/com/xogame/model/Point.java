package com.xogame.model;

import java.util.Random;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }



    public Point() {

    }

    static public Point getRandomPoint() {
        return new Point(new Random().nextInt(3), new Random().nextInt(3));

    }
}
