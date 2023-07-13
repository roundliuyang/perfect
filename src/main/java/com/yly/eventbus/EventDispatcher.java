package com.yly.eventbus;

import java.util.Set;
import java.util.concurrent.Executor;

public class EventDispatcher {
    private final Executor executor;

    public EventDispatcher(Executor executor) {
        this.executor = executor;
    }

    public void dispatch(Event event, Set<Invoker> invokers) {
        for (Invoker invoker : invokers) {
            executor.execute(() -> invoker.invoke(event));
        }
    }
}
