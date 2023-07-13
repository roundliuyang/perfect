package com.yly.apollo.core.handler;

import com.yly.apollo.core.entity.dto.ApplyIdempotentDTO;
import com.yly.apollo.engine.api.HandlerContext;
import com.yly.apollo.engine.handlers.AbstractHandler;


public class ApplyIdempotentHandler extends AbstractHandler {

    @Override
    public <I> void handle(HandlerContext<I> hc) {
        Object object= hc.getInnerParam() ;
        System.out.println("ApplyIdempotentHandler 被执行了");
    }

}