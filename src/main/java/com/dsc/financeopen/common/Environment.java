package com.dsc.financeopen.common;

/**
 * @author shengchaojie
 * @date 2020/6/30
 **/
public interface Environment {
    /**
     * 测试环境
     */
    String TEST = "http://yama-open.proxy.dasouche.com/api";

    /**
     * 线上环境
     */
    String PROD = "https://yama-open.souche-fin.com/api";
}
