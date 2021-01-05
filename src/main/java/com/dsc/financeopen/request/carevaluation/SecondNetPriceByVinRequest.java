package com.dsc.financeopen.request.carevaluation;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * 查询二网报价(VIN)
 *
 * @author: ningke
 */
@Data
public class SecondNetPriceByVinRequest extends OpenRequestParam<SecondNetPriceResponse, SecondNetPriceByVinRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarEvaluationQueryFacade#queryMonthPriceByVin";

    public SecondNetPriceByVinRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    /**
     * vin码
     */
    private String vin;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 日期 格式 yyyy-MM
     */
    private String date;

    @Override
    public Type getResultClass() {
        return SecondNetPriceResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(SecondNetPriceByVinRequest queryDTO) {
            this.priceQueryDTO = queryDTO;
        }

        private SecondNetPriceByVinRequest priceQueryDTO;
    }

}
