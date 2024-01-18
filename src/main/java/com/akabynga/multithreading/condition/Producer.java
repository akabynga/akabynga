package com.akabynga.multithreading.condition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Producer extends Thread {
    private final static String FILENAME = "input.txt";
    private final SharedFiFoQueue queue;

    public Producer(SharedFiFoQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try (BufferedReader rd = new BufferedReader(new FileReader(FILENAME))) {
            String inputLine = null;
            while ((inputLine = rd.readLine()) != null) {
                String[] inputWords = inputLine.split(" ");

                for (String inputWord : inputWords) {
                    System.out.println("[Producer] Write the element: " + inputWord);
                    queue.add(inputWord);
                }
            }

            System.out.println("[Producer] Termination");
            //Terminate the execution.
            queue.add(null);
        } catch (InterruptedException ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("An IOException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}