package com.yly.pipeline.valve;

public interface Valve {
    /**
     * 阀门内的执行的方法
     * @param isPass
     */
    void invoke(boolean isPass);

    void setNext(Valve valve);

    Valve getNext();
}
