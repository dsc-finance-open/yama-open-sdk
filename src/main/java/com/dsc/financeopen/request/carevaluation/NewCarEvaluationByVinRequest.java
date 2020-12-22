package com.dsc.financeopen.request.carevaluation;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.lang.reflect.Type;

@Data
public class NewCarEvaluationByVinRequest extends OpenRequestParam<NewCarEvaluationByVinResponse, NewCarEvaluationByVinRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarEvaluationQueryFacade#queryNewCarEvaluationByVin";

    public NewCarEvaluationByVinRequest() {
        super(API);
        setData(new NewCarEvaluationByVinRequest.Wrapper(this));
    }

    @Override
    public Type getResultClass() {
        return NewCarEvaluationByVinResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(NewCarEvaluationByVinRequest queryDTO) {
            this.newCarEvaluationByVinQueryDTO = queryDTO;
        }

        private NewCarEvaluationByVinRequest newCarEvaluationByVinQueryDTO;
    }


    /**
     * vin码
     */
    private String vin;

    /**
     * 国标城市code
     */
    private String cityCode;

}
