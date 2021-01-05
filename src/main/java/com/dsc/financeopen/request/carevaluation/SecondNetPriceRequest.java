package com.dsc.financeopen.request.carevaluation;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * 查询二网报价
 *
 * @author: ningke
 */
@Data
public class SecondNetPriceRequest extends OpenRequestParam<SecondNetPriceResponse, SecondNetPriceRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarEvaluationQueryFacade#queryMonthPrice";

    public SecondNetPriceRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    /**
     * 车型code
     */
    private String modelCode;

    /**
     * 车型code来源  目前只支持DYCW(第一车网)
     */
    private String modelCodeSource;

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

        public Wrapper(SecondNetPriceRequest queryDTO) {
            this.priceQueryDTO = queryDTO;
        }

        private SecondNetPriceRequest priceQueryDTO;
    }

}
