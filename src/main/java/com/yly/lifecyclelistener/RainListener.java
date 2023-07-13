package com.yly.lifecyclelistener;

/**
 * 监听器具体实现
 */
public class RainListener implements LifecycleListener {
    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if (Lifecycle.START_EVENT.equals(event.getType())) {
            System.out.println("开始下雨，记得带伞");
        } else if (Lifecycle.STOP_EVENT.equals(event.getType())) {
            System.out.println("停雨了，happy去");
        }
    }
}