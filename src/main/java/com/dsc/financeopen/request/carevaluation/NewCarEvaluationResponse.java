package com.dsc.financeopen.request.carevaluation;

import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/7/29
 **/
@Data
public class NewCarEvaluationResponse {

    /**
     * 全国批发价
     */
    private Long countryPrice;

    /**
     * 省份批发价
     */
    private Long provincePrice;

    /**
     * 城市批发价
     */
    private Long cityPrice;


}
