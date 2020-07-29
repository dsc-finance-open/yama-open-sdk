package com.dsc.financeopen.request.carloan;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
@Data
public class OrderQueryResponse {

    /**
     * 混淆后的订单号
     */
    private String orderNo;

    /**
     * 网商订单号
     */
    private String netBankOrderNo;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 审核额度
     */
    private Integer creditAmount;

    /**
     * 网商客户分层
     */
    private String customerGroup;

    /**
     * 风控拒绝原因
     */
    private String rejectReason;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证地址/常用地址
     */
    private String address;

    /**
     * 身份证号
     */
    private String certNo;

    /**
     * 证件有效期
     */
    private String certValidTime;

    /**
     * 工作单位
     */
    private String company;

    /**
     * 月收入 分
     */
    private Integer salary;

    /**
     * 行业 国标码
     */
    private String industry;

    /**
     * 职业 国标码
     */
    private String occupation;

    /**
     * 抵押人全称
     */
    private String mortgagee;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 车系
     */
    private String series;

    /**
     * 车型
     */
    private String type;

    /**
     * 颜色
     */
    private String color;

    /**
     * 车商名字
     */
    private String carDealer;

    /**
     * 车商门店所在城市
     */
    private String carShopCity;

    /**
     * 销售人员
     */
    private String saler;

    /**
     * 销售人员手机号
     */
    private String salerMobile;

    /**
     * 车辆成交价 分
     */
    private Integer carPrice;

    /**
     * 车辆认证价 分
     */
    private Integer carEvaluatePrice;

    /**
     * 贷款总金额
     */
    private Integer loanAmount;

    /**
     * 贷款总期数
     */
    private Integer loanPeriod;

    /**
     * 首付款金额 分
     */
    private Integer downPayment;

    /**
     * 最低首付比例
     */
    private BigDecimal downPaymentRatio;

    /**
     * 尾款 分
     */
    private Integer lastPayment;

    /**
     * 月供 分
     */
    private Integer monthPayment;

    /**
     * 贷款年利率
     */
    private BigDecimal interestRate;

    /**
     * 罚息上浮比例
     */
    private BigDecimal penaltyRate;

}
