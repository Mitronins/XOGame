package com.xogame.model;

public class User implements Shootable {
    public static Point point;
    public volatile static boolean isShoot;

    @Override
    public Point getShoot() {
        isShoot = false;
        while (!isShoot) ;
        return point;
    }
}
