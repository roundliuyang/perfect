package com.yly.eventbus;

import java.util.HashSet;
import java.util.Set;

public class EventRegistry {
    // 注册表
    private final Set<Invoker> invokers = new HashSet<>();

    // 事件总线
    private final EventBus eventBus;

    public EventRegistry(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    // 注册监听器
    public void register(Object listener) {
        invokers.addAll(InvokerHelper.getInvokers(listener));
    }

    // 获取注册的事件列表
    public Set<Invoker> getInvokers(Event event) {
        Set<Invoker> eventInvokers = new HashSet<>();
        for (Invoker invoker : invokers) {
//            if (invoker.canHandle(event)) {
                eventInvokers.add(invoker);
//            }
        }
        return eventInvokers;
    }
}
