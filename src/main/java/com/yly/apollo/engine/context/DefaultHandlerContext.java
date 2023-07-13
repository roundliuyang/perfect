package com.yly.apollo.engine.context;


import com.yly.apollo.engine.buf.Buf;
import com.yly.apollo.engine.engine.EnginePipeline;

public class DefaultHandlerContext<I> extends AbstractHandlerContext<I> {
    /**
     * 在下正是传说中的管道
     */
    private EnginePipeline<?, ?> engine;

    public DefaultHandlerContext(EnginePipeline<?, ?> engine) {
        this.engine = engine;
    }

    public EnginePipeline<?, ?> getEngine() {
        return this.engine;
    }
    public Buf getBuf() {
        return this.engine.getBuf();
    }
}