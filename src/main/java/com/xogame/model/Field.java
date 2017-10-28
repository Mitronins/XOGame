package com.xogame.model;


public class Field {
    public enum Type {X, O, NOT_SET}
    public static boolean checkDraw = true;
    public static Type[][] cells;
    public static String message;

    public Field() {
        cells = new Type[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = Type.NOT_SET;
            }
        }
    }//заполнение поля


    public boolean doShoot(Point point, Type type) {
        //todo проверка
        if (cells[point.x][point.y] == Type.X) return true;
        if (cells[point.x][point.y] == Type.O) return true;
        if (cells[point.x][point.y] == Type.NOT_SET) {
            cells[point.x][point.y] = type;

        }
        return false;

    }


    public boolean checkWin(Type type) {
        boolean isWin = false;

        if (cells[0][0] == type && cells[1][1] == type && cells[2][2] == type) {
            isWin = true;
            checkDraw = false;
            message = "Победа " + type;
            return isWin;
        }
        if (cells[0][2] == type && cells[1][1] == type && cells[2][0] == type) {
            isWin = true;
            checkDraw = false;
            message = "Победа " + type;
            return isWin;
        }

        for (int i = 0; i < 3; i++) {
            {
                if (cells[i][0] == type && cells[i][1] == type && cells[i][2] == type) {
                    isWin = true;
                    checkDraw = false;
                    message = "Победа " + type;
                    return isWin;
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            {
                if (cells[0][j] == type && cells[1][j] == type && cells[2][j] == type) {
                    isWin = true;
                    checkDraw = false;
                    message = "Победа " + type;
                    return isWin;
                }
            }

        }


        return isWin;
    }


}
