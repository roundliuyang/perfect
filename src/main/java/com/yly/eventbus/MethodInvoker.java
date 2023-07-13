package com.yly.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoker implements Invoker {

    private final Object target;
    private final Method method;
    private final Class<? extends Event> eventType;

    public MethodInvoker(Object target, Method method, Class<? extends Event> eventType) {
        this.target = target;
        this.method = method;
        this.eventType = eventType;
        this.method.setAccessible(true);
    }

    @Override
    public boolean canHandle(Event event) {
        return eventType.isInstance(event);
    }

    @Override
    public void invoke(Event event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to invoke method: " + method, e);
        }
    }

    @Override
    public String toString() {
        return "MethodInvoker{" +
                "target=" + target +
                ", method=" + method +
                ", eventType=" + eventType +
                '}';
    }
}