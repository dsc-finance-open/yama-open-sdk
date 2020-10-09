package com.dsc.financeopen.request.carevaluation;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 二手车估价(VIN)
 *
 * @author kangyahua
 * @date 2020/9/25
 **/
@Data
public class CarEvaluationByVinRequest extends OpenRequestParam<CarEvaluationByVinResponse, CarEvaluationByVinRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarEvaluationQueryFacade#queryCarEvaluationByVin";

    public CarEvaluationByVinRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<CarEvaluationByVinResponse> getResultClass() {
        return CarEvaluationByVinResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(CarEvaluationByVinRequest queryDTO) {
            this.queryDTO = queryDTO;
        }

        private CarEvaluationByVinRequest queryDTO;
    }

    /**
     * 城市编码（国标码）
     */
    private String cityCode;

    /**
     * 车架号
     */
    private String vin;

    /**
     * 上牌时间
     */
    private Date registerDate;

    /**
     * 里程，单位：万公里
     */
    private BigDecimal mile;

    /**
     * 是否发起事故车检查
     */
    private Boolean checkAccident = false;

    /**
     * 是否返回车况优秀最高零售价
     */
    private Boolean extraReturnPrices = false;
}
