package com.cnhnb.sdk.samples;

import com.cnhnb.sdk.agricultural.common.AgriculturalConstants;
import com.cnhnb.sdk.agricultural.http.AgriculturalHttpClient;
import com.cnhnb.sdk.agricultural.module.request.ShareInfo;
import com.cnhnb.sdk.agricultural.module.response.QuestionAndAnswerShareInfo;
import com.cnhnb.sdk.common.module.BaseResult;
import com.cnhnb.sdk.common.okhttp.HnOkHttpClient;
import java.util.List;

public class AgriculturalExample {

  public static void main(String[] args) {
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
  }
}
