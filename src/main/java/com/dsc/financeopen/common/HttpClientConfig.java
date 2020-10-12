package com.dsc.financeopen.common;

import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;

import java.util.function.Consumer;

/**
 * client 配置，主要用于设置一些超时时间
 * @author lg
 */
public class HttpClientConfig {

    public static final HttpClientConfig DEFAULT = new HttpClientConfig();

    /**
     * 连接超时时间
     */
    @Getter
    @Setter
    private int connectTimeoutSeconds = 10;

    /**
     * http读取超时时间
     */
    @Getter
    @Setter
    private int readTimeoutSeconds = 10;

    /**
     * 自定义build逻辑
     */
    @Getter
    @Setter
    private Consumer<OkHttpClient.Builder> customBuildLogic;

}
