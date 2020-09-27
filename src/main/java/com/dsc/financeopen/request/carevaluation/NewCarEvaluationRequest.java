package com.dsc.financeopen.request.carevaluation;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

/**
 * @author shengchaojie
 * @date 2020/7/29
 **/
@Data
public class NewCarEvaluationRequest extends OpenRequestParam<NewCarEvaluationResponse, NewCarEvaluationRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarEvaluationFacade#queryNewCarEvaluation";

    public NewCarEvaluationRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<NewCarEvaluationResponse> getResultClass() {
        return NewCarEvaluationResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(NewCarEvaluationRequest queryDTO) {
            this.queryDTO = queryDTO;
        }

        private NewCarEvaluationRequest queryDTO;
    }

    /**
     * 车型code
     */
    private String modelCode;

    /**
     * 车型code来源
     * DYCW(第一车网)
     */
    private String modelCodeSource;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 城市code来源
     * 用于做城市code映射
     * CG(灿谷)
     */
    private String cityCodeSource;

    /**
     * 日期
     * 格式 yyyy-MM-dd
     */
    private String date;



}
