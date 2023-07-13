package com.yly.pipeline.pipeline;


import com.yly.pipeline.valve.Valve;

public interface Pipeline {
    void setBasic(Valve basic);

    void addValve(Valve valve);

    /**
     * pipeline程序的启动方法
     * @param isPass
     */
    void invoke(boolean isPass);
}
