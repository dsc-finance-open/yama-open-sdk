package com.dsc.financeopen.request.carmodel;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.util.List;

/**
 * @author: ningke
 */
@Data
public class SeriesQueryRequest extends OpenRequestParam<List, SeriesQueryRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarModelQueryFacade#querySeries";

    public SeriesQueryRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<List> getResultClass() {
        return List.class;
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
