package com.xogame.view;

import javax.swing.*;
import java.awt.*;


public class AskWindow extends JFrame implements Runnable {
    public volatile static boolean isButton = false;

    public enum Type {Comp, Player}

    ;
    public static Type check = null;

    @Override
    public void run() {
        setSize(400, 120);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("XO GAME");
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel jPanel = new JPanel();

        JButton jButton1 = new JButton("Играть с компьютером");
        JButton jButton2 = new JButton("ВЫЙТИ ИЗ ПРИЛОЖЕНИЯ");
        JButton jButton3 = new JButton("Играть PvP");


        add(jButton1, BorderLayout.NORTH);
        add(jButton2, BorderLayout.SOUTH);
        add(jButton3, BorderLayout.CENTER);

        jButton1.addActionListener(e -> {
            check = Type.Comp;
            isButton = true;
            setVisible(false);
            dispose();
        });
        jButton2.addActionListener(e -> {
            System.exit(-1);

        });
        jButton3.addActionListener(e -> {
            check = Type.Player;
            isButton = true;
            setVisible(false);
            dispose();
        });


        setVisible(true);
    }


}
