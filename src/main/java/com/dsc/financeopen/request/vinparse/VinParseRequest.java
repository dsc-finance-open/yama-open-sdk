package com.dsc.financeopen.request.vinparse;

import com.dsc.financeopen.request.OpenRequestParam;
import com.dsc.financeopen.request.carevaluation.NewCarEvaluationByVinResponse;
import lombok.Data;

import java.lang.reflect.Type;

@Data
public class VinParseRequest extends OpenRequestParam<VinParseResponse, VinParseRequest> {

    private static final String API = "com.souche.yama.facade.CarEvaluationQueryFacade#queryNewCarEvaluationByVin";

    public VinParseRequest() {
        super(API);
        setData(this);
    }

    @Override
    public Type getResultClass() {
        return NewCarEvaluationByVinResponse.class;
    }

    private String vin;
}
