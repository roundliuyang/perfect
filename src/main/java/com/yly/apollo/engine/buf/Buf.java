package com.yly.apollo.engine.buf;

import java.util.Map;

public interface Buf {
    Buf put(String var1, Object var2);

    Map<String, Object> getContext();

    Object get(String var1);

    Buf remove(String var1);

    void clear();

    int size();

    Buf object2Buf(Object var1);

    String toString();

    String toJsonString();

    Buf jsonString2Buf(String var1);

    String getNextHandlerName();

    void setNextHandlerName(String var1);

    Throwable getException();

    String getExceptionHandlerName();

    Buf pullAllObject2Buf(Object var1);
}

