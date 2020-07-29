/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.dsc.financeopen.util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * SignUtils.
 *
 * @author xiaoyu
 */
public final class SignUtils {

    /**
     * sign算法
     * 1. 将param内的参数通过字典序排序
     * 2. 通过 key1=value1&key2=value2的形式连接
     * 3. 在2的基础上拼接signKey
     * 4. md5加密
     * @param signKey sign key 注意signKey为appSecret
     * @param params  params
     * @return sign
     */
    public static String generateSign(final String signKey, final Map<String, String> params) {
        List<String> storedKeys = Arrays.stream(params.keySet()
                .toArray(new String[]{}))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        final String sign = storedKeys.stream()
                .filter(key -> !Objects.equals(key, "sign"))
                .map(key -> String.join("=", key, params.get(key)))
                .collect(Collectors.joining("&")).trim()
                .concat(signKey);
        return Md5Util.encryptUpper(sign);
    }

    public static void main(String[] args) {
        Map<String,String> params = new HashMap<>();
        params.put("api","com.souche.yama.facade.CarModelQueryFacade#queryBrands");
        params.put("appKey","WWWWWWWWWWWWWWWWWWWW");
        params.put("data","{\"brandQueryDTO\":{\"merchantId\":34706800301}}");
        params.put("timestamp","123");
        System.out.println(generateSign("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",params));

        params = new HashMap<>();
        params.put("api","com.souche.yama.carloan.facade.OrderAppFacade#orderApply");
        params.put("appKey","WWWWWWWWWWWWWWWWWWWW");
        params.put("data","{\"request\":{                \"merchantId\":1,                \"customerName\":\"虞洪祥\",                \"mobile\":\"13758114361\",                \"address\": \"浙江省杭州市余杭区五常大道175号\",                \"certNo\": \"330481199009105413\",                \"certValidTime\": \"2020-01-27\",                \"company\":\"浙江大搜车软件技术有限公司\",                \"salary\": 500000,                \"industry\": \"7\",                \"occupation\": \"2\",                \"mortgagee\": \"无\",                \"brand\": \"本田\",                \"series\": \"A级车\",                \"type\": \"飞度\",                \"color\": \"白色\",                \"saler\": \"颜芳宁\",                \"salerMobile\": \"15949425201\",                \"carPrice\": 15000000,                \"evaluatePrice\": 16000000,                \"loanAmount\": 10000000,                \"loanPeriod\": 12,                \"downPayment\": 5000000,                \"downPaymentRatio\": \"0.120000\",                \"lastPayment\": 933334,                \"monthPayment\": 933333,                \"interestRate\": \"0.12\",                \"penaltyRate\": \"0.05\"}}");
        params.put("timestamp","123");
        System.out.println(generateSign("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",params));
    }

    /**
     * isValid.
     *
     * @param sign    sign
     * @param params  params
     * @param signKey signKey
     * @return boolean boolean
     */
    public static boolean isValid(final String sign, final Map<String, String> params, final String signKey) {
        return Objects.equals(sign, generateSign(signKey, params));
    }

    /**
     * Generate key string.
     *
     * @return the string
     */
    public static String generateKey() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
