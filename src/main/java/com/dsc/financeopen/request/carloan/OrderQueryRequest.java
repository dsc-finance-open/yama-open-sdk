package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
public class OrderQueryRequest extends OpenRequestParam<OrderQueryResponse, OrderQueryRequest> {

    private static final String API = "com.souche.yama.carloan.facade.CarLoanFacade#getOrderByOrderNo";

    public OrderQueryRequest() {
        super(API);
        setData(this);
    }

    @Override
    public Class<OrderQueryResponse> getResultClass() {
        return OrderQueryResponse.class;
    }

    private String orderNo;

}
