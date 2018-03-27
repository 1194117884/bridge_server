package me.kkang.tools.bridge_server.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadWorkerPool {

    private static int corePoolSize = 3;
    private static int maximumPoolSize = 10;

    private static ExecutorService executorService;


    static {
        executorService = new ThreadPoolExecutor(
                corePoolSize, maximumPoolSize,
                6000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10000)
        );
    }

    public static void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}