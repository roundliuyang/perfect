package com.yly.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InvokerHelper {

    /**
     * 获取指定类的所有方法，以 Invoker 对象的形式返回
     */
    public static List<Invoker> getInvokers(Object listener) {
        List<Invoker> invokers = new ArrayList<>();
        Class<?> clazz = listener.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 1 && method.isAnnotationPresent(Subscribe.class)) {
                Class<?> paramType = method.getParameterTypes()[0];
                if (Event.class.isAssignableFrom(paramType)) {
                    Subscribe subscribe = method.getAnnotation(Subscribe.class);
//                    invokers.add(new MethodInvoker(listener, method, (Class<? extends Event>) paramType));    // 可能会发生运行时错误
                    invokers.add(new MethodInvoker(listener, method, paramType.asSubclass(Event.class)));       // 在运行时进行类型检查
                }
            }
        }
        return invokers;
    }
}