package com.yly.apollo.core.handler;

import com.yly.apollo.engine.api.HandlerContext;
import com.yly.apollo.engine.buf.Buf;
import com.yly.apollo.engine.buf.MapBuf;
import com.yly.apollo.engine.handlers.AbstractHandler;
import com.yly.apollo.engine.utils.JSONUtils;

import java.util.Map;

public class StandardHeadHandler extends AbstractHandler {
    @Override
    public <I>  void handle(HandlerContext<I> hc) {
        final Object innerParam = hc.getInnerParam();
        Buf buf = new MapBuf();
        if (innerParam instanceof Map) {
            buf.getContext().putAll((Map<? extends String, ?>) innerParam);
        } else if (innerParam instanceof String) {
            buf.getContext().putAll(JSONUtils.toJavaObject((String) innerParam, Map.class));
        }
        hc.getEngine().setBuf(buf);
        System.out.println("我是一个大大的head");
    }
}
