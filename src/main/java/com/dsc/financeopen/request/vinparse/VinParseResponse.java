package com.dsc.financeopen.request.vinparse;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class VinParseResponse {

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 车系名称
     */
    private String seriesName;

    /**
     * 车型名称
     */
    private String modelName;

    /**
     * 指导价 元
     */
    private Integer guidePrice;

    /**
     * 排量 L
     */
    private BigDecimal engineVolumeUnitL;

    /**
     * 排放标准
     */
    private String emission;

    /**
     * 上市时间
     */
    private Date marketTime;

}
