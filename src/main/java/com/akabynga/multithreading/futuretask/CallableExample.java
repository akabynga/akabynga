package com.akabynga.multithreading.futuretask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public CallableExample() {
        // ���������� ��� �� ���� �������
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // ������ ��������������� � Callable ����� Future
        List<Future<String>> futures = new ArrayList<>();

        // �������� ���������� Callable ������
        Callable<String> callable = new CallableClass();

        for (int i = 0; i < 3; i++) {
            /*
             * �������� ������������ ��������� ����������
             * � ���� ������� Future �����
             */
            Future<String> future = executor.submit(callable);
            /*
             * ��������� ������ Future � ������ ���
             * ����������� ��������� ���������� (���������
             * ������������ ������)
             */
            futures.add(future);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");
        for (Future<String> future : futures) {
            try {
                // ������� � ������� ���������� ��������
                String text = sdf.format(new Date()) + future.get();
                System.out.println(text);
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        // ������������� ��� �������
        executor.shutdown();
    }

    //-----------------------------------------------------
    // �����, ����������� ��������� Callable
    static class CallableClass implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            // ������������ ������, ������������ 
            // callable ������
            return Thread.currentThread().getName();
        }
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        new CallableExample();
    }
}