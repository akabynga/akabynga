package com.akabynga.multithreading.executors;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> {
                try {
                    handleRequest(connection);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };
            exec.execute(task);
        }
    }

    public static void handleRequest(Socket socket) throws IOException {
        socket.close();
    }
}