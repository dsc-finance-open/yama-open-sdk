package com.dsc.financeopen.response;

import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/28
 **/
@Data
public class OpenResponseBridgeResult {

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
    private String data;

    private String traceId;

}
