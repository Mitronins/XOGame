package com.xogame.view;

import com.xogame.model.Field;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;



public class WinWindow extends JFrame implements Runnable {
    public volatile static boolean goGame = true;
    public volatile static boolean isButton = false;


    @Override
    public void run() {
        setSize(290, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(Field.message);
        setLocationRelativeTo(null);
        setResizable(false);


        JButton jButton1 = new JButton("ДА");
        jButton1.addActionListener(e -> {
            String buttonText = e.getActionCommand();
            Field.cells = new Field.Type[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Field.cells[i][j] = Field.Type.NOT_SET;
                }
            }
            for (Iterator<JButton> iterator = GameWindow.buttons.iterator(); iterator.hasNext(); ) {
                JButton jButton = iterator.next();
                iterator.remove();
            }

            Field.checkDraw = true;
            isButton = true;
            goGame = true;

            setVisible(false);
            dispose();
        });


        JButton jButton2 = new JButton("НЕТ");
        jButton2.addActionListener(e -> System.exit(-1));

        add(jButton1, BorderLayout.WEST);
        add(jButton2, BorderLayout.EAST);
        JLabel jLabel = new JLabel("<html>Игра окончена. Вы хотите сыграть еще раз?</html>");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel jLabe2 = new JLabel(Field.message);
        jLabe2.setHorizontalAlignment(SwingConstants.CENTER);
        add(jLabel);
        add(jLabe2, BorderLayout.PAGE_START);


        setVisible(true);

    }
}
