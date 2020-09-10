package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 创建代收付申请参数
 *
 * @author kangyahua
 * @date 2020/09/08
 */
@Data
public class DelegationCreateRequest extends OpenRequestParam<Void, DelegationCreateRequest.Wrapper> {
    private static final String API = "com.souche.yama.carloan.facade.CarLoanFacade#createDelegationApply";
    /**
     * 机构申请单号
     * 即该申请单在机构方的唯一编号
     */
    private String outReqNo;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 业务类型
     */
    private String bizType;
    /**
     * 期次号
     */
    private Integer termNo;
    /**
     * 申请金额 单位：分
     */
    private Long amount;

    /**
     * 收款人账户类型
     * 枚举值：ALIPAY(支付宝) ，MYBANK(网商银行)
     */
    private String payeeAccountType;
    /**
     * 收款人网商资金账号，支付宝2088开头或银行卡号
     */
    private String payeeAccountNo;
    /**
     * 账号外标，支付宝登录号或网商银行卡号
     */
    private String payeeAccountExtNo;
    /**
     * 收款方开户名称，收款方在网商开户的户名
     */
    private String payeeCardHolderName;
    /**
     * 收款人网商参与者id
     */
    private String payeeIpId;
    /**
     * 收款人网商银行角色
     */
    private String payeeRoleId;

    public DelegationCreateRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<Void> getResultClass() {
        return Void.class;
    }

    @Data
    @AllArgsConstructor
    public static class Wrapper {
        DelegationCreateRequest request;
    }
}
