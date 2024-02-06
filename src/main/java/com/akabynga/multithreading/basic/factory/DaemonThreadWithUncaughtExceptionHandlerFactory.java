package com.akabynga.multithreading.basic.factory;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadWithUncaughtExceptionHandlerFactory implements ThreadFactory {

    private static final String MESSAGE_EXCEPTION = "Exceptions was thrown with message '%s' in thread '%s'.\n";

    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public DaemonThreadWithUncaughtExceptionHandlerFactory() {
        this.uncaughtExceptionHandler = (thread, exception) ->
                System.out.printf(MESSAGE_EXCEPTION, exception.getMessage(), thread.getName());
    }

    public DaemonThreadWithUncaughtExceptionHandlerFactory(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
    }


    @Override
    public Thread newThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        return thread;
    }
}
