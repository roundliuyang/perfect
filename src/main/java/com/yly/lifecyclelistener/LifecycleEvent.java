package com.yly.lifecyclelistener;

/**
 * 事件基类
 */
public final class LifecycleEvent {

    private final Lifecycle lifecycle;
    private final Object data;
    private final String type;

    public LifecycleEvent(Lifecycle lifecycle, String type, Object data) {
        this.lifecycle = lifecycle;
        this.data = data;
        this.type = type;
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return type;
    }
}