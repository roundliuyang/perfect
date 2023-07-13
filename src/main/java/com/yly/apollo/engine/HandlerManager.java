package com.yly.apollo.engine;

import com.yly.apollo.core.entity.dto.ApplyIdempotentDTO;
import com.yly.apollo.core.handler.ApplyIdempotentHandler;
import com.yly.apollo.engine.api.Handler;

import java.util.concurrent.ConcurrentHashMap;

public class HandlerManager {
    private static final ConcurrentHashMap<String, Handler> localhandlerMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Class<?>> localDtoClassMap = new ConcurrentHashMap<>();

    static {
        ApplyIdempotentHandler applyIdempotentHandler = new ApplyIdempotentHandler();
        localhandlerMap.put("applyIdempotentHandler", applyIdempotentHandler);
        localDtoClassMap.put("applyIdempotentHandler", ApplyIdempotentDTO.class);
    }

    public static  Handler getHandler(String handlerName) {
        return  localhandlerMap.get(handlerName);
    }

    public static Class<?> getDtoClass(String handlerName) {
        return localDtoClassMap.get(handlerName);
    }
}
