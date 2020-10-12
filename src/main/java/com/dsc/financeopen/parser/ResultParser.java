package com.dsc.financeopen.parser;


import com.alibaba.fastjson.JSON;
import com.dsc.financeopen.response.OpenResponseBridgeResult;
import com.dsc.financeopen.response.OpenResponseResult;

import java.lang.reflect.Type;

/**
 * @author shengchaojie
 * @date 2020/6/28
 **/
public class ResultParser {

    public static <T> OpenResponseResult<T> parse(String result, Class<T> clazz){
        OpenResponseBridgeResult bridgeResult = JSON.parseObject(result,OpenResponseBridgeResult.class);
        T data = JSON.parseObject(bridgeResult.getData(),clazz);
        OpenResponseResult<T> realResult = new OpenResponseResult<>(bridgeResult);
        realResult.setData(data);
        return realResult;
    }

    public static <T> OpenResponseResult<T> parse(String result, Type type){
        OpenResponseBridgeResult bridgeResult = JSON.parseObject(result,OpenResponseBridgeResult.class);
        T data = JSON.parseObject(bridgeResult.getData(),type);
        OpenResponseResult<T> realResult = new OpenResponseResult<>(bridgeResult);
        realResult.setData(data);
        return realResult;
    }

}
