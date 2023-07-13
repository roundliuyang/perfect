package com.yly.eventbus;

public interface Invoker {

    // 是否能处理该事件
    boolean canHandle(Event event);

    // 处理事件
    void invoke(Event event);
}
