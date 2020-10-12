package com.dsc.financeopen.client;

import com.alibaba.fastjson.JSON;
import com.dsc.financeopen.common.HttpClientConfig;
import com.dsc.financeopen.common.RequestMethod;
import com.dsc.financeopen.exception.OpenException;
import com.dsc.financeopen.parser.ResultParser;
import com.dsc.financeopen.request.OpenRequestParam;
import com.dsc.financeopen.response.OpenResponseResult;
import com.dsc.financeopen.util.SignUtils;
import com.dsc.financeopen.util.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 请求客户端
 *
 * @author tanghc
 */
public class OpenClient {

    private String url;
    private String appKey;
    private String appSecret;

    private OpenRequest openRequest;

    public OpenClient(String url, String appKey, String secret) {
        this(url, appKey, secret, HttpClientConfig.DEFAULT);
    }

    public OpenClient(String url, String appKey, String secret, HttpClientConfig httpClientConfig) {
        if (httpClientConfig == null) {
            throw new IllegalArgumentException("httpClientConfig 不能为null");
        }
        this.url = url;
        this.appKey = appKey;
        this.appSecret = secret;
        this.openRequest = new OpenRequest(httpClientConfig);
    }

    /**
     * 向开放平台发起请求
     *
     * @param requestParam  请求参数
     * @return
     */
    public <E,T> OpenResponseResult<E> execute(OpenRequestParam<E,T> requestParam) {

        // 参数校验
        validateOpenRequestParam(requestParam);

        // 参数处理
        Map<String, String> params = handlerParam(requestParam);

        // 发送请求
        String res = openRequest.request(url,params, RequestMethod.POST, new HashMap<>());

        // 处理返回值
        return ResultParser.parse(res,requestParam.getResultClass());
    }


    /**
     * 处理参数，主要是计算 签名
     *
     * @param requestParam
     * @return
     */
    private Map<String, String> handlerParam(OpenRequestParam requestParam) {
        Map<String, String> params = new HashMap<>(16);
        params.put("api", requestParam.getApi());
        params.put("data", Objects.nonNull(requestParam.getData()) ?
                JSON.toJSONString(requestParam.getData()) : "");
        params.put("timestamp",String.valueOf(System.currentTimeMillis()));
        params.put("appKey", appKey);
        // 计算签名
        String sign = SignUtils.generateSign(appSecret, params);
        params.put("sign", sign);
        return params;
    }

    private void validateOpenRequestParam(OpenRequestParam requestParam) {
        if (Objects.isNull(requestParam)) {
            throw new OpenException("参数 requestParam 不能为null");
        }
        if (StringUtil.isEmpty(requestParam.getApi())) {
            throw new OpenException("参数 api 不能为空");
        }
    }
}
