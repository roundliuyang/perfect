package com.yly.apollo.engine;

import com.yly.apollo.core.enums.HandlerType;
import org.apache.commons.lang3.StringUtils;

public class EngineInfo {
    private Integer order;
    private String name;
    private String type;
    private HandlerInfo handlerInfo;

    public EngineInfo(Integer order, String name, HandlerInfo handlerInfo) {
        this.order = order;
        this.name = name;
        this.handlerInfo = handlerInfo;
    }
    public EngineInfo(String name) {
        this.type = HandlerType.LOCAL.name();
        this.name = name;
    }

    public EngineInfo build() {
        if (StringUtils.isBlank(this.name)) {
            throw new RuntimeException("engineInfo.name is blank");
        } else {
            return this;
        }
    }

    public EngineInfo() {
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HandlerInfo getHandlerInfo() {
        return handlerInfo;
    }

    public void setHandlerInfo(HandlerInfo handlerInfo) {
        this.handlerInfo = handlerInfo;
    }
}
