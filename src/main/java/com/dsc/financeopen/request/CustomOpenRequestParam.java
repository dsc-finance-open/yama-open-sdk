package com.dsc.financeopen.request;

import java.util.Map;

/**
 * @author shengchaojie
 * @date 2020/7/30
 **/
public class CustomOpenRequestParam extends OpenRequestParam<String,Map<String,Object>>{
    @Override
    public Class<String> getResultClass() {
        return String.class;
    }
}
