package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/6/29
 **/
public class OrderLoanRequest extends OpenRequestParam<Boolean, OrderLoanRequest.Wrapper> {

    private static final String API = "com.souche.yama.carloan.facade.CarLoanFacade#loanOrder";

    public OrderLoanRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<Boolean> getResultClass() {
        return Boolean.class;
    }

    @Data
    @AllArgsConstructor
    public static class Wrapper {
        OrderLoanRequest request;
    }

        /**
         * 机构id
         */
        private Long merchantId;

        /**
         * 订单号 经过混淆
         */
        private String orderNo;

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
        private String interestRate;

        /**
         * 收款方在网商开的资金账户，由网商业务提供
         */
        private String accountNo;

        /**
         * 收款方的网商卡号，开户后网商提供
         */
        private String accountExtNo;

        /**
         * 收款方网商银行卡的持卡人姓名，开户后网商提供
         */
        private String cardHolderName;

        /**
         * 收款方网商参与者ID，由网商业务提供
         */
        private String ipId;

        /**
         * 收款方网商角色ID，由网商业务提供
         */
        private String ipRoleId;

        /**
         * 车商名字
         */
        private String carDealer;

        /**
         * 车商门店所在市区编码
         */
        private String carShopAddrCode;

        /**
         * 车商门店所在省份
         */
        private String carShopProv;

        /**
         * 车商门店所在城市
         */
        private String carShopCity;

        /**
         * 车商门店地址
         */
        private String carShopAddr;


}
