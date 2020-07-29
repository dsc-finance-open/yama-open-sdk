package com.dsc.financeopen.common;

/**
 * client 配置，主要用于设置一些超时时间
 * @author lg
 */
public class HttpClientConfig {

    public static final HttpClientConfig DEFAULT_CONFIG = new HttpClientConfig();

    /**
     * 连接超时时间
     */
    private int connectTimeoutSeconds = 10;

    /**
     * http读取超时时间
     */
    private int readTimeoutSeconds = 10;

    public int getConnectTimeoutSeconds() {
        return connectTimeoutSeconds;
    }

    public void setConnectTimeoutSeconds(int connectTimeoutSeconds) {
        this.connectTimeoutSeconds = connectTimeoutSeconds;
    }

    public int getReadTimeoutSeconds() {
        return readTimeoutSeconds;
    }

    public void setReadTimeoutSeconds(int readTimeoutSeconds) {
        this.readTimeoutSeconds = readTimeoutSeconds;
    }
}
