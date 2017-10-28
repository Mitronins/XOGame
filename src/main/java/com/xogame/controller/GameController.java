package com.xogame.controller;

import com.xogame.model.Point;
import com.xogame.model.User;

public class GameController {
    public static void doShoot(Point point) {
        User.point = point;
        User.isShoot = true;
    }
}
