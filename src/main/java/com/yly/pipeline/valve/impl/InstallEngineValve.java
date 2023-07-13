package com.yly.pipeline.valve.impl;

import com.yly.pipeline.valve.BaseValve;

/**
 * 安装引擎阀门
 */
public class InstallEngineValve extends BaseValve {

    @Override
    public void invoke(boolean isPass) {
        System.out.println("引擎安装完成");
        this.next.invoke(true);
        System.out.println("引擎安装交付");
    }
}




