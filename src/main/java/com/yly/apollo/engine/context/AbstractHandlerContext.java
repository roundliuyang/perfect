package com.yly.apollo.engine.context;


import com.yly.apollo.core.enums.HandleResult;
import com.yly.apollo.core.enums.Instruction;
import com.yly.apollo.engine.EngineInfo;
import com.yly.apollo.engine.api.Handler;
import com.yly.apollo.engine.api.HandlerContext;
import com.yly.apollo.engine.buf.Buf;
import com.yly.apollo.engine.engine.EnginePipeline;

/**
 * 抽象类，
 *
 * @param <I>
 */
public abstract class AbstractHandlerContext<I> implements HandlerContext<I> {
    protected EngineInfo engineInfo;
    protected volatile HandlerContext<?> next;
    protected Handler<I> handler;
    protected I innerParam;
    protected HandleResult handleResult;
    protected Boolean isNext;
    protected Integer order;


    public AbstractHandlerContext() {
        this.handleResult = HandleResult.SUCESS;
        this.isNext = Boolean.TRUE;
    }

    public HandlerContext<?> setNext(HandlerContext<?> nextHandlerContext) {
        this.next = nextHandlerContext;
        return this.next;
    }

    public HandlerContext<?> getNext() {
        return this.next;
    }

    public I getInnerParam() {
        return this.innerParam;
    }

    public void setInnerParam(I innerParam) {
        this.innerParam = innerParam;
    }

    public EngineInfo getEngineInfo() {
        return this.engineInfo;
    }

    public HandlerContext<I> setEngineInfo(EngineInfo engineInfo) {
        this.engineInfo = engineInfo;
        return this;
    }

    public Handler<I> getHandler() {
        return handler;
    }

    public HandlerContext<I> setHandler(Handler<I> handler) {
        this.handler = handler;
        return this;
    }

    public void invokeHandler() {
        if (this.invokeCurrentHandler() == Instruction.BREAK) {
            this.getEngine().getLast().invokeHandler();
        } else {
            if (null != this.getOrder()) {
                EnginePipeline<?, ?> engine = this.getEngine();
                HandlerContext<?>[] handlerContexts = engine.getHandlerContexts();
                HandlerContext<?>[] handlerContextList = handlerContexts;
                int length = handlerContexts.length;

                for (int i = 0; i < length; ++i) {
                    HandlerContext<?> hc = handlerContextList[i];
                    if (this.getOrder().equals(hc.getEngineInfo().getOrder())) {
                        hc.invokeCurrentHandler();
                        hc.getNext().invokeHandler();
                    }
                }
            }
            this.next.invokeHandler();
        }
    }



    public HandlerContext<?> getLast() {
        return this.next.getLast();
    }

    public Integer getOrder() {
        return this.order;
    }

    public Instruction invokeCurrentHandler() {
        this.handler.genInnerParam(this);
        this.handler.handle(this);
        return Instruction.CONTINUE;
    }

    public abstract Buf getBuf();

}
