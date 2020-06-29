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
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AgriculturalHttpClient {

  private final HnOkHttpClient hnOkHttpClient;

  public AgriculturalHttpClient(HnOkHttpClient hnOkHttpClient) {
    this.hnOkHttpClient = hnOkHttpClient;
  }

  /**
   * 获取前10热门品类行情
   * @param url，请求的url，包括测试环境和生产环境，通过常量进行设置
   * 测试环境 AgriculturalConstants.TEST_QUESTION_LIST_URL
   * 生产环境 AgriculturalConstants.PROD_QUESTION_LIST_URL
   * @param shareInfo, 业务参数对象
   * @return BaseResult<List<QuestionAndAnswerShareInfo>>
   */
  public BaseResult<List<QuestionAndAnswerShareInfo>> questionList(String url, ShareInfo shareInfo) {
    Map<String, String> params = Sha256SignUtil.generateParams(shareInfo);
    String sign = Sha256SignUtil.getSign(params);
    shareInfo.setSign(sign);
    params.put("sign", sign);

    BaseResult<List<QuestionAndAnswerShareInfo>> baseResult = new BaseResult<>();
    try {
      Response response = hnOkHttpClient.post(url, params, new HashMap<>());
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
