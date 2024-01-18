package com.akabynga.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

class SwingDemo {

    public static void main(String args[]) {

        Random random = new Random();
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1200);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                DrawRectangle dr = new DrawRectangle(e.getX() - 10, e.getY() - 10, 20, 20);
                dr.setColor(new Color(random.nextInt()));
                dr.setBackground(new Color(random.nextInt()));
                dr.paintComponent(frame.getGraphics());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
//        JButton button = new JButton("Press");
//        button.setSize(100, 100);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switch (e.getActionCommand()) {
//                    case "Press":
//                        System.out.println("Hello Lera!");
//                        break;
//                    default:
//                        System.out.println(e.getActionCommand());
//                }
//            }
//        });
//        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}