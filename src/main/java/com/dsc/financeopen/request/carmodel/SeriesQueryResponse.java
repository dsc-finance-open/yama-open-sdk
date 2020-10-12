package com.dsc.financeopen.request.carmodel;

import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class SeriesQueryResponse {

    /**
     * 车系英文名
     */
    private String enName;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 车系别名
     */
    private String aliasName;

    /**
     * 图片url
     */
    private String imageUrl;

    /**
     * 生产厂商
     */
    private String manufacturer;

    /**
     * 生产厂商编码
     */
    private String manufacturerCode;

    /**
     * 车系级别
     */
    private String level;

    /**
     * 车系级别
     */
    private Integer levelKey;

    /**
     * 最低价
     */
    private Integer lowestPrice;

    /**
     * 最高价
     */
    private Integer highestPrice;

    /**
     * 是否进口
     */
    private Boolean isImport;

    /**
     * 是否非国产(合资、进口)
     */
    private Boolean nonDomestic;

    /** 车系描述 */
    private String seriesDesc;

    /** 前代车系编码 **/
    private String preSeriesCode;

    /**
     * 车系编码
     */
    private String seriesCode;

    /**
     * 车系名称
     */
    private String seriesName;

    /**
     * 品牌编码, 格式"brand-N"
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;

}
