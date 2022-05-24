package br.cefet.model;

public class LocalVisitado {
	private int id;
	private String imagem;
	private String nome;
	private Pais pais;
	private Viajem viajem;
	
	public LocalVisitado() {
		super();
	}
	
	public LocalVisitado(int id, String imagem, String nome, Pais pais, Viajem viajem) {
		super();
		this.imagem = imagem;
		this.nome = nome;
		this.pais = pais;
		this.viajem = viajem;
		this.id = id;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	public Viajem getViajem() {
		return viajem;
	}
	
	public void setViajem(Viajem viajem) {
		this.viajem = viajem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
