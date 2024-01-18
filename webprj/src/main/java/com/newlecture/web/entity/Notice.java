package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String writer_id;
	private Date regDate;
	private String content;
	private int hit;
	
	public Notice() {
	}

	//	매개변수로 들어감
	public Notice(int id, String title, String writer_id, Date regDate, String content, int hit) {
		this.id = id;
		this.title = title;
		this.writer_id = writer_id;
		this.regDate = regDate;
		this.content = content;
		this.hit = hit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}