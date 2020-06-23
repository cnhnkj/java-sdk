package com.cnhnb.sdk.common.utils;

import com.cnhnb.sdk.common.config.BasicConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

public class HmacSha256SignUtil {

  public static String getHmacSha256Sign(BasicConfiguration basicConfiguration, Map<String, String> params) {
    if (null == params) {
      params = new HashMap<>();
    }
    params.put("accessKey", basicConfiguration.getAccessKey());
    params.put("timestamp", String.valueOf(System.currentTimeMillis()));
    params.put("nonce", UUID.randomUUID().toString().replace("-", ""));
    params.put("signAlgorithm", "HmacSHA256");
    return getHmacSha256Sign(basicConfiguration.getSecretKey(), params);
  }

  /**
   * 适用于所有参数，包括accessKey等都已经放到params的情况
   */
  private static String getHmacSha256Sign(String secretKey, Map<String, String> params) {
    List<String> list = new ArrayList<>();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      String value = entry.getValue();
      if (value != null && !value.equals("")) {
        list.add(entry.getKey() + "=" + value);
      }
    }
    String data = list.stream().sorted().collect(Collectors.joining("&"));
    return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secretKey).hmacHex(data);
  }
}
