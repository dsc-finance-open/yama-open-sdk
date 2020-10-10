package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.util.List;

/**
 * @author: ningke
 */
@Data
public class BrandQueryRequest extends OpenRequestParam<List, Void> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#queryBrands";


    public BrandQueryRequest() {
        super(API);
    }

    @Override
    public Class<List> getResultClass() {
        return List.class;
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
