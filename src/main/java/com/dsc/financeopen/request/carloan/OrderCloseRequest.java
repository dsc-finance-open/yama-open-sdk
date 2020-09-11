package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
@Data
public class OrderCloseRequest extends OpenRequestParam<Boolean, OrderCloseRequest.Wrapper> {

    private static final String API = "com.souche.yama.carloan.facade.CarLoanFacade#closeOrder";

    public OrderCloseRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<Boolean> getResultClass() {
        return Boolean.class;
    }

    @Data
    @AllArgsConstructor
    public static class Wrapper {
        OrderCloseRequest request;
    }

    /**
     * 订单号 经过混淆
     */
    private String orderNo;

    /**
     * 关闭原因
     */
    private String closeReason;
}
