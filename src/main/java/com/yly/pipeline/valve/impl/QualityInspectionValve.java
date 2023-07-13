package com.yly.pipeline.valve.impl;

import com.yly.pipeline.valve.BaseValve;

/**
 * 质检阀门，为最后一个阀门（basic）
 */
public class QualityInspectionValve extends BaseValve {
    @Override
    public void invoke(boolean isPass) {
        System.out.println("\t\n质检合格通过\t\n");
    }
}