package com.dsc.financeopen.request.carloan;

import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/28
 **/
@Data
public class OrderApplyResponse  {

    /**
     * 携带跳转链接的二维码图片url
     */
    private String codeUrl;

    /**
     * 我们系统混淆的orderNo
     */
    private String orderNo;

    /**
     * 二维码过期时间 毫秒
     */
    private Long expire;

}
