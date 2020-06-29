# java-sdk

惠农网给外部调用接口使用的java版本sdk

## 农技问答接口的使用方式

pom.xml里面引入依赖
```
    <dependency>
      <groupId>com.cnhnb.sdk</groupId>
      <artifactId>agricultural-module</artifactId>
      <version>0.0.2</version>
    </dependency>
```

接口方法：questionList
接口含义：获取前10热门品类行情

```
    //设置需要操作的账号的AK和SK
    String ACCESS_KEY = AgriculturalConstants.TEST_ACCESS_KEY;
    String SECRET_KEY = AgriculturalConstants.TEST_SECRET_KEY;

    HnOkHttpClient hnOkHttpClient = new HnOkHttpClient();
    AgriculturalHttpClient agriculturalHttpClient = new AgriculturalHttpClient(hnOkHttpClient);

    ShareInfo shareInfo = new ShareInfo();
    shareInfo.setStartTime("2020-06-11");
    shareInfo.setEndTime("2020-06-12");
    shareInfo.setNonce("abc");
    shareInfo.setPageNo(1);
    shareInfo.setPageSize(10);
    shareInfo.setPower("1");
    shareInfo.setSignAlgorithm("SHA-256");
    shareInfo.setTimestamp(1591932229714L);

    shareInfo.setAccessKey(ACCESS_KEY);
    shareInfo.setSecretKey(SECRET_KEY);

    BaseResult<List<QuestionAndAnswerShareInfo>> baseResult = agriculturalHttpClient
        .questionList(AgriculturalConstants.TEST_QUESTION_LIST_URL, shareInfo);

    System.out.println(baseResult.toString());
```