package com.yly.apollo.engine.api;

/**
 * 处理器
 */
public interface Handler {
    /**
     * 处理器肯定要有 handler 方法吧
     * @param var1 HandlerContext参数
     */
    <I> void handle(HandlerContext<I> var1);

    <I> void genInnerParam(HandlerContext<I> var1);
}
