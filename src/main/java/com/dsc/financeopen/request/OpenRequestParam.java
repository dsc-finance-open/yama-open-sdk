package com.dsc.financeopen.request;

import lombok.Data;

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

    public OpenRequestParam(String api) {
        this.api = api;
    }

    public abstract Class<E> getResultClass();
}
