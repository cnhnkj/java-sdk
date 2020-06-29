package com.cnhnb.sdk.common.common;

public class OkHttpConstants {

  /**
   * 连接超时时间 单位秒(默认10s)
   */
  public static final int CONNECT_TIMEOUT = 10;
  /**
   * 写超时时间 单位秒(默认 0 , 不超时)
   */
  public static final int WRITE_TIMEOUT = 30;
  /**
   * 回复超时时间 单位秒(默认30s)
   */
  public static final int READ_TIMEOUT = 30;
  /**
   * 底层HTTP库所有的并发执行的请求数量
   */
  public static final int DISPATCHER_MAX_REQUESTS = 64;
  /**
   * 底层HTTP库对每个独立的Host进行并发请求的数量
   */
  public static final int DISPATCHER_MAX_REQUESTS_PER_HOST = 8;
  /**
   * 底层HTTP库中复用连接对象的最大空闲数量
   */
  public static final int CONNECTION_POOL_MAX_IDLE_COUNT = 32;
  /**
   * 底层HTTP库中复用连接对象的回收周期（单位分钟）
   */
  public static final int CONNECTION_POOL_KEEP_ALIVE_SECOND = 300;

  public static final boolean FOLLOW_REDIRECTS = true;
  public static final boolean SSL_FOLLOW_REDIRECTS = true;
  public static final boolean RETRY_ON_CONNECTION_FAILURE = true;

  private OkHttpConstants() {
  }
}
