package com.xogame.model;

import com.xogame.view.GameWindow;

public class MainGame {
    public static Field field = new Field();
    public static Computer computer = new Computer();
    public static User user = new User();

    public static void start() {
        GameWindow.showPanel();
        for (int i = 0; i < 5; i++) {
            while (field.doShoot(user.getShoot(), Field.Type.X)) ;

            GameWindow.showPanel();
            if (field.checkWin(Field.Type.X)) break;
            if (i == 4) break;

            while (field.doShoot(computer.getShoot(), Field.Type.O)) ;
            GameWindow.showPanel();
            if (field.checkWin(Field.Type.O)) break;
        }
        if (Field.checkDraw) Field.message = "Ничья";

    }

    public static void startPlayer() {
        GameWindow.showPanel();
        for (int i = 0; i < 5; i++) {
            while (field.doShoot(user.getShoot(), Field.Type.X)) ;

            GameWindow.showPanel();
            if (field.checkWin(Field.Type.X)) break;
            if (i == 4) break;

            while (field.doShoot(user.getShoot(), Field.Type.O)) ;

            GameWindow.showPanel();
            if (field.checkWin(Field.Type.O)) break;

        }
        if (Field.checkDraw) Field.message = "Ничья";
    }

}