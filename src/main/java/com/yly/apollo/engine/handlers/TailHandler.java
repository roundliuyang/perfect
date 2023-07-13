package com.yly.apollo.engine.handlers;

import com.yly.apollo.engine.api.HandlerContext;

public abstract class TailHandler extends AbstractHandler {
    public TailHandler() {
    }

    public <I> void handle(HandlerContext<I> hc) {
        System.out.println("我是tail");
    }

    /**
     * tailHandler 提供一个空实现即可
     */
    public <I> void genInnerParam(HandlerContext<I> hc) {
    }

}
