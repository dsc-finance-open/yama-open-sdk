package com.dsc.financeopen.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * @author lg
 * @date 2020/6/15
 */
@Data
public abstract class OpenRequestParam<E,T> {

    /**
     * api
     */

    private transient String api;

    private T data;

    public OpenRequestParam(){}

    public OpenRequestParam(String api) {
        this.api = api;
    }

    @JSONField(serialize = false)
    public abstract Type getResultClass();
}
