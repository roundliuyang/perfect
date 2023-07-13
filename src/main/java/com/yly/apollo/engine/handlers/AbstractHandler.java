package com.yly.apollo.engine.handlers;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.yly.apollo.engine.HandlerManager;
import com.yly.apollo.engine.api.Handler;
import com.yly.apollo.engine.api.HandlerContext;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public abstract class AbstractHandler implements Handler {
    public AbstractHandler() {
    }

    public <I> void genInnerParam(HandlerContext<I> hc) {
        if (null == hc.getInnerParam()) {
            Map<String, Object> buf = hc.getEngine().getBuf().getContext();
            String className = hc.getEngineInfo().getHandlerInfo().getHandlerClass();
            String convertStr = hc.getEngineInfo().getHandlerInfo().getConvertStr();

            try {
                if (StringUtils.isNotBlank(convertStr)) {
                    Map<String, Object> params = JSON.parseObject(convertStr);
                    params.forEach((k, v) -> {
                        if (k.contains(".")) {
                            System.out.println("获取JSON中嵌套 key{}" +  k);
                            JSONObject jb = JSONUtil.parseFromMap(buf);
                            if (ObjectUtils.allNotNull(new Object[]{jb.getByPath(k)})) {
                                buf.put(v.toString(), jb.getByPath(k));
                            }
                        } else if (ObjectUtils.allNotNull(new Object[]{buf.get(k)})) {
                            buf.put(v.toString(), buf.get(k));
                        }

                    });
                }
                Object object = JSON.parseObject(JSON.toJSONString(buf), HandlerManager.getDtoClass(className));
                hc.setInnerParam((I) object);
            } catch (NumberFormatException var6) {
                throw new RuntimeException("数据格式不正确");
            }

        }

    }


}
