package com.dsc.financeopen.client;

import com.dsc.financeopen.common.HttpClientConfig;
import com.dsc.financeopen.common.RequestMethod;
import com.dsc.financeopen.exception.OpenException;
import com.dsc.financeopen.util.JsonUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tanghc
 */
public class OpenRequest {
    private static final String AND = "&";
    private static final String EQ = "=";
    private static final String UTF8 = "UTF-8";

    private OpenHttp openHttp;

    public OpenRequest(HttpClientConfig httpClientConfig) {
        this.openHttp = new OpenHttp(httpClientConfig);
    }

    public String request(String url, Map<String, String> requestParam, RequestMethod requestMethod, Map<String, String> header) {
        switch (requestMethod) {
            case GET:
                return this.doGet(url, requestParam, header);
            case POST:
                return this.doPost(url, requestParam, header);
            default:
                throw new OpenException("暂不支持该请求方法");
        }
    }

    protected String doGet(String url, Map<String, String> requestParam, Map<String, String> header) {
        StringBuilder queryString = new StringBuilder();
        Set<String> keys = requestParam.keySet();
        for (String keyName : keys) {
            try {
                queryString.append(AND)
                        .append(keyName)
                        .append(EQ)
                        .append(URLEncoder.encode(String.valueOf(requestParam.get(keyName)), UTF8));
            } catch (UnsupportedEncodingException e) {
                throw new OpenException("编码异常",e);
            }
        }

        // 拼接参数
        String requestUrl = url + "?" + queryString.toString().substring(1);

        try {
            return openHttp.get(requestUrl, header);
        } catch (IOException e) {
            throw new OpenException("请求失败",e);
        }

    }

    protected String doPost(String url, Map<String, String> requestParam, Map<String, String> header) {
        try {
            return openHttp.postJsonBody(url, JsonUtil.toJsonString(requestParam), header);

        } catch (IOException e) {
            throw new OpenException("请求失败",e);
        }
    }

    public String postJsonBody(String url, String json) throws IOException {
        return this.openHttp.postJsonBody(url, json, null);
    }



}
