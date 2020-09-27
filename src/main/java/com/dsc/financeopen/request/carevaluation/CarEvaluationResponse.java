package com.dsc.financeopen.request.carevaluation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author kangyahua
 * @date 2020/9/25
 **/
@Data
public class CarEvaluationResponse {

    /**
     * 指导价
     */
    private BigDecimal guidePrice;

    /**
     * 各个车况下，采购价格详情
     */
    private Map<String, ResidualPriceDTO> dealerBuy;

    /**
     * 各个车况下，零售价格详情
     */
    private Map<String, ResidualPriceDTO> dealer;

    /**
     * @author lige
     * @date 2020/5/22
     */
    @Data
    public static class ResidualPriceDTO {

        /**
         * 估值上限
         */
        private BigDecimal residualUp;

        /**
         * 估值价格
         */
        private BigDecimal residual;

        /**
         * 估值下限
         */
        private BigDecimal residualDown;

    }

}
