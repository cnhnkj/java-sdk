package com.cnhnb.sdk.common.config;

public class BasicConfiguration {

  //密钥
  private String accessKey;
  //惠农网分配的accessKey
  private String secretKey;

  public BasicConfiguration() {
  }

  public BasicConfiguration(String accessKey, String secretKey) {
    this.accessKey = accessKey;
    this.secretKey = secretKey;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  @Override
  public String toString() {
    return "BasicConfiguration{" +
        "accessKey='" + accessKey + '\'' +
        ", secretKey='" + secretKey + '\'' +
        '}';
  }
}
