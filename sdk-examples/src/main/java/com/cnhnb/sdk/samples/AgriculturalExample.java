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
    String ACCESS_KEY = "DWQOcrnPp1ogwgAHBdIK1mI-";
    String SECRET_KEY = "cJFhYuaq7Vo35e1pmXO0aGkJG";

    System.out.println("ACCESS_KEY is " + ACCESS_KEY + ", SECRET_KEY is " + SECRET_KEY);

    HnOkHttpClient hnOkHttpClient = new HnOkHttpClient();
    AgriculturalHttpClient agriculturalHttpClient = new AgriculturalHttpClient(hnOkHttpClient);

    ShareInfo shareInfo = new ShareInfo();
    BaseResult<List<QuestionAndAnswerShareInfo>> baseResult = agriculturalHttpClient
        .questionList(AgriculturalConstants.TEST_QUESTION_LIST_URL, shareInfo);

    System.out.println(baseResult.toString());
  }
}
