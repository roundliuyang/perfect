package com.yly.pipeline.pipeline.impl;


import com.yly.pipeline.pipeline.Pipeline;
import com.yly.pipeline.valve.Valve;

/**
 * 安装汽车责任链
 */
public class InstallCarPipeline implements Pipeline {
    /**
     * 第一个阀门
     */
    protected Valve first = null;
    /**
     * 最后一个阀门
     */
    protected Valve basic = null;


    @Override
    public void setBasic(Valve valve) {
        Valve oldBasic = this.basic;

        // Update the pipeline
        Valve current = first;
        while (current != null) {
            if (current.getNext() == oldBasic) {
                current.setNext(valve);
                break;
            }
            current = current.getNext();
        }

        this.basic = valve;
    }

    public Valve getFirst() {
        if (first != null) {
            return first;
        }

        return basic;
    }

    @Override
    public void addValve(Valve valve) {
        if (first == null) {
            first = valve;
            valve.setNext(basic);
        } else {
            Valve current = first;
            while (current != null) {
                if (current.getNext() == basic) {
                    current.setNext(valve);
                    valve.setNext(basic);
                    break;
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public void invoke(boolean isPass) {
        //获取第一个阀门
        Valve valve = getFirst();
        if (valve!=null) {
            valve.invoke(isPass);
            return;
        }
        throw new RuntimeException("责任链上没有链阀门");
    }

}
