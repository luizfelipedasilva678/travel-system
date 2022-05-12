package br.cefet.model;

public class Experiencia {
	private int id;
	private String conteudo;
	private int avaliacao;
	private LocalVisitado localVisitado;
	private Usuario usuario;
	
	public Experiencia() {
		super();
	}
	
	public Experiencia(int id,String conteudo, int avaliacao, LocalVisitado localVisitado, Usuario usuario) {
		this.conteudo = conteudo;
		this.avaliacao = avaliacao;
		this.localVisitado = localVisitado;
		this.usuario = usuario;
		this.id = id;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public int getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public LocalVisitado getLocalVisitado() {
		return localVisitado;
	}
	
	public void setLocalVisitado(LocalVisitado localVisitado) {
		this.localVisitado = localVisitado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
