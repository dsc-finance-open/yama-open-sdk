package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.lang.reflect.Type;

/**
 * @author: ningke
 */
@Data
public class CodeByNameQueryRequest extends OpenRequestParam<String, CodeByNameQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#matchModelCodeByName";


    public CodeByNameQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Type getResultClass() {
        return String.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(CodeByNameQueryRequest queryRequest) {
            this.queryDTO = queryRequest;
        }

        private CodeByNameQueryRequest queryDTO;
    }

    /**
     * 品牌名称
     */
    String brandName;

    /**
     * 车系名称
     */

    String seriesName;

    /**
     * 型号名称
     */
    String modelName;

    /**
     * 车型编码
     */
    String modelDomain;

    /**
     * 是否精确匹配
     */
    Boolean exactly;
}
