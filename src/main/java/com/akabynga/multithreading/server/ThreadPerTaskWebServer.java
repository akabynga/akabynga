package com.akabynga.multithreading.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadPerTaskWebServer {

    private static void handleRequest(Socket connection) throws IOException {
        System.out.println(connection);
        connection.close();
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(80)) {
            while (true) {
                final Socket connection = socket.accept();
                System.out.println(connection);
                Runnable task = () -> {
                    try {
                        handleRequest(connection);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
                new Thread(task).start();
            }
        }
    }
}