# sdk 概述
## 作用
- 使金服开放平台的签名逻辑透明
- 为请求结果报文提供反序列化

## 通信
OpenClient 底层使用 okhttp3 client，为了复用连接，整个 SDK 只会存在一个okhttp 的 client 

# demo
## 发送请求，使用 json 字符串作为接收结果
````
        OpenClient client = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        OpenRequestParam param = new OpenRequestParam();
        param.setData(new HashMap<>());
        param.setApi("com.souche.Test#test");
        OpenResponseResult<String> res = client.execute(param,RequestMethod.POST);
````
## 发送请求，使用泛型类接收结果
````
        OpenClient client = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
        OpenRequestParam param = new OpenRequestParam();
        param.setData(new HashMap<>());
        param.setApi("com.souche.Test#test");
        OpenResponseResult<TestDTO> res = client.execute(param,RequestMethod.POST);
````
## 发送请求，指定超时时间(当前支持 connect time out 和 read time out)
````
        HttpClientConfig clientConfig = new HttpClientConfig();
        clientConfig.setReadTimeoutSeconds(20);
        clientConfig.setConnectTimeoutSeconds(20);
        OpenClient client = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",clientConfig);
        OpenRequestParam param = new OpenRequestParam();
        param.setData(new HashMap<>());
        param.setApi("com.souche.Test#test");
        OpenResponseResult<String> res = client.execute(param,RequestMethod.POST);
````

## 不同请求，指定不同的超时时间时，需要构造多个 OpenClient（连接池是共用的）
````
        // 超时时间为 20 秒
        HttpClientConfig clientConfig1 = new HttpClientConfig();
        clientConfig1.setReadTimeoutSeconds(20);
        clientConfig1.setConnectTimeoutSeconds(20);
        
        OpenClient client1 = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",clientConfig1);
        OpenRequestParam param1 = new OpenRequestParam();
        param1.setData(new HashMap<>());
        param1.setApi("com.souche.Test#test1");
        OpenResponseResult<String> res = client1.execute(param1,RequestMethod.POST);

        // 超时时间为 50 秒
        HttpClientConfig clientConfig2 = new HttpClientConfig();
        clientConfig1.setReadTimeoutSeconds(50);
        clientConfig1.setConnectTimeoutSeconds(50);

        OpenClient client2 = new OpenClient("http://localhost:8081/api","WWWWWWWWWWWWWWWWWWW","FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",clientConfig2);
        OpenRequestParam param2 = new OpenRequestParam();
        param2.setData(new HashMap<>());
        param2.setApi("com.souche.Test#test2");
        OpenResponseResult<String> res2 = client2.execute(param2,RequestMethod.POST);
````
## 调整连接池大小和连接存活时间
````
// 在发送请求之前初始化 baseClient
OpenHttp.initBaseClient(2,2);
````