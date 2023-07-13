package com.yly.apollo.engine.engine;

import com.yly.apollo.engine.EngineInfo;
import com.yly.apollo.engine.HandlerManager;
import com.yly.apollo.engine.api.Handler;
import com.yly.apollo.engine.api.HandlerContext;
import com.yly.apollo.engine.buf.Buf;
import com.yly.apollo.engine.context.AbstractHandlerContext;
import com.yly.apollo.engine.context.DefaultHandlerContext;
import com.yly.apollo.engine.context.TailContext;
import com.yly.apollo.engine.handlers.TailHandler;

import java.util.Iterator;
import java.util.List;

public class EnginePipeline<I, O> extends AbstractHandlerContext<I> implements HandlerContext<I> {
    private HandlerContext[] handlerContexts;

    private final TailHandler tailHandler;

    private TailContext<O> tail;

    /**
     * 引擎管道中的缓冲区上下文
     */
    private Buf buf;

    public EnginePipeline(Handler<I> headHandler, TailHandler tailHandler) {
        this.handler = headHandler;
        this.tailHandler = tailHandler;
    }

    public EnginePipeline<I, O> init(List<EngineInfo> engineInfos) {
        this.setEngineInfo(new EngineInfo("HEAD"));
        this.fillHandlerContexts(engineInfos.size() + 2);
        this.setNext(this.handlerContexts[1]);
        int order = 1;
        Iterator var3 = engineInfos.iterator();
        while (var3.hasNext()) {
            EngineInfo engineInfo = (EngineInfo) var3.next();
            engineInfo.build();
            String name = engineInfo.getName();
            Handler handler = HandlerManager.getHandler(name);
            this.handlerContexts[order].setHandler(handler).setEngineInfo(engineInfo).setNext(this.handlerContexts[order++ + 1]);
        }
        return this;
    }

    private void fillHandlerContexts(int length) {
        this.handlerContexts = new HandlerContext[length];
        this.handlerContexts[0] = this;

        for (int i = 1; i < length - 1; ++i) {
            this.handlerContexts[i] = new DefaultHandlerContext(this);
        }

        this.tail = new TailContext(this, this.tailHandler);
        this.tail.setEngineInfo(new EngineInfo("TAIL"));
        this.handlerContexts[length - 1] = this.tail;
    }

    public void fireHandlers(I req) {
        this.setInnerParam(req);
        this.invokeHandler();
    }

    public TailContext<O> getLast() {
        return this.tail;
    }

    public EnginePipeline<?, ?> getEngine() {
        return this;
    }

    public Buf getBuf() {
        return this.buf;
    }

    public EnginePipeline<I, O> setBuf(Buf buf) {
        this.buf = buf;
        return this;
    }

}
