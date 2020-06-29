package com.cnhnb.sdk.common.exception;

import com.cnhnb.sdk.common.common.Constants;
import okhttp3.Response;

public class HNException extends RuntimeException {

  private final Response response;
  private String errorMsg;

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  private int errorCode;

  public HNException() {
    this(null, null);
  }

  public HNException(Response response, Throwable e) {
    this.response = response;
    if(response != null) {
      errorMsg = response.message();
      errorCode = response.code();
    } else {
      errorMsg = e.getMessage();
      errorCode = Constants.HN_EXCEPTION_CODE;
    }
  }

  public HNException(Throwable e) {
    this(null, e);
  }

  public HNException(Response response) {
    this(response, null);
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
}
