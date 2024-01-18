package com.akabynga.multithreading.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CancelDemo {

    private static volatile boolean isWorking = false;

    public static void main(String[] args) {
        Random random = new Random();
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        Button startButton = new Button("Start");
        startButton.setBounds(0, 0, 100, 50);

        Button cancelButton = new Button("Cancel");
        cancelButton.setBounds(0, 50, 100, 50);

        JLabel aLabel = new JLabel("Something to look at", new ImageIcon("images/beach.gif"), JLabel.CENTER);
        aLabel.setVerticalTextPosition(JLabel.TOP);
        aLabel.setHorizontalTextPosition(JLabel.CENTER);

        final Future<?>[] runningTask = {null};
        ExecutorService backgroundExec = Executors.newCachedThreadPool();

        startButton.addActionListener(e -> {
            if (runningTask[0] == null) {
                startWork();
                runningTask[0] = backgroundExec.submit(() -> {
                    while (moreWork()) {
                        if (Thread.currentThread().isInterrupted()) {
                            cleanUpPartialWork();
                            break;
                        }
                        for (int i = 0; i < 1000; i++) {
                            System.out.println("Test: " + i);
                            onProgress(i, 1000);
                            aLabel.setText("Something to look at: " + ((double) i) / (1000 / 100) + "%");
                            try {
                                Thread.currentThread().sleep(1);
                            } catch (InterruptedException e1) {
                                throw new RuntimeException(e1);
                            }
                        }
                        aLabel.setText("Something to look at: 100%");

                        stopWork();
                        runningTask[0].cancel(true);
                        runningTask[0] = null;
                        startButton.setEnabled(true);
                        cancelButton.setEnabled(false);
                    }
                });
                startButton.setEnabled(false);
                cancelButton.setEnabled(true);
            }
        });
        cancelButton.addActionListener(event -> {
            if (runningTask[0] != null) {
                runningTask[0].cancel(true);
                runningTask[0] = null;
                startButton.setEnabled(true);
                cancelButton.setEnabled(false);
            }
        });

        frame.getContentPane().add(startButton); // Adds Button to content pane of frame
        frame.getContentPane().add(cancelButton); // Adds Button to content pane of frame
        frame.getContentPane().add(aLabel);
        frame.setVisible(true);

    }

    private static void cleanUpPartialWork() {
        System.out.println("cleanup");
    }

    protected static void onProgress(int c, int m) {
    }

    private static void startWork() {
        isWorking = true;
    }

    private static void stopWork() {
        isWorking = false;
    }

    private static boolean moreWork() {
        return isWorking;
    }
}
