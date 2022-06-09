package br.cefet.model;

public class Comment {
	private int id;
	private String content;
	private User user;
	private Experience experience;
	
	public Comment() {
		super();
	}
	
	public Comment(int id, String content, User user, Experience experience) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
		this.experience = experience;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}
}
