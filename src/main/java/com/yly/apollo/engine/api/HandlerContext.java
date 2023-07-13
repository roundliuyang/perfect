package com.yly.apollo.engine.api;

import com.yly.apollo.core.enums.Instruction;
import com.yly.apollo.engine.EngineInfo;
import com.yly.apollo.engine.buf.Buf;
import com.yly.apollo.engine.engine.EnginePipeline;

/**
 * 处理上下文接口
 * @param <I>
 */
public interface HandlerContext<I> {

    /**
     * 获取内部参数的方法
     */
    I getInnerParam();

    /**
     * 设置内部参数的方法
     */
    void setInnerParam(I var1);

    /**
     * 设置下一个处理上下文（HandlerContext）的方法，并返回设置后的下一个处理上下文
     */
    HandlerContext<?> setNext(HandlerContext<?> var1);

    /**
     * 获取下一个处理上下文（HandlerContext）的方法
     */
    HandlerContext<?> getNext();

    /**
     * 设置处理器（Handler）的方法，并返回设置后的处理上下文
     */
    HandlerContext<I> setHandler(Handler var1);

    /**
     * 设置引擎信息（EngineInfo）的方法，并返回设置后的处理上下文
     */
    HandlerContext<I> setEngineInfo(EngineInfo var1);

    /**
     * 获取引擎信息的方法
     */
    EngineInfo getEngineInfo();

    /**
     * 调用处理器的方法
     */
    void invokeHandler();

    /**
     * 获取引擎管道（EnginePipeline）的方法
     */
    EnginePipeline<?, ?> getEngine();

    /**
     * 获取最后一个处理上下文的方法
     */
    HandlerContext<?> getLast();

    /**
     * 调用当前处理器的方法
     */
    Instruction invokeCurrentHandler();


    /**
     * @deprecated
     */
    @Deprecated
    default Integer getOrder() {
        return null;
    }

    Buf getBuf();


}
