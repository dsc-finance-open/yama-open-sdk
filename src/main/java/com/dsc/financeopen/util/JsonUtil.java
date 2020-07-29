package com.dsc.financeopen.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author lige
 */
public class JsonUtil {
    
    /**
     * 对象转json
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        if(obj == null) {
            return "{}";
        }
        return JSON.toJSONString(obj);
    }

    /**
     * json转对象
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static JSONObject parseJsonObject(String json) {
        return JSON.parseObject(json);
    }
}
