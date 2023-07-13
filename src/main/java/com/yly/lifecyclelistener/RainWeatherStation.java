package com.yly.lifecyclelistener;

/**
 * 气象站对象，实现LifecycleBase拥有了生命周期
 */
public class RainWeatherStation extends LifecycleBase {

    @Override
    public void start() {
        //监听到下雨了
        super.fireLifecycleEvent(Lifecycle.START_EVENT,null);
    }

    @Override
    public void stop() {
        //监听到停雨了
        super.fireLifecycleEvent(Lifecycle.STOP_EVENT,null);
    }
}