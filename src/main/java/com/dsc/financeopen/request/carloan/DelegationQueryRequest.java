package com.dsc.financeopen.request.carloan;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kangyahua
 * @date 2020/09/08
 */
@Data
public class DelegationQueryRequest extends OpenRequestParam<DelegationQueryResponse, DelegationQueryRequest.Wrapper> {
    private static final String API = "com.souche.yama.carloan.facade.CarLoanFacade#getDelegationApplyResult";
    /**
     * 机构代收付请求编号
     */
    private String outReqNo;

    public DelegationQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Data
    @AllArgsConstructor
    public static class Wrapper {
        DelegationQueryRequest request;
    }

    @Override
    public Class<DelegationQueryResponse> getResultClass() {
        return DelegationQueryResponse.class;
    }
}
