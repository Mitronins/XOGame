package com.xogame.model;


public class Computer implements Shootable {
    @Override
    public Point getShoot() {
        return Point.getRandomPoint();
    }
}
