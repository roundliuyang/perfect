package com.yly.eventbus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorFactory {
    public static Executor getDirectExecutor() {
        return Runnable::run;
    }

    public static Executor getThreadPoolExecutor() {
        return Executors.newCachedThreadPool();
    }
}
