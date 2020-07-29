package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
public class UpdateOrderRequest extends OpenRequestParam<Boolean, UpdateOrderRequest.UpdateOrderRequestDataWrapper> {


    private static final String API = "com.souche.yama.carloan.facade.OrderAppFacade#close";

    public UpdateOrderRequest() {
        super(API);
    }

    @Override
    public Class<Boolean> getResultClass() {
        return Boolean.class;
    }

    @Data
    public static class UpdateOrderRequestDataWrapper{
        private UpdateOrderRequestData request;
    }

    @Data
    public static class UpdateOrderRequestData{
        /**
         * 机构id
         */
        private Long merchantId;

        /**
         * 订单号 混淆
         */
        private String orderNo;

        /**
         * 贷款人手机号，如无变更，可不填
         */
        private String mobile;

        /**
         * 品牌，如无变更，可不填
         */
        private String brand;

        /**
         * 车系，如无变更，可不填
         */
        private String series;

        /**
         * 车型，如无变更，可不填
         */
        private String type;

        /**
         * 颜色，如无变更，可不填
         */
        private String color;

        /**
         * 新车直租合同价，单位：分，如无变更，可不填
         */
        private Integer carPrice;

        /**
         * 车辆指导价，单位：分，如无变更，可不填
         */
        private Integer evaluatePrice;
    }

}
