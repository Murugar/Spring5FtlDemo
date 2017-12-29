package com.iqmsoft.domain;

public class ListItem {

	private Integer id;
	private String text;
	private Boolean done;

	public ListItem() {
	}

	public ListItem(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
}
