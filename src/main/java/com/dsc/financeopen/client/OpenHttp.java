package com.dsc.financeopen.client;

import com.dsc.financeopen.common.HttpClientConfig;
import com.dsc.financeopen.exception.OpenException;
import okhttp3.*;

import java.io.IOException;
import java.net.Proxy;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author tanghc
 */
public class OpenHttp {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private Map<String, List<Cookie>> cookieStore = new HashMap<String, List<Cookie>>();

    /**
     * baseClient 基础的连接池
     */
    private static OkHttpClient baseClient;

    private static boolean initFlag = false;

    /**
     * 与 commonClient 共享连接池，并设置个性的超时时间等
     */
    private OkHttpClient availableClient;

    private HttpClientConfig httpClientConfig;

    public OpenHttp(HttpClientConfig httpClientConfig) {
        if (!initFlag) {
            // 如果没有手动初始化，则自动初始化 baseClient
            initBaseClient(5, 5);
        }
        this.httpClientConfig = httpClientConfig;
        initAvailableClient(httpClientConfig);
    }

    /**
     * 初始化baseClient,只能执行一次
     *
     * @param maxIdleConnections 最大连接数
     * @param keepAliveDuration  连接存活时间,单位 minute
     * @return
     */
    public synchronized static void initBaseClient(int maxIdleConnections, int keepAliveDuration) {
        if (initFlag) {
            throw new OpenException("baseClient 已初始化！");

        }
        // 初始化 baseClient
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        baseClient = new OkHttpClient.Builder()
                // 设置默认链接超时时间（10 秒）
                .connectTimeout(httpClientConfig.getConnectTimeoutSeconds(), TimeUnit.SECONDS)
                .readTimeout(httpClientConfig.getReadTimeoutSeconds(), TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(maxIdleConnections, keepAliveDuration, TimeUnit.MINUTES))
                .build();
        // 设置标记位
        initFlag = true;
    }

    private void initAvailableClient(HttpClientConfig httpClientConfig) {
        OkHttpClient.Builder builder = OpenHttp.baseClient.newBuilder()
                // 设置链接超时时间，默认10秒
                .connectTimeout(httpClientConfig.getConnectTimeoutSeconds(), TimeUnit.SECONDS)
                .readTimeout(httpClientConfig.getReadTimeoutSeconds(), TimeUnit.SECONDS)
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                        cookieStore.put(httpUrl.host(), list);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                        List<Cookie> cookies = cookieStore.get(httpUrl.host());
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                });
        Optional.ofNullable(httpClientConfig.getCustomBuildLogic()).ifPresent(a->a.accept(builder));
        availableClient = builder.build();
    }



    /**
     * get请求
     *
     * @param url
     * @param header
     * @return
     * @throws IOException
     */
    public String get(String url, Map<String, String> header) throws IOException {
        Request.Builder builder = new Request.Builder().url(url).get();
        // 添加header
        addHeader(builder, header);

        Request request = builder.build();
        Response response = availableClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * 提交json字符串到请求体
     *
     * @param url
     * @param json
     * @param header header内容
     * @return
     * @throws IOException
     */
    public String postJsonBody(String url, String json, Map<String, String> header) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder().url(url).post(body);
        // 添加header
        addHeader(builder, header);

        Request request = builder.build();
        Response response = availableClient.newCall(request).execute();
        return response.body().string();
    }

    private void addHeader(Request.Builder builder, Map<String, String> header) {
        if (header != null) {
            Set<Map.Entry<String, String>> entrySet = header.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                builder.addHeader(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
    }

    public Map<String, List<Cookie>> getCookieStore() {
        return cookieStore;
    }

    public HttpClientConfig getHttpClientConfig() {
        return httpClientConfig;
    }

}
