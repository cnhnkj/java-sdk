package com.cnhnb.sdk.common.module;

public class BaseResult<T> {

  private int code;
  private String msg;
  private String traceId;
  private T data;

  public BaseResult() {
  }

  public BaseResult(int code, String msg, String traceId, T data) {
    this.code = code;
    this.msg = msg;
    this.traceId = traceId;
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getTraceId() {
    return traceId;
  }

  public void setTraceId(String traceId) {
    this.traceId = traceId;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BaseResult{" +
        "code=" + code +
        ", msg='" + msg + '\'' +
        ", traceId='" + traceId + '\'' +
        ", data=" + data +
        '}';
  }
}
