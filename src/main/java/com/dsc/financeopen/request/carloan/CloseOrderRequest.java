package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
public class CloseOrderRequest extends OpenRequestParam<Boolean, CloseOrderRequest.CloseOrderRequestDataWrapper> {

    private static final String API = "com.souche.yama.carloan.facade.OrderAppFacade#close";

    public CloseOrderRequest() {
        super(API);
    }

    @Override
    public Class<Boolean> getResultClass() {
        return Boolean.class;
    }

    @Data
    public static class CloseOrderRequestDataWrapper{
        CloseOrderRequestData request;
    }

    @Data
    public static class CloseOrderRequestData{

        /**
         * 机构id
         */
        private Long merchantId;

        /**
         * 订单号 经过混淆
         */
        private String orderNo;

        /**
         * 关闭原因
         */
        private String closeReason;
    }

}
