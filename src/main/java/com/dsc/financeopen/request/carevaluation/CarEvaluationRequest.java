package com.dsc.financeopen.request.carevaluation;

import com.dsc.financeopen.request.OpenRequestParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 二手车估价
 *
 * @author kangyahua
 * @date 2020/9/25
 **/
@Data
public class CarEvaluationRequest extends OpenRequestParam<CarEvaluationResponse, CarEvaluationRequest.Wrapper> {

    private static final String API = "com.souche.yama.facade.CarEvaluationQueryFacade#queryCarEvaluationV2";

    public CarEvaluationRequest() {
        super(API);
        setData(new Wrapper(this));
    }

    @Override
    public Class<CarEvaluationResponse> getResultClass() {
        return CarEvaluationResponse.class;
    }

    @Data
    public static class Wrapper {

        public Wrapper(CarEvaluationRequest queryDTO) {
            this.queryDTO = queryDTO;
        }

        private CarEvaluationRequest queryDTO;
    }


    /**
     * 车型编码 来源域
     * 搜车: SOUCHE,
     * 第一车网: IAUTOS,
     * 车行168: CHEHANG168,
     * 广汇域: GUANGHUI,
     * 金陵: JINLING,
     * 汽车之家: CHE168,
     * 精真估: JINGZHENGU,
     * 懂车帝app: DONGCHEDIAPP,
     * 天猫域: TMALL,
     * 58: COM58,
     * 车300: CHE300,
     * 淘宝网: TAOBAO,
     * 欧尚: OUSHANG,
     * 三环: SANHUAN,
     * 淘车网: TAOCHE,
     * 上海大众: SHDAZHONG,
     * 99车圈: COM99,
     * 盈众: YINGZHONG,
     * 世腾: SHITENG,
     * 易车网: YICHE,
     * 鸿粤: HONGYUE,
     * 瓜子: GUAZI,
     * 新浪: SINA,
     * 车16888: COM16888,
     * 车易拍: CHEYIPAI,
     * 力洋: LIYANG,
     */
    private String modelDomain;

    /**
     * 车型编码
     */
    private String modelCode;

    /**
     * 搜车城市编码
     */
    private String cityCode;

    /**
     * 里程，单位：万公里
     */
    private BigDecimal mile;

    /**
     * 上牌时间,格式 yyyy-MM-dd
     */
    private Date regDate;

}
