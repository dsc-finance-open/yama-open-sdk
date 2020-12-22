package com.dsc.financeopen.request.vinparse;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.lang.reflect.Type;

@Data
public class VinParseRequest extends OpenRequestParam<VinParseResponse, VinParseRequest> {

    private static final String API = "com.souche.yama.facade.VinParseQueryFacade#parse";

    public VinParseRequest() {
        super(API);
        setData(this);
    }

    @Override
    public Type getResultClass() {
        return VinParseResponse.class;
    }

    private String vin;
}
