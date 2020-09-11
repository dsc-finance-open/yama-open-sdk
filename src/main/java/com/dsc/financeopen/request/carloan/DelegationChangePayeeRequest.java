package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author kangyahua
 * @date 2020/09/08
 */
@Data
public class DelegationChangePayeeRequest extends OpenRequestParam<Void, DelegationChangePayeeRequest.Wrapper> {
    private static final String API = "com.souche.yama.carloan.facade.CarLoanFacade#changeDelegationApplyPayee";

    public DelegationChangePayeeRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 期次号列表
     */
    private List<Integer> terms;
    /**
     * 机构ID
     */
    private Long merchantId;
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

    @Override
    public Class<Void> getResultClass() {
        return Void.class;
    }

    @Data
    @AllArgsConstructor
    public static class Wrapper {
        DelegationChangePayeeRequest request;
    }
}
