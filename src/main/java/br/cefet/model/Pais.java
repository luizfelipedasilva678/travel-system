package br.cefet.model;

public class Pais {
	private int id;
	private String nome;
	
	public Pais() {
		super();
	}

	public Pais(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
