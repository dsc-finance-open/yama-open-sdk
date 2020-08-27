package com.dsc.financeopen.request.carinfo;

import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class DriverLicenseResponse{

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
         * 驾驶证有效起始时间
         */
        private String validStartTime;

        /**
         * 驾驶证有效终止日期
         */
        private String validEndTime;

        /**
         * 初次领证时间
         */
        private String firstStartTime;

        /**
         * 驾驶证状态
         */
        private String licenseStatus;

        /**
         * 准驾车型
         */
        private String licenseClass;

        /**
         * 驾驶证种类
         */
        private String licenseType;

        /**
         * 性别(1/男性；2/女性)
         */
        private String gender;
    }


}
