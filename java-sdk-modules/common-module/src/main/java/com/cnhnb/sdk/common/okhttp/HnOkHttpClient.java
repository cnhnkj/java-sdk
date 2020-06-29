package com.cnhnb.sdk.common.okhttp;

import com.cnhnb.sdk.common.common.Constants;
import com.cnhnb.sdk.common.common.OkHttpConstants;
import com.cnhnb.sdk.common.config.OkHttpConfiguration;
import com.cnhnb.sdk.common.exception.HNException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class HnOkHttpClient {

  public static final String JSON_MIME = "application/json";
  public static final String FORM_MIME = "application/x-www-form-urlencoded";

  private final OkHttpClient okHttpClient;


  /**
   * 构建一个自定义配置的 HTTP Client 类
   */
  public HnOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, long readTimeout, long connectTimeout, long writeTimeout,
      int connectionPoolMaxIdleCount, int connectionPoolKeepAliveSecond, int maxRequests, int maxRequestsPerHost,
      boolean followRedirects, boolean sslFollowRedirects, boolean retryOnConnectionFailure) {
    Dispatcher dispatcher = new Dispatcher();
    dispatcher.setMaxRequests(maxRequests);
    dispatcher.setMaxRequestsPerHost(maxRequestsPerHost);

    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    ConnectionPool connectionPool = new ConnectionPool(connectionPoolMaxIdleCount,
        connectionPoolKeepAliveSecond, TimeUnit.SECONDS);

    if (httpLoggingInterceptor == null) {
      httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(Level.NONE);
    }

    builder.readTimeout(readTimeout, TimeUnit.SECONDS)
        .connectTimeout(connectTimeout, TimeUnit.SECONDS)
        .writeTimeout(writeTimeout, TimeUnit.SECONDS).connectionPool(connectionPool)
        .followRedirects(followRedirects).followSslRedirects(sslFollowRedirects)
        .retryOnConnectionFailure(retryOnConnectionFailure)
        .addInterceptor(httpLoggingInterceptor);

    builder.dispatcher(dispatcher);
    okHttpClient = builder.build();
  }

  public HnOkHttpClient() {
    this(null, OkHttpConstants.READ_TIMEOUT, OkHttpConstants.CONNECT_TIMEOUT, OkHttpConstants.WRITE_TIMEOUT,
        OkHttpConstants.CONNECTION_POOL_MAX_IDLE_COUNT, OkHttpConstants.CONNECTION_POOL_KEEP_ALIVE_SECOND,
        OkHttpConstants.DISPATCHER_MAX_REQUESTS, OkHttpConstants.DISPATCHER_MAX_REQUESTS_PER_HOST,
        OkHttpConstants.FOLLOW_REDIRECTS, OkHttpConstants.SSL_FOLLOW_REDIRECTS, OkHttpConstants.RETRY_ON_CONNECTION_FAILURE);
  }

  public HnOkHttpClient(OkHttpConfiguration okHttpConfiguration) {
    this(null, okHttpConfiguration.getReadTimeoutSecond(), okHttpConfiguration.getConnectTimeoutSecond(),
        okHttpConfiguration.getWriteTimeoutSecond(), okHttpConfiguration.getMaxIdleConnections(),
        okHttpConfiguration.getKeepAliveSecond(), okHttpConfiguration.getDispatcherMaxRequests(),
        okHttpConfiguration.getDispatcherMaxRequestsPerHost(), okHttpConfiguration.isFollowRedirects(),
        okHttpConfiguration.isSslFollowRedirects(), okHttpConfiguration.isRetryOnConnectionFailure());
  }

  private static String userAgent() {
    final String javaVersion = "Java/" + System.getProperty("java.version");
    final String os = System.getProperty("os.name") + " "
        + System.getProperty("os.arch") + " " + System.getProperty("os.version");
    final String sdk = "HnOkHttpClient/" + Constants.VERSION;
    return sdk + " (" + os + ") " + javaVersion;
  }

  public Response get(String url) {
    return get(url, new HashMap<>());
  }

  public Response get(String url, Map<String, String> headers) {
    Request.Builder requestBuilder = new Request.Builder().get().url(url);
    return send(requestBuilder, headers);
  }

  public Response post(String url, String body, Map<String, String>  headers)  {
    return post(url, body.getBytes(Constants.UTF_8), headers, JSON_MIME);
  }

  public Response post(String url, Map<String, String> params, Map<String, String> headers)  {
    final FormBody.Builder formBody = new FormBody.Builder();
    if(params != null) {
      params.forEach(formBody::add);
    }
    return post(url, formBody.build(), headers);
  }

  public Response post(String url, byte[] body, Map<String, String> headers, String contentType)  {
    RequestBody requestBody;
    MediaType mediaType = MediaType.parse(contentType);
    if (body != null && body.length > 0) {
      requestBody = RequestBody.create(mediaType, body);
    } else {
      requestBody = RequestBody.create(mediaType, new byte[0]);
    }
    return post(url, requestBody, headers);
  }

  private Response post(String url, RequestBody body, Map<String, String> headers)  {
    Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
    return send(requestBuilder, headers);
  }

  public Response send(final Request.Builder requestBuilder, Map<String, String> headers) {
    if (headers != null) {
      headers.forEach(requestBuilder::addHeader);
    }

    requestBuilder.addHeader("User-Agent", userAgent());
    Response res;
    try {
      res = this.okHttpClient.newCall(requestBuilder.build()).execute();
    } catch (IOException e) {
      throw new HNException(e);
    }

    if (!res.isSuccessful()) {
      throw new HNException(res);
    }
    return res;
  }


}
