![Maven最新版本](https://img.shields.io/maven-central/v/io.github.dsc-finance-open/yama-open-sdk.svg)

# sdk 概述
# 作用
- 使金服开放平台的签名逻辑透明
- 为请求结果报文提供反序列化

# 原理
OpenClient 底层使用 okhttp3 client，为了复用连接，整个 SDK 只会存在一个okhttp 的 client 

# api文档
见wiki

# 使用

```
        <dependency>
            <groupId>io.github.dsc-finance-open</groupId>
            <artifactId>yama-open-sdk</artifactId>
            <version>见最新版本</version>
        </dependency>
```

## 定制请求
针对一些业务方,我们会定制请求返回模型，方便接入者使用
````
        DriverLicenseRequest driverLicenseRequest = new DriverLicenseRequest();
        driverLicenseRequest.setName("盛超杰");
        driverLicenseRequest.setIdCard("test");
        OpenClient client = new OpenClient(Environment.TEST,"xxx","xxx");
        OpenResponseResult<DriverLicenseResponse> response = client.execute(driverLicenseRequest);
        System.out.println(JSON.toJSONString(response));
````

## 通用请求
如果暂时没有定制实现，那么可以根据接口文档，使用通用请求方式来调用接口
````
        CustomOpenRequestParam customOpenRequestParam = new CustomOpenRequestParam();
        customOpenRequestParam.setApi("com.souche.financeplatform.infocenter.api.facade.LicenseQueryFacade#queryDriverLicense");
        Map<String,Object> data = new HashMap<>();
        Map<String,Object> qry = new HashMap<>();
        qry.put("name","xxx");
        qry.put("idCard","xxx");
        data.put("licenseQueryQry", qry);
        customOpenRequestParam.setData(data);
        OpenClient client = new OpenClient(Environment.TEST,"xxx","xxx");
        OpenResponseResult<String> response = client.execute(customOpenRequestParam);
        System.out.println(JSON.toJSONString(response));
````

## 发送请求，指定超时时间(当前支持 connect time out 和 read time out)
````
        HttpClientConfig clientConfig = new HttpClientConfig();
        clientConfig.setReadTimeoutSeconds(20);
        clientConfig.setConnectTimeoutSeconds(20);
        OpenClient client = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",clientConfig);
        //...调用逻辑
````

## 自定义配置OKhttp client
有些情况下，我们需要做一些自定义配置，比如代理，可以使用以下方式实现
```
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.setCustomBuildLogic(a->{
            a.proxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",7891)));
        });
        OpenClient client = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",clientConfig);
        //...调用逻辑
```
