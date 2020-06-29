package com.cnhnb.sdk.common.module;

import com.cnhnb.sdk.common.config.BasicConfiguration;

public class Secret extends BasicConfiguration {
  //随机数
  private String nonce;
  //固定取值：SHA-256
  private String signAlgorithm;
  //请求的时间戳(13位时间戳)
  private Long timestamp;
  //所有参数计算出的签名，该值不参与签名
  private String sign;

  public String getNonce() {
    return nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public String getSignAlgorithm() {
    return signAlgorithm;
  }

  public void setSignAlgorithm(String signAlgorithm) {
    this.signAlgorithm = signAlgorithm;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  @Override
  public String toString() {
    return "Secret{" +
        "nonce='" + nonce + '\'' +
        ", signAlgorithm='" + signAlgorithm + '\'' +
        ", timestamp=" + timestamp +
        ", sign='" + sign + '\'' +
        '}';
  }
}
