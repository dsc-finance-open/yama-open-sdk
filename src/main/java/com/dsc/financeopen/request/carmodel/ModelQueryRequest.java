package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.util.List;

/**
 * @author: ningke
 */
@Data
public class ModelQueryRequest extends OpenRequestParam<List, ModelQueryRequest.Wrapper> {

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
    public Class<List> getResultClass() {
        return List.class;
    }

    /**车系编码*/
    private String seriesCode;
}
