package com.dsc.financeopen.request.carmodel;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author: ningke
 */
@Data
public class ModelConfigQueryResponse {

    /* ---------------- 来自车型查询接口的数据 ---------------- */

    /**
     * 品牌编码, 格式"brand-N"
     */
    private String brandCode;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 车系编码
     */
    private String seriesCode;

    /**
     * 车系名称
     */
    private String seriesName;

    /**
     * 车型编码
     */
    private String modelCode;

    /**
     * 车型名称
     */
    private String modelName;

    /**
     * 车型年款
     */
    private Integer year;

    /**
     * 销售状态 1-在售；0-停售；2-预售
     */
    private Integer sellStatus;

    /**
     * 进口方式
     */
    private String importType;

    /* ---------------- 来自车型参数配置查询接口的数据 ---------------- */

    /**
     * 厂商
     */
    private String manufacture;

    /**
     * 能源类型
     */
    private String energyType;

    /**
     * 官方指导价
     */
    private Integer guidePrice;

    /**
     * 车身结构
     */
    private String structure;

    /**
     * 外观颜色
     */
    private Map<String, String> exteriorColor;

    /**
     * 内饰颜色
     */
    private Map<String, String> interiorColor;

    /**
     * 发动机
     */
    private String engine;

    /**
     * 整备质量(kg)
     */
    private Integer hostlingWeight;

    /**
     * 车门数(个)
     */
    private Integer doorNumber;

    /**
     * 座位数(个)
     */
    private String seatNumber;

    /**
     * 排量(mL)
     */
    private Integer engineVolume;

    /**
     * 进气形式
     */
    private String intakeType;

    /**
     * 最大功率(kW)
     */
    private BigDecimal maxPowerDecimal;

    /**
     * 最大扭矩(N·m)
     */
    private BigDecimal maxTorqueDecimal;

    /**
     * 燃料形式
     */
    private String fuelForm;

    /**
     * 燃油标号
     */
    private String fuelNumber;

    /**
     * 环保标准
     */
    private String environmentalStandards;

    /**
     * 驱动方式
     */
    private String drivingMode;

    /**
     * 工信部纯电续航里程(km)
     */
    private Integer miitEnduranceMileage;

    /**
     * 电池能量(kWh)
     */
    private BigDecimal batteryCapacity;

    /**
     * 变速箱类型
     */
    private String gearBoxType;

    /**
     * 电动机总功率(kW)
     */
    private BigDecimal electricTotalPowerDecimal;

    /**
     * 长*宽*高(mm)
     */
    private String size;
}
