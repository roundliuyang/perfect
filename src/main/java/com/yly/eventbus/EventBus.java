package com.yly.eventbus;

import lombok.Getter;

import java.util.Set;

public class EventBus {
    // 注册器
    @Getter
    private final EventRegistry invokerRegistry = new EventRegistry(this);

    // 事件分发器
    private final EventDispatcher dispatcher = new EventDispatcher(ExecutorFactory.getDirectExecutor());

    // 异步事件分发器
    private final EventDispatcher asyncDispatcher = new EventDispatcher(ExecutorFactory.getThreadPoolExecutor());

    // 事件分发
    public boolean dispatch(Event event) {
        return dispatch(event, dispatcher);
    }

    // 异步事件分发
    public boolean dispatchAsync(Event event) {
        return dispatch(event, asyncDispatcher);
    }

    // 内部事件分发
    private boolean dispatch(Event event, EventDispatcher dispatcher) {
        checkEvent(event);
        // 1.获取事件数组
        Set<Invoker> invokers = invokerRegistry.getInvokers(event);
        // 2.一个事件可以被监听N次，不关心调用结果
        dispatcher.dispatch(event, invokers);
        return true;
    }

    // 事件总线注册
    public void register(Object listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener can not be null!");
        }
        invokerRegistry.register(listener);
    }

    private void checkEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("event");
        }
        if (!(event instanceof Event)) {
            throw new IllegalArgumentException("Event type must by " + Event.class);
        }
    }
}
