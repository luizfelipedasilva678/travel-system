package br.cefet.model;

public class Comment {
	private int id;
	private String content;
	
	public Comment() {
		super();
	}
	
	public Comment(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
