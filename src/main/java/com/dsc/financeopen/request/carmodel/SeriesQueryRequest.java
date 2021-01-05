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
public class SeriesQueryRequest extends OpenRequestParam<List<SeriesQueryResponse>, SeriesQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#querySeries";

    public SeriesQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Type getResultClass() {
        return new TypeReference<List<SeriesQueryResponse>>(){}.getType();
    }

    @Data
    public static class Wrapper {

        public Wrapper(SeriesQueryRequest seriesQueryRequest) {
            this.seriesQueryDTO = seriesQueryRequest;
        }

        private SeriesQueryRequest seriesQueryDTO;
    }

    /**
     * 品牌编码
     */
    private String brandCode;
}
