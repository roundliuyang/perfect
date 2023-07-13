package com.yly.apollo.engine.buf;

import com.alibaba.fastjson.JSON;
import com.yly.apollo.engine.utils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

public class MapBuf implements Buf {

    private Map<String, Object> context;
    private String nextHandlerName;

    public MapBuf() {
        this.context = new HashMap<>();
    }

    public MapBuf(Map<String, Object> bufMap) {
        this.context = bufMap;
    }

    public Buf put(String key, Object value) {
        this.context.put(key, value);
        return this;
    }

    public Map<String, Object> getContext() {
        return this.context;
    }

    public Object get(String key) {
        return this.context.get(key);
    }

    public Buf remove(String key) {
        this.context.remove(key);
        return this;
    }

    public void clear() {
        this.context.clear();
    }

    public int size() {
        return this.context.size();
    }

    public Buf object2Buf(Object o) {
        return this.jsonString2Buf(JSON.toJSONString(o));
    }

    public Buf pullAllObject2Buf(Object o) {
        this.context.putAll(BeanUtils.convertObjectToMap(o));
        return this;
    }

    public String toString() {
        return this.toJsonString();
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public Buf jsonString2Buf(String s) {
        try {
            return (Buf)JSON.parseObject(s, this.getClass());
        } catch (Exception var3) {
            System.out.println("jsonString2Buf error " + var3);
            return null;
        }
    }

    public String getNextHandlerName() {
        return this.nextHandlerName;
    }

    public void setNextHandlerName(String nextHandlerName) {
        this.nextHandlerName = nextHandlerName;
    }

    public String getExceptionHandlerName() {
        return null;
    }

    public Throwable getException() {
        return null;
    }
}