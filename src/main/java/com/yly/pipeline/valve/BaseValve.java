package com.yly.pipeline.valve;



/**
 * 因为会有很多管道，我们将一些通用的变量方法放入 基础阀门 中
 */
public abstract class BaseValve implements Valve {

    /**
     * 下一个阀门
     */
    protected Valve next = null;

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }

    @Override
    public Valve getNext() {
        return next;
    }
}