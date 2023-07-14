package com.yly.apollo.core.service;

import com.yly.apollo.core.enums.ApolloApiEnum;
import com.yly.apollo.core.enums.ApolloConstants;
import com.yly.apollo.core.handler.StandardHeadHandler;
import com.yly.apollo.core.handler.StandardTailHandler;
import com.yly.apollo.engine.EngineInfo;
import com.yly.apollo.engine.HandlerInfo;
import com.yly.apollo.engine.engine.EnginePipeline;

import java.util.ArrayList;
import java.util.HashMap;

public class EngineService {

    /**
     * 处理ONS消息 ,假设接受消息的handler 调用此方法
     */
    public String invokeOns(String onsMessage, ApolloApiEnum onsType) throws Exception {
        return doInvokeOns(onsMessage, onsType, new EnginePipeline<>(new StandardHeadHandler(), new StandardTailHandler()));
    }

    private String doInvokeOns(String strParams, ApolloApiEnum onsType, EnginePipeline<Object,Object> pipeline) throws Exception {

        // 实际上handlerInfos 可以是流程编排，从数据库中查询配置
        ArrayList<EngineInfo> handlerInfos = new ArrayList<>();
        EngineInfo engineInfo1 = new EngineInfo();
        engineInfo1.setName("applyIdempotentHandler");
        engineInfo1.setOrder(1);
        HandlerInfo handlerInfo1 = new HandlerInfo();
        handlerInfo1.setHandlerClass("applyIdempotentHandler");
        handlerInfo1.setHandlerName("applyIdempotentHandler");
        handlerInfo1.setHandlerDtoClass("");
        engineInfo1.setHandlerInfo(handlerInfo1);

        handlerInfos.add(engineInfo1);

        HashMap<Object, Object> params = new HashMap<>();
        params.put(ApolloConstants.API_TYPE, onsType.getApiType());
        params.put(ApolloConstants.API_NAME, onsType.getApiName());
        pipeline.init(handlerInfos).fireHandlers(params);
        return "ok";
    }



}
