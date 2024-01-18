package com.akabynga.multithreading.futuretask;

import java.util.concurrent.*;

public class FutureTaskExample {
    CallableDelay[] callable = null;
    FutureTask[] futureTask = null;
    ExecutorService executor = null;
    private final int THREAD_COUNT = 3;

    //-----------------------------------------------------
    class CallableDelay implements Callable<String> {
        private final long delay;
        private final int idx;
        private int cycle;

        public CallableDelay(int delay, int idx) {
            this.delay = delay;
            this.idx = idx;
            this.cycle = idx;
        }

        @Override
        public String call() throws Exception {
            while (cycle > 0) {
                Thread.sleep(delay);
                cycle--;
                if ((idx == 2) && (cycle > 0)) {
                    futureTask[futureTask.length - 1].cancel(true);
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished");
            /*
             * ������������� � ������������ ������,
             * ������������ ������ callable ������
             */
            return "" + idx + ". " + Thread.currentThread().getName();
        }
    }

    //-----------------------------------------------------
    private boolean areTasksDone() {
        boolean isDone = true;
        for (int i = 0; i < THREAD_COUNT; i++) {
            if (!futureTask[i].isDone()) {
                isDone = false;
                break;
            }
        }
        return isDone;
    }

    //-----------------------------------------------------
    FutureTaskExample() {
        callable = new CallableDelay[THREAD_COUNT];
        futureTask = new FutureTask[THREAD_COUNT];

        // ������ ����������
        executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            callable[i] = new CallableDelay(1000, (i + 1));
            futureTask[i] = new FutureTask<>(callable[i]);
            executor.execute(futureTask[i]);
        }
        // ���� ������ executor'�
        while (true) {
            try {
                if (areTasksDone()) {
                    // ���������� ������ executor'�
                    executor.shutdown();
                    System.out.println("\nexecutor shutdown");
                    return;
                }
                // �������� ���������� ���������� ������ 1-� 
                // �������
                if (futureTask[0].isDone()) {
                    System.out.println("1-�� ����� �������� : " + futureTask[0].get());
                }

                System.out.println("�������� ���������� 2-�� ������");
                String txt = (String) futureTask[1].get(200L, TimeUnit.MILLISECONDS);
                if (txt != null) {
                    System.out.println("2-�� ����� �������� : " + txt);
                }
                System.out.println("�������� ���������� 3-�� ������");
                if (futureTask[2].isCancelled()) {
                    System.out.println("3-�� ����� ��� ������� ...");
                } else if (futureTask[2].isDone()) {
                    txt = (String) futureTask[2].get();
                    System.out.println("3-�� ����� �������� : " + txt);
                }
                Thread.sleep(200);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e.getMessage());
            } catch (TimeoutException e) {
                /*
                 *  2-�� ����� �������� TimeoutException,
                 *  ���� ������ �� ��������� �� ���������
                 * �����
                 */
                System.err.println("TimeoutException");
            }
        }
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        new FutureTaskExample();
    }
}