package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author: ningke
 */
@Data
public class SoucheModelCodeQueryRequest extends OpenRequestParam<String, SoucheModelCodeQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#matchSoucheCode";


    public SoucheModelCodeQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Data
    public static class Wrapper {

        public Wrapper(SoucheModelCodeQueryRequest modelQueryRequest) {
            this.queryDTO = modelQueryRequest;
        }

        private SoucheModelCodeQueryRequest queryDTO;
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
