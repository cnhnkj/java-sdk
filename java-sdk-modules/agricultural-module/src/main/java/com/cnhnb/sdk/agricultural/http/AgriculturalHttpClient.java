package com.cnhnb.sdk.agricultural.http;

import com.cnhnb.sdk.agricultural.module.request.ShareInfo;
import com.cnhnb.sdk.agricultural.module.response.QuestionAndAnswerShareInfo;
import com.cnhnb.sdk.common.common.Constants;
import com.cnhnb.sdk.common.exception.HNException;
import com.cnhnb.sdk.common.module.BaseResult;
import com.cnhnb.sdk.common.okhttp.HnOkHttpClient;
import com.cnhnb.sdk.common.utils.Sha256SignUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AgriculturalHttpClient {

  private final HnOkHttpClient hnOkHttpClient;

  public AgriculturalHttpClient(HnOkHttpClient hnOkHttpClient) {
    this.hnOkHttpClient = hnOkHttpClient;
  }

  public BaseResult<List<QuestionAndAnswerShareInfo>> questionList(String url, ShareInfo shareInfo) {
    String sign = Sha256SignUtil.generateSign(shareInfo);
    shareInfo.setSign(sign);

    BaseResult<List<QuestionAndAnswerShareInfo>> baseResult = new BaseResult<>();
    try {
      Response response = hnOkHttpClient.post(url, new HashMap<>(), new HashMap<>());
      ResponseBody responseBody = response.body();
      if (responseBody == null) {
        return baseResult;
      }

      String body = responseBody.string();
      ObjectMapper objectMapper = new ObjectMapper();
      baseResult = objectMapper.readValue(body, new TypeReference<BaseResult<List<QuestionAndAnswerShareInfo>>>() {
      });
    } catch (HNException e) {
      baseResult.setMsg(e.getErrorMsg());
      baseResult.setCode(e.getErrorCode());
      return baseResult;
    } catch (Exception e) {
      baseResult.setMsg(e.getMessage());
      baseResult.setCode(Constants.EXCEPTION_CODE);
      return baseResult;
    }

    return baseResult;
  }


}
