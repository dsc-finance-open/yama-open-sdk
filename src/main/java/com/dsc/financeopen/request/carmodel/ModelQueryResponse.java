package com.dsc.financeopen.request.carmodel;

import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class ModelQueryResponse {
    /**
     * 别名
     */
    private String aliasName;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 销售状态
     */
    private Integer sellStatus;

    /**
     * 引导图
     */
    private String leadPic;

    /**
     * 来源
     */
    private String source;

    /**
     * 数据平台车款编码
     */
    private String modelTypeData;

    /**
     * 车牛车款编码
     */
    private String modelTypeCheniu;

    /**
     * 是否换代车型
     */
    private Boolean isReplacement;

    /**
     * 第几代
     */
    private Integer generation;

    /**
     * 进口方式
     */
    private String importType;

    private Integer importTypeKey;

    /** 厂家车型编码 */
    private String manuModelCode;

    /** 厂家车型名称 */
    private String manuModelName;

    /** 基准车型 **/
    private String baseModelCode;

    private String mappingCode;

    /**
     * 车型编码
     */
    private String modelCode;

    /**
     * 车型名称
     */
    private String modelName;

    /**
     * 年款
     */
    private Integer year;

    /** 车款编码 */
    private String categoryCode;

    /** 车款名称 */
    private String categoryName;

    /**
     * 关联车系编码
     */
    private String subSeriesCode;

    /**
     * 关联车系名称
     */
    private String subSeriesName;

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
