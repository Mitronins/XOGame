package com.xogame;

import com.xogame.model.MainGame;
import com.xogame.view.AskWindow;
import com.xogame.view.GameWindow;
import com.xogame.view.WinWindow;

public class Main {

    public static void main(String[] args) {
        AskWindow askWindow = new AskWindow();
        Thread askThread = new Thread(askWindow);
        askThread.start();

        while (!AskWindow.isButton);

        if (AskWindow.check == AskWindow.Type.Comp) {
            gameStartWithComputer();
        }
        if (AskWindow.check == AskWindow.Type.Player) {
            gameStartWithPlayer();
        }

    }
    public static void gameStartWithComputer(){
        while (WinWindow.goGame) {
            WinWindow.isButton = false; //нажата ли кнопка в WinWindow(любая)
            GameWindow gameWindow = new GameWindow(); 
            gameWindow.init(); //Прорисовка игрового окна
            MainGame.start(); //Начало игры
            WinWindow winWindow = new WinWindow();
            Thread newThread = new Thread(winWindow);
            newThread.start();
            while (!WinWindow.isButton) ;
            gameWindow.closeWindow();
        }
    }
    public static void gameStartWithPlayer(){
        while (WinWindow.goGame) {
            WinWindow.isButton = false; //нажата ли кнопка в WinWindow(любая)
            GameWindow gameWindow = new GameWindow(); 
            gameWindow.init(); //Прорисовка игрового окна
            MainGame.startPlayer(); //Начало игры
            WinWindow winWindow = new WinWindow();
            Thread newThread = new Thread(winWindow);
            newThread.start();
            while (!WinWindow.isButton) ;
            gameWindow.closeWindow();
        }
    }

}
