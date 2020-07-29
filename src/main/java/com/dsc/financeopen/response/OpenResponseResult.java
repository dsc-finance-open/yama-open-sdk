package com.dsc.financeopen.response;

import lombok.Data;

/**
 * @author lg
 * @date 2020/6/15
 */
@Data
public class OpenResponseResult<T> {

    /**
     * 响应码
     */
    private String code;

    /**
     * message
     */
    private String msg;

    /**
     * api 返回数据
     */
    private T data;

    private String traceId;

    public OpenResponseResult() {
    }

    public OpenResponseResult(OpenResponseBridgeResult bridgeResult) {
        this.code = bridgeResult.getCode();
        this.msg = bridgeResult.getMsg();
        this.traceId = bridgeResult.getTraceId();
    }
}
