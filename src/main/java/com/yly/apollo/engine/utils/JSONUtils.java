package com.yly.apollo.engine.utils;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;

public class JSONUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public JSONUtils() {
    }

    public static <T> T parseJson(String params, Class<T> clazz) {
        try {
            return JSON.parseObject(params, clazz);
        } catch (Exception var3) {
            throw var3;
        }
    }

    public static String formatJson(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            char current = 0;
            int indent = 0;

            for(int i = 0; i < jsonStr.length(); ++i) {
                char last = current;
                current = jsonStr.charAt(i);
                switch(current) {
                    case ',':
                        sb.append(current);
                        if (last != '\\') {
                            sb.append('\n');
                            addIndentBlank(sb, indent);
                        }
                        break;
                    case '[':
                    case '{':
                        sb.append(current);
                        sb.append('\n');
                        ++indent;
                        addIndentBlank(sb, indent);
                        break;
                    case ']':
                    case '}':
                        sb.append('\n');
                        --indent;
                        addIndentBlank(sb, indent);
                        sb.append(current);
                        break;
                    default:
                        sb.append(current);
                }
            }

            return sb.toString();
        }
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for(int i = 0; i < indent; ++i) {
            sb.append('\t');
        }

    }

    public static String toJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException var2) {
            throw new IllegalArgumentException(var2);
        }
    }

    public static String toFormatJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException var2) {
            throw new IllegalArgumentException(var2);
        }
    }

    public static <T> T toJavaObject(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    public static ObjectNode readTree(String json) throws IOException {
        return (ObjectNode)getObjectMapper().readTree(json);
    }

    public static <T> T toJavaObject(String json, TypeReference<T> typeOfT) {
        try {
            return OBJECT_MAPPER.readValue(json, typeOfT);
        } catch (IOException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    static {
        OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
        OBJECT_MAPPER.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        OBJECT_MAPPER.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        OBJECT_MAPPER.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        OBJECT_MAPPER.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}