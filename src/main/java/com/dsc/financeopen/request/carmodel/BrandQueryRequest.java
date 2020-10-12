package com.dsc.financeopen.request.carmodel;

import com.alibaba.fastjson.TypeReference;
import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author: ningke
 */
@Data
public class BrandQueryRequest extends OpenRequestParam<List<BrandQueryResponse>, Void> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#queryBrands";


    public BrandQueryRequest() {
        super(API);
    }

    @Override
    public Type getResultClass() {
        return new TypeReference<List<BrandQueryResponse>>() {}.getType();
    }

    /**
     * 车型code
     */
    private String modelCode;

    /**
     * 车型编码
     */
    private String modelDomain;
}
