package com.xogame.view;

import com.xogame.controller.GameController;
import com.xogame.model.Field;
import com.xogame.model.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends JFrame {

    JPanel jPanel = new JPanel();
    static public ArrayList<JButton> buttons = new ArrayList<>(9);

    public void init() {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("XO GAME");
        setLocationRelativeTo(null);
        setResizable(false);
        jPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton jButton = new JButton();
                buttons.add(jButton);
                jPanel.add(jButton);
                int finalI = i;
                int finalJ = j;
                jButton.addActionListener(e -> {
                    String buttonText = e.getActionCommand();
                    GameController.doShoot(new Point(finalI, finalJ));
                });
            }
        }
        add(jPanel);
        setVisible(true);
    }

    public void closeWindow(){
        setVisible(false);
        dispose();
    }
    static public void showPanel() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Field.cells[i][j] == Field.Type.X) {
                    buttons.get(i * 3 + j).setText("X");
                }
                if (Field.cells[i][j] == Field.Type.O) {
                    buttons.get(i * 3 + j).setText("O");
                }
            }

        }
    }
}