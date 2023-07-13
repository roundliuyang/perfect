package com.yly;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

public class Test {
    public static void main(String[] args) {
        // 假设 convertStr 的值为 {"key1": "a.b.c", "key2": "d"}
        String convertStr = "{\"a.b.c\": \"a.b.c\", \"key2\": \"d\"}";

        // 将 convertStr 解析为 Map<String, Object> 对象
        Map<String, Object> params = JSON.parseObject(convertStr);

        // 假设缓冲区上下文 buf 的值为 {"a": {"b": {"c": "nestedValue"}}}
        Map<String, Object> buf = new HashMap<>();
        Map<String, Object> nestedObj = new HashMap<>();
        nestedObj.put("c", "nestedValue");
        Map<String, Object> bObj = new HashMap<>();
        bObj.put("b", nestedObj);
        Map<String, Object> aObj = new HashMap<>();
        aObj.put("a", bObj);
        buf.putAll(aObj);

        // 遍历 params 的键值对
        params.forEach((k, v) -> {
            if (k.contains(".")) {
                // 键中包含 "."，表示键是一个嵌套路径
                JSONObject jb = (JSONObject) JSON.toJSON(buf);
                Object value = JSONPath.eval(jb, v.toString());
                if (value != null) {
                    // 获取到嵌套路径对应的值，并存入缓冲区上下文
                    buf.put(v.toString(), value);
                }
            } else {
                if (buf.containsKey(k)) {
                    // 缓冲区上下文中存在键 k，则将其值存入缓冲区上下文
                    buf.put(v.toString(), buf.get(k));
                }
            }
        });

        // 打印最终的缓冲区上下文
        System.out.println(buf);
    }
}
