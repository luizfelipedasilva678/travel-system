package br.cefet.model;

public class User {
	private int id;
	private String password;
	private String login;
	private int role = 1;
	
	public User() {
		super();
	}
	
	public User(String login, String password) {
		super();
		this.password = password;
		this.login = login;
	}
	
	public User(int id, String password, String login) {
		super();
		this.id = id;
		this.password = password;
		this.login = login;
	}
	
	public User(int id, String password, String login, int role) {
		super();
		this.id = id;
		this.password = password;
		this.login = login;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public int getRole() {
		
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
}
