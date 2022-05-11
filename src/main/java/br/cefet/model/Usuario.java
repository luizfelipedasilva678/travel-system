package br.cefet.model;

public class Usuario {
	private int id;
	private String login;  
	private String senha;
	private Experiencia experiencia;
	private Viajem viajem;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int id, String login, String senha, Experiencia experiencia, Viajem viajem) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.experiencia = experiencia;
		this.viajem = viajem;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Experiencia getExperiencia() {
		return experiencia;
	}
	
	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	
	public Viajem getViajem() {
		return viajem;
	}
	
	public void setViajem(Viajem viajem) {
		this.viajem = viajem;
	}
}