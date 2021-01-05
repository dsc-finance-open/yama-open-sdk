package com.dsc.financeopen.request.carmodel;

import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class BrandQueryResponse {
    /**
     * 品牌图片
     */
    private String logoUrl;

    /**
     * 弹个车图片
     */
    private String tangecheLogoUrl;

    /**
     * 英文名字
     */
    private String enName;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 别名
     */
    private String aliasName;

    /**
     * 国别
     */
    private String country;

    /**
     * 首字母
     */
    private String firstWord;

    /**
     * 描述
     */
    private String description;

    /**
     * 车行168编码
     */
    private String chehang168Code;

    /** 官方网站 **/
    private String website;

    /** 其下车系数量 **/
    private Integer seriesCounter;

    /**
     * 品牌编码, 格式"brand-N"
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;
}
