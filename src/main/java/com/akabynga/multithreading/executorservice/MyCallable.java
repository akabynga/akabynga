package com.akabynga.multithreading.executorservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // ���������� ��� ������, ������� ��������� callable ����
        return Thread.currentThread().getName();
    }

    public static void main(String args[]) {
        //�������� ExecutorService ���������� ������ Executors � �������� g���� ������� ������� 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //������� ������ � Future, ������� ������������� � Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        // ������� ��������� MyCallable
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 100; i++) {
            //�������� Callable �����, ������� ����� 
            //��������� ����� �������
            Future<String> future = executor.submit(callable);
            //�������� Future � ������, 
            //�� ������ �������� ��������� ����������
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                // �������� � ������� ������������ �������� Future
                // ����� �������� � 1 �������, ������ ��� Future.get()
                // ���� ���� ���� �������� ����������
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

}