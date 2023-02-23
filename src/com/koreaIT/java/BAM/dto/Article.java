package com.koreaIT.java.BAM.dto;

public class Article extends dto {
	public String title;
	public String body;
	public int views;

	public Article(int id, String title, String body, String regDate) {
		this(id, title, body, regDate, 0);
	}

	public Article(int id, String title, String body, String regDate, int views) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.views = views;
	}

	public void addviews() {
		this.views++;

	}
}