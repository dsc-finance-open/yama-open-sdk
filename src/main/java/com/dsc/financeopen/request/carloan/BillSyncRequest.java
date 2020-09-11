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
public class BillSyncRequest extends OpenRequestParam<Void, BillSyncRequest.Wrapper> {
    public static final String API ="com.souche.yama.carloan.facade.CarLoanFacade#syncBill";
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单对应应还账单
     */
    List<BillDTO> bills;

    public BillSyncRequest() {
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
        private BillSyncRequest request;
    }

    @Data
    public static class BillDTO {
        /**
         * 期数
         */
        private Integer term;
        /**
         * 应还总金额（单位：分）
         */
        private Long totalAmt;
        /**
         * 应还本金（单位：分）
         */
        private Long prinAmt;
        /**
         * 应还利息（单位：分）
         */
        private Long intAmt;
        /**
         * 应还本罚（单位：分）
         */
        private Long overDuePrinAmt;
        /**
         * 应还利罚（单位：分）
         */
        private Long overDueIntAmt;
        /**
         * 应还其他费用（单位：分）
         */
        private Long otherFee;
        /**
         * 本期开始日 yyyy-MM-dd
         */
        private String startDate;
        /**
         * 本期到期日 yyyy-MM-dd
         */
        private String endDate;
        /**
         * 逾期天数
         * 未逾期填 0
         */
        private Integer overdueDays;
        /**
         * 账单状态 正常（NORMAL）,已结清（CLEAR），逾期（OVERDUE），已处置（DISPOSAL）
         */
        private String status;
        /**
         * 账单类型 正常(NORMAL),手续费(FEE),保证金(DEPOSIT)
         */
        private String billType;
    }
}
