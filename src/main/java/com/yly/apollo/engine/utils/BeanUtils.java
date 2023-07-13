package com.yly.apollo.engine.utils;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanUtils {

    public BeanUtils() {
    }

    public static Map<String, Object> convertObjectToMap(Object obj) {
        try {
            if (obj instanceof Map) {
                return (Map)obj;
            }

            Map<String, Object> returnMap = PropertyUtils.describe(obj);
            returnMap.remove("class");
            Map<String, Object> newMap = (Map)returnMap.entrySet().stream().filter((e) -> {
                return e.getValue() != null;
            }).collect(Collectors.toMap((e) -> {
                return (String)e.getKey();
            }, (e) -> {
                return e.getValue();
            }));
            return newMap;
        } catch (IllegalAccessException var3) {

        } catch (InvocationTargetException var4) {

        } catch (NoSuchMethodException var5) {
        }

        return new HashMap();
    }
}
