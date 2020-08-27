package com.dsc.financeopen.request.carinfo;

import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class DrivingPermitResponse {

    /**
     * 查询状态码
     */
    private Integer resCode;

    /**
     * 状态码文本描述
     */
    private String resDesc;

    /**
     * 查询结果
     */
    private Result res;

    /**
     * 业务订单号
     */
    private String orderNo;

    @Data
    public static class Result {

        /**
         * 号牌种类
         */
        private String licensePlateType;

        /**
         * 机动车状态
         */
        private String vehicleStatus;

        /**
         * 初次登记时间(返回 A~H 其中一个、样
         * 例：A)
         */
        private String firstRegisterDate;
    }

}
