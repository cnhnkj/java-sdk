package com.cnhnb.sdk.common.okhttp;

import com.cnhnb.sdk.common.common.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HnOkHttpClient {

  private static final Logger logger = LoggerFactory.getLogger(HnOkHttpClient.class.getSimpleName());

  public static final String ContentTypeHeader = "Content-Type";
  public static final String DefaultMime = "application/octet-stream";
  public static final String JsonMime = "application/json";
  public static final String FormMime = "application/x-www-form-urlencoded";

  private static String userApp = null;

  private final OkHttpClient okHttpClient;


  /**
   * 构建一个自定义配置的 HTTP Client 类
   */
  public HnOkHttpClient() {
    Dispatcher dispatcher = new Dispatcher();
    OkHttpClient.Builder builder = new OkHttpClient.Builder();

    builder.dispatcher(dispatcher);
    okHttpClient = builder.build();
  }
  

//  private static String userAgent() {
//    final String javaVersion = "Java/" + System.getProperty("java.version");
//    final String os = System.getProperty("os.name") + " "
//        + System.getProperty("os.arch") + " " + System.getProperty("os.version");
//    final String sdk = "QiniuJava/" + Constants.VERSION;
//    String userApp = "";
//    if (Client.userApp != null) {
//      userApp = "/" + Client.userApp;
//    }
//    return sdk + userApp + " (" + os + ") " + javaVersion;
//  }
//
//  private static RequestBody create(final MediaType contentType,
//      final byte[] content, final int offset, final int size) {
//    if (content == null) throw new NullPointerException("content == null");
//
//    return new RequestBody() {
//      @Override
//      public MediaType contentType() {
//        return contentType;
//      }
//
//      @Override
//      public long contentLength() {
//        return size;
//      }
//
//      @Override
//      public void writeTo(BufferedSink sink) throws IOException {
//        sink.write(content, offset, size);
//      }
//    };
//  }
//
//  public Response get(String url)  {
//    return get(url, new StringMap());
//  }
//
//  public Response get(String url, StringMap headers)  {
//    Request.Builder requestBuilder = new Request.Builder().get().url(url);
//    return send(requestBuilder, headers);
//  }
//
//  public Response delete(String url, StringMap headers)  {
//    Request.Builder requestBuilder = new Request.Builder().delete().url(url);
//    return send(requestBuilder, headers);
//  }
//
//  public Response post(String url, byte[] body, StringMap headers)  {
//    return post(url, body, headers, DefaultMime);
//  }
//
//  public Response post(String url, String body, StringMap headers)  {
//    return post(url, StringUtils.utf8Bytes(body), headers, DefaultMime);
//  }
//
//  public Response post(String url, StringMap params, StringMap headers)  {
//    final FormBody.Builder f = new FormBody.Builder();
//    params.forEach(new StringMap.Consumer() {
//      @Override
//      public void accept(String key, Object value) {
//        f.add(key, value.toString());
//      }
//    });
//    return post(url, f.build(), headers);
//  }
//
//  public Response post(String url, byte[] body, StringMap headers, String contentType)  {
//    RequestBody rbody;
//    if (body != null && body.length > 0) {
//      MediaType t = MediaType.parse(contentType);
//      rbody = RequestBody.create(t, body);
//    } else {
//      MediaType t = MediaType.parse(contentType);
//      rbody = RequestBody.create(t, new byte[0]);
//    }
//    return post(url, rbody, headers);
//  }
//
//
//  public Response post(String url, byte[] body, int offset, int size,
//      StringMap headers, String contentType)  {
//    RequestBody rbody;
//    if (body != null && body.length > 0) {
//      MediaType t = MediaType.parse(contentType);
//      rbody = create(t, body, offset, size);
//    } else {
//      MediaType t = MediaType.parse(contentType);
//      rbody = RequestBody.create(null, new byte[0]);
//    }
//    return post(url, rbody, headers);
//  }
//
//  private Response post(String url, RequestBody body, StringMap headers)  {
//    Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
//    return send(requestBuilder, headers);
//  }
//
//
//  public Response send(final Request.Builder requestBuilder, StringMap headers)  {
//    if (headers != null) {
//      headers.forEach(new StringMap.Consumer() {
//        @Override
//        public void accept(String key, Object value) {
//          requestBuilder.header(key, value.toString());
//        }
//      });
//    }
//
//    requestBuilder.header("User-Agent", userAgent());
//    long start = System.currentTimeMillis();
//    okhttp3.Response res = null;
//    Response r;
//    IpTag tag = new IpTag();
//    try {
//      res = httpClient.newCall(requestBuilder.tag(tag).build()).execute();
//    } catch (IOException e) {
//      throw new QiniuException(e);
//    }
//
//    double duration = (System.currentTimeMillis() - start) / 1000.0;
//    r = Response.create(res, tag.ip, duration);
//    if (r.statusCode >= 300) {
//      throw new QiniuException(r);
//    }
//
//    return r;
//  }


}
