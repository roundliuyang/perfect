package com.yly.apollo.engine.handlers;

import com.yly.apollo.engine.api.HandlerContext;
import com.yly.apollo.engine.buf.Buf;

public abstract class TailHandler extends AbstractHandler<Buf> {
    public TailHandler() {
    }

    public void handle(HandlerContext<Buf> hc) {
        System.out.println("我是tail");
    }

    /**
     * tailHandler 提供一个空实现即可
     * @param hc
     */
    public void genInnerParam(HandlerContext hc) {
    }

}
