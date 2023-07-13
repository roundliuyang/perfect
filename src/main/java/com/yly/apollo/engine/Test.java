package com.yly.apollo.engine;

import com.yly.apollo.core.enums.ApolloApiEnum;
import com.yly.apollo.core.service.EngineService;


public class Test {
    public static void main(String[] args) throws Exception {

        EngineService engineService = new EngineService();
        engineService.invokeOns("test", ApolloApiEnum.OSS_STS_API);
    }
}
