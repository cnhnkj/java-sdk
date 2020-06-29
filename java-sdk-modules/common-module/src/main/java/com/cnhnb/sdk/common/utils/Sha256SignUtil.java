package com.cnhnb.sdk.common.utils;

import com.cnhnb.sdk.common.module.Secret;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sha256SignUtil {

  private static final Logger logger = LoggerFactory.getLogger(Sha256SignUtil.class.getSimpleName());

  public static Map<String, String> generateParams(Secret bean) {
    Map<String, String> params = new HashMap<>();
    try {
      params = getParams(bean);
      return params;
    } catch (IllegalArgumentException e) {
      logger.warn(e.getMessage(), e);
    }
    return params;
  }

  public static String getSign(String accessKey, String secretKey, long timestamp, String nonce, String signAlgorithm,
      Map<String, String> params) {
    if (null == params) {
      params = new HashMap<>();
    }
    params.put("accessKey", accessKey);
    params.put("secretKey", secretKey);
    params.put("timestamp", String.valueOf(timestamp));
    params.put("nonce", nonce);
    params.put("signAlgorithm", signAlgorithm);
    return getSign(params);
  }

  public static String getSign(Map<String, String> params) {
    List<String> list = new ArrayList<>();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      if (!entry.getValue().equals("")) {
        list.add(entry.getKey() + "=" + entry.getValue());
      }
    }
    String str = list.stream().sorted().collect(Collectors.joining("&"));
    return DigestUtils.sha256Hex(str.toUpperCase());
  }

  public static Map<String, String> getParams(Secret bean) {
    if (null == bean) {
      return new HashMap<>();
    }
    return Stream.of(bean.getClass().getDeclaredFields(), bean.getClass().getSuperclass().getDeclaredFields(),
        bean.getClass().getSuperclass().getSuperclass().getDeclaredFields()).flatMap(Stream::of)
        .filter(f -> {
          f.setAccessible(true);
          try {
            return f.get(bean) != null && !f.get(bean).equals("") && !f.getName().equals("sign");
          } catch (IllegalArgumentException | IllegalAccessException e) {
            logger.warn(e.getMessage(), e);
          }
          return false;
        }).collect(Collectors.toMap(Field::getName, f -> {
          try {
            return f.get(bean).toString();
          } catch (IllegalArgumentException | IllegalAccessException e) {
            logger.warn(e.getMessage(), e);
          }
          return "";
        }));
  }
}
