package com.yly.lifecyclelistener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 生命周期基类
 */
public abstract class LifecycleBase implements Lifecycle {

    private final List<LifecycleListener> lifecycleListeners = new CopyOnWriteArrayList<>();

    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        lifecycleListeners.add(listener);
    }

    /**
     * 触发生命周期事件
     * @param type
     * @param data
     */
    protected void fireLifecycleEvent(String type, Object data) {
        LifecycleEvent event = new LifecycleEvent(this, type, data);
        for (LifecycleListener listener : lifecycleListeners) {
            listener.lifecycleEvent(event);
        }
    }
}