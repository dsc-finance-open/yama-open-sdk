package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class ModelCodeQueryRequest extends OpenRequestParam<String, ModelCodeQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#matchModelCode";


    public ModelCodeQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Data
    public static class Wrapper {

        public Wrapper(ModelCodeQueryRequest modelCodeQueryRequest) {
            this.queryDTO = modelCodeQueryRequest;
        }

        private ModelCodeQueryRequest queryDTO;
    }

    @Override
    public Class<String> getResultClass() {
        return String.class;
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
