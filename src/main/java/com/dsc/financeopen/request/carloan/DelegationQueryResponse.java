package com.dsc.financeopen.request.carloan;

import lombok.Data;

/**
 * @author tuzhenxian
 * @date 19-12-10
 */

@Data
public class DelegationQueryResponse {

    /**
     * 机构申请单号
     */
    private String outReqNo;
    /**
     * 状态
     */
    private String status;
    /**
     * 完成时间
     */
    private String finishTime;
    /**
     * 备注
     */
    private String content;
}
