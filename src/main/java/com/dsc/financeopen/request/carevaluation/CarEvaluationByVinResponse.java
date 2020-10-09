package com.dsc.financeopen.request.carevaluation;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author kangyahua
 * @date 2020/9/25
 **/
@Data
public class CarEvaluationByVinResponse {

    /**
     * 车商零售价（默认车况）万元
     */
    private BigDecimal dealerPrice;
    /**
     * 车商零售价（车况一般）万元
     */
    private BigDecimal normalDealerPrice;
    /**
     * 车商零售价（车况良好）万元
     */
    private BigDecimal goodDealerPrice;
    /**
     * 车商零售价（车况优秀）万元
     */
    private BigDecimal excellentDealerPrice;
    /**
     * 车况优秀最高零售价（万元），extraReturnPrices为1时，才返回
     */
    private BigDecimal excellentDealerHighSoldPrice;
    /**
     * 本车事故检查结果，checkAccident为1时，查询有数据时才返回
     */
    private AccidentCarCheckResult accidentCarCheckResult;

    /**
     * 事故检查结果
     */
    @Data
    public static class AccidentCarCheckResult {

        /**
         * 事故车概率(百分比)
         */
        private String rate;

        /**
         * 事故车评级0:无法判断 1:可能 2:确定
         */
        private Integer level;

        /**
         * 对事故车评级的描述
         */
        private String desc;
    }


}
