package com.yly.apollo.engine;

public class HandlerInfo {
    private String handlerName;
    private String handlerClass;
    private String handlerDtoClass;
    private String convertStr;

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerClass() {
        return handlerClass;
    }

    public void setHandlerClass(String handlerClass) {
        this.handlerClass = handlerClass;
    }

    public String getHandlerDtoClass() {
        return handlerDtoClass;
    }

    public void setHandlerDtoClass(String handlerDtoClass) {
        this.handlerDtoClass = handlerDtoClass;
    }

    public String getConvertStr() {
        return convertStr;
    }

    public void setConvertStr(String convertStr) {
        this.convertStr = convertStr;
    }

    public HandlerInfo(String handlerName, String handlerClass, String handlerDtoClass, String convertStr) {
        this.handlerName = handlerName;
        this.handlerClass = handlerClass;
        this.handlerDtoClass = handlerDtoClass;
        this.convertStr = convertStr;
    }

    public HandlerInfo() {

    }
}
