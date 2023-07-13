package com.yly.lifecyclelistener;

/**
 * 监听器接口
 */
public interface LifecycleListener {
    /**
     * 监听器执行方法
     * @param event
     */
    void lifecycleEvent(LifecycleEvent event);
}