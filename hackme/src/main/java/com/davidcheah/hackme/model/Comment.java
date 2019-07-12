package com.davidcheah.hackme.model;

public class Comment {
	int id;
	String comment;
	int authorid;

	public Comment(String comment, int authorid) {
		super();
		this.comment = comment;
		this.authorid = authorid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

}
