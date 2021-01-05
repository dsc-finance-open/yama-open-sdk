package com.dsc.financeopen.request.carevaluation;

import lombok.Data;

@Data
public class NewCarEvaluationByVinResponse {

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
