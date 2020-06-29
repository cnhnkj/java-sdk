package com.cnhnb.sdk.agricultural.module.request;

import com.cnhnb.sdk.common.module.Secret;

public class ShareInfo extends Secret {
  //共享类别 固定填1
  private String power;
  //查询开始时间 日期格式：yyyy-MM-dd
  private String startTime;
  //查询结束时间 日期格式：yyyy-MM-dd
  private String endTime;
  //页码
  private Integer pageNo;
  //一页最大记录数
  private Integer pageSize;

  public ShareInfo() {
  }

  public String getPower() {
    return power;
  }

  public void setPower(String power) {
    this.power = power;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  @Override
  public String toString() {
    return "ShareInfo{" +
        "power='" + power + '\'' +
        ", startTime='" + startTime + '\'' +
        ", endTime='" + endTime + '\'' +
        ", pageNo=" + pageNo +
        ", pageSize=" + pageSize +
        '}';
  }
}