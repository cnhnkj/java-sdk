package com.cnhnb.sdk.common.common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Constants {

  public static final String TEST_URL = "https://openapi.cnhnkj.cn";
  public static final String PROD_URL = "https://openapi.cnhnb.com";

  /**
   * 版本号
   */
  public static final String VERSION = "0.0.2";

  /**
   * 所有都是UTF-8编码
   */
  public static final Charset UTF_8 = StandardCharsets.UTF_8;

  /**
   * 统一错误码
   */
  public static final int HN_EXCEPTION_CODE = 550;
  public static final int EXCEPTION_CODE = 540;


}
