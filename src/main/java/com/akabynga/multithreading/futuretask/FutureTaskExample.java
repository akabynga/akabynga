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
             * »дентификатор и наименование потока,
             * выполн€ющего данную callable задачу
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

        // —ервис исполнени€
        executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            callable[i] = new CallableDelay(1000, (i + 1));
            futureTask[i] = new FutureTask<>(callable[i]);
            executor.execute(futureTask[i]);
        }
        // ÷икл работы executor'а
        while (true) {
            try {
                if (areTasksDone()) {
                    // «авершение работы executor'а
                    executor.shutdown();
                    System.out.println("\nexecutor shutdown");
                    return;
                }
                // ѕроверка завершени€ выполнени€ задачи 1-м 
                // потоком
                if (futureTask[0].isDone()) {
                    System.out.println("1-ый поток завершен : " + futureTask[0].get());
                }

                System.out.println("ќжидание завершени€ 2-го потока");
                String txt = (String) futureTask[1].get(200L, TimeUnit.MILLISECONDS);
                if (txt != null) {
                    System.out.println("2-ой поток завершен : " + txt);
                }
                System.out.println("ѕроверка завершени€ 3-го потока");
                if (futureTask[2].isCancelled()) {
                    System.out.println("3-ой поток был прерван ...");
                } else if (futureTask[2].isDone()) {
                    txt = (String) futureTask[2].get();
                    System.out.println("3-ий поток завершен : " + txt);
                }
                Thread.sleep(200);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println(e.getMessage());
            } catch (TimeoutException e) {
                /*
                 *  2-ой поток вызывает TimeoutException,
                 *  если задача не завершена за указанное
                 * врем€
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