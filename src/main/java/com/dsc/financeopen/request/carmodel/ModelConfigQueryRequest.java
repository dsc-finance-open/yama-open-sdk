package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class ModelConfigQueryRequest extends OpenRequestParam<ModelConfigQueryResponse, ModelConfigQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#queryModelCoreParameterConfiguration";

    public ModelConfigQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<ModelConfigQueryResponse> getResultClass() {
        return ModelConfigQueryResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(ModelConfigQueryRequest modelConfigQueryRequest) {
            this.queryDTO = modelConfigQueryRequest;
        }

        private ModelConfigQueryRequest queryDTO;
    }

    /**
     * 车型编码
     */
    private String modelCode;
}
