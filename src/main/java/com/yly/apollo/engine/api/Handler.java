package com.yly.apollo.engine.api;

/**
 * 处理器
 */
public interface Handler<I> {
    /**
     * 处理器肯定要有 handler 方法吧
     * @param var1 HandlerContext参数
     */
    void handle(HandlerContext<I> var1);

    void genInnerParam(HandlerContext<I> var1);
}
