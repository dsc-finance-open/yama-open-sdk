# sdk 概述
## 作用
- 使金服开放平台的签名逻辑透明
- 为请求结果报文提供反序列化

## 通信
OpenClient 底层使用 okhttp3 client，为了复用连接，整个 SDK 只会存在一个okhttp 的 client 

# 使用案例

## 定制请求
针对一些业务方,我们会定制请求返回模型，方便接入者使用
````
        DriverLicenseRequest driverLicenseRequest = new DriverLicenseRequest();
        driverLicenseRequest.setName("盛超杰");
        driverLicenseRequest.setIdCard("339005199205259014");
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
