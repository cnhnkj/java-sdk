package com.cnhnb.sdk.common.config;

import com.cnhnb.sdk.common.common.OkHttpConstants;

public class OkHttpConfiguration {

  private long readTimeoutSecond = OkHttpConstants.READ_TIMEOUT;
  private long connectTimeoutSecond = OkHttpConstants.CONNECT_TIMEOUT;
  private long writeTimeoutSecond = OkHttpConstants.WRITE_TIMEOUT;

  private int maxIdleConnections = OkHttpConstants.CONNECTION_POOL_MAX_IDLE_COUNT;
  private int keepAliveSecond = OkHttpConstants.CONNECTION_POOL_KEEP_ALIVE_SECOND;

  private boolean followRedirects = OkHttpConstants.FOLLOW_REDIRECTS;
  private boolean sslFollowRedirects = OkHttpConstants.SSL_FOLLOW_REDIRECTS;

  private boolean retryOnConnectionFailure = OkHttpConstants.RETRY_ON_CONNECTION_FAILURE;

  public int getDispatcherMaxRequests() {
    return dispatcherMaxRequests;
  }

  public void setDispatcherMaxRequests(int dispatcherMaxRequests) {
    this.dispatcherMaxRequests = dispatcherMaxRequests;
  }

  public int getDispatcherMaxRequestsPerHost() {
    return dispatcherMaxRequestsPerHost;
  }

  public void setDispatcherMaxRequestsPerHost(int dispatcherMaxRequestsPerHost) {
    this.dispatcherMaxRequestsPerHost = dispatcherMaxRequestsPerHost;
  }

  private int dispatcherMaxRequests = OkHttpConstants.DISPATCHER_MAX_REQUESTS;
  private int dispatcherMaxRequestsPerHost = OkHttpConstants.DISPATCHER_MAX_REQUESTS_PER_HOST;

  public long getReadTimeoutSecond() {
    return readTimeoutSecond;
  }

  public void setReadTimeoutSecond(long readTimeoutSecond) {
    this.readTimeoutSecond = readTimeoutSecond;
  }

  public long getConnectTimeoutSecond() {
    return connectTimeoutSecond;
  }

  public void setConnectTimeoutSecond(long connectTimeoutSecond) {
    this.connectTimeoutSecond = connectTimeoutSecond;
  }

  public long getWriteTimeoutSecond() {
    return writeTimeoutSecond;
  }

  public void setWriteTimeoutSecond(long writeTimeoutSecond) {
    this.writeTimeoutSecond = writeTimeoutSecond;
  }

  public int getMaxIdleConnections() {
    return maxIdleConnections;
  }

  public void setMaxIdleConnections(int maxIdleConnections) {
    this.maxIdleConnections = maxIdleConnections;
  }

  public int getKeepAliveSecond() {
    return keepAliveSecond;
  }

  public void setKeepAliveSecond(int keepAliveSecond) {
    this.keepAliveSecond = keepAliveSecond;
  }

  public boolean isFollowRedirects() {
    return followRedirects;
  }

  public void setFollowRedirects(boolean followRedirects) {
    this.followRedirects = followRedirects;
  }

  public boolean isSslFollowRedirects() {
    return sslFollowRedirects;
  }

  public void setSslFollowRedirects(boolean sslFollowRedirects) {
    this.sslFollowRedirects = sslFollowRedirects;
  }

  public boolean isRetryOnConnectionFailure() {
    return retryOnConnectionFailure;
  }

  public void setRetryOnConnectionFailure(boolean retryOnConnectionFailure) {
    this.retryOnConnectionFailure = retryOnConnectionFailure;
  }
}
