package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
public class OrderQueryRequest extends OpenRequestParam<OrderQueryResponse, OrderQueryRequest.OrderQueryRequestDataWrapper> {

    private static final String API = "com.souche.yama.carloan.facade.OrderQueryFacade#getOrderByOrderNo";


    public OrderQueryRequest() {
        super(API);
    }

    @Override
    public Class<OrderQueryResponse> getResultClass() {
        return OrderQueryResponse.class;
    }

    @Data
    public static class OrderQueryRequestDataWrapper{

        private Long merchantId;

        private String orderNo;
    }

}
