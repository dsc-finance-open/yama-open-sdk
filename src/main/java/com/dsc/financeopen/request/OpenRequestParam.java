package com.dsc.financeopen.request;

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
    private String api;

    private T data;

    public OpenRequestParam(){}

    public OpenRequestParam(String api) {
        this.api = api;
    }

    public abstract Type getResultClass();
}
