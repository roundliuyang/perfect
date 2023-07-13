package com.yly.pipeline.valve.impl;

import com.yly.pipeline.valve.BaseValve;

/**
 * 喷漆阀门
 */
public class SprayPaintValve extends BaseValve {
    @Override
    public void invoke(boolean isPass) {
        System.out.println("喷漆完成");
        this.next.invoke(true);
        System.out.println("喷漆交付");
    }
}