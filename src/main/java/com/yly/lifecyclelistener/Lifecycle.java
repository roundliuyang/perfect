package com.yly.lifecyclelistener;


/**
 * 在tomcat中容器组件都要经历一套生命周期
 * NEW(创建)-->INITIALIZED(初始化)-->.....-->DESTROYED(销毁)，而周期状态变更系统都要做相应的处理，这就可以使用监听器去监听这个动作，从而做出相应处理。
 * 重要组件：
 * 1.Lifecycle：生命周期的接口
 * 2.LifecycleBase：实现了Lifecycle接口，抽取通用方法与通用变量避免重复代码
 * 3.LifecycleListener：监听器，根据对应的事件做相应处理
 * 4.LifecycleEvent：事件，触发监听器工作的条件
 * 这里用一个简单例子来阐述：气象站，对下雨进行监测，当下雨时监听器报'开始下雨，记得带伞',停雨时监听器报'停雨了，happy'。
 */

/**
 * 生命周期接口
 */
public interface Lifecycle {
    public static final String START_EVENT = "start";
    public static final String STOP_EVENT = "stop";
    /**
     * 增加监听器
     * @param listener
     */
    void addLifecycleListener(LifecycleListener listener);
    /**
     * 生命周期开始
     */
    void start();
    /**
     * 生命周期结束
     */
    void stop();
}