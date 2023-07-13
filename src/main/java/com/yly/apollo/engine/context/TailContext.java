package com.yly.apollo.engine.context;

import com.yly.apollo.engine.api.HandlerContext;
import com.yly.apollo.engine.buf.Buf;
import com.yly.apollo.engine.engine.EnginePipeline;
import com.yly.apollo.engine.handlers.TailHandler;

public class TailContext extends DefaultHandlerContext<Buf> implements HandlerContext<Buf> {
    public TailContext(EnginePipeline<?, ?> engine, TailHandler handler) {
        super(engine);
        this.handler = handler;
    }
//    private O outParam;

    public void invokeHandler() {
        this.invokeCurrentHandler();
    }
}
