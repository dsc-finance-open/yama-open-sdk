package com.dsc.financeopen.request.carevaluation;

import lombok.Data;

/**
 * 查询二网报价
 *
 * @author: ningke
 */
@Data
public class SecondNetPriceResponse {

    /**
     * 平均批发价
     */
    private String avgPrice;

    /**
     * 最低报价
     */
    private String minPrice;

}
