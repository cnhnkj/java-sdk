package com.cnhnb.sdk.common.exception;

import okhttp3.Response;

public class HNException extends RuntimeException {

  private final Response response;
  private String errorMsg;

  public HNException() {
    this(null, null);
  }

  public HNException(Response response, Throwable e) {
    this.response = response;
    if(response != null) {
      errorMsg = response.message();
    } else {
      errorMsg = e.getMessage();
    }
  }

  public HNException(Throwable e) {
    this(null, e);
  }

  public HNException(Response response) {
    this(response, null);
  }
}
