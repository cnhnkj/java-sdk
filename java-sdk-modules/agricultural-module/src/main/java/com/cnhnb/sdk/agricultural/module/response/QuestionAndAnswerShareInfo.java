package com.cnhnb.sdk.agricultural.module.response;

import java.util.Date;
import java.util.List;

public class QuestionAndAnswerShareInfo {
	//问题
	private String question;
	//回答
	private String answer;
	//发布时间
	private Date releaseTime;
	//类目名称1
	private String cateName1;
	//类目名称2
	private String cateName2;
	//类目名称3
	private String cateName3;
	//提问人姓名
	protected String userName;
	//专家姓名
	protected String expertName;
	//专家职称
	private String jobTitle;
	//提供单位
	private String provideUnit;
	//问答图片
	private List<ShareImage> questionImages;
	//问答图片
	private List<ShareImage> answerImages;

	public QuestionAndAnswerShareInfo() {
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getCateName1() {
		return cateName1;
	}

	public void setCateName1(String cateName1) {
		this.cateName1 = cateName1;
	}

	public String getCateName2() {
		return cateName2;
	}

	public void setCateName2(String cateName2) {
		this.cateName2 = cateName2;
	}

	public String getCateName3() {
		return cateName3;
	}

	public void setCateName3(String cateName3) {
		this.cateName3 = cateName3;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getProvideUnit() {
		return provideUnit;
	}

	public void setProvideUnit(String provideUnit) {
		this.provideUnit = provideUnit;
	}

	public List<ShareImage> getQuestionImages() {
		return questionImages;
	}

	public void setQuestionImages(
			List<ShareImage> questionImages) {
		this.questionImages = questionImages;
	}

	public List<ShareImage> getAnswerImages() {
		return answerImages;
	}

	public void setAnswerImages(
			List<ShareImage> answerImages) {
		this.answerImages = answerImages;
	}

	@Override
	public String toString() {
		return "QuestionAndAnswerShareInfo{" +
				"question='" + question + '\'' +
				", answer='" + answer + '\'' +
				", releaseTime=" + releaseTime +
				", cateName1='" + cateName1 + '\'' +
				", cateName2='" + cateName2 + '\'' +
				", cateName3='" + cateName3 + '\'' +
				", userName='" + userName + '\'' +
				", expertName='" + expertName + '\'' +
				", jobTitle='" + jobTitle + '\'' +
				", provideUnit='" + provideUnit + '\'' +
				", questionImages=" + questionImages +
				", answerImages=" + answerImages +
				'}';
	}

	public static class ShareImage {
		//图片路径
	  private String url;
		//排序
	  private Integer sort;

		public ShareImage() {
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Integer getSort() {
			return sort;
		}

		public void setSort(Integer sort) {
			this.sort = sort;
		}

		@Override
		public String toString() {
			return "ShareImage{" +
					"url='" + url + '\'' +
					", sort=" + sort +
					'}';
		}
	}
}
