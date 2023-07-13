package com.yly.pipeline.valve.impl;

import com.yly.pipeline.valve.BaseValve;

/**
 * 安装窗子阀门
 */
public class InstallWindowsValve extends BaseValve {
    @Override
    public void invoke(boolean isPass) {
        System.out.println("窗子安装完成");
        this.next.invoke(true);
        System.out.println("窗子安装交付");
    }
}