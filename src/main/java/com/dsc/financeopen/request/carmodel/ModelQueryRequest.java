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
public class ModelQueryRequest extends OpenRequestParam<List<ModelQueryResponse>, ModelQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#queryModels";


    public ModelQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Data
    public static class Wrapper {

        public Wrapper(ModelQueryRequest modelCodeQueryRequest) {
            this.modelQueryDTO = modelCodeQueryRequest;
        }

        private ModelQueryRequest modelQueryDTO;
    }

    @Override
    public Type getResultClass() {
        return new TypeReference<List<ModelQueryResponse>>() {}.getType();
    }

    /**
     * 车系编码
     */
    private String seriesCode;
}
