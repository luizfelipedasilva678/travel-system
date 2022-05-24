package br.cefet.model;

public class Viajem {
	private int id;
	private double custo;
	private String seguranca;
	private String formasDeVIajem;
	private LocalVisitado local;
	private String outrasInformacoes;
	private Usuario usuario;
	
	public Viajem() {
		super();
	}
	
	public Viajem(int id, double custo, String seguranca, String formasDeVIajem, LocalVisitado local, String outrasInformacoes,
			Usuario usuario) {
		super();
		this.custo = custo;
		this.seguranca = seguranca;
		this.formasDeVIajem = formasDeVIajem;
		this.local = local;
		this.outrasInformacoes = outrasInformacoes;
		this.usuario = usuario;
		this.id = id;
	}
	
	public double getCusto() {
		return custo;
	}
	
	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	public String getSeguranca() {
		return seguranca;
	}
	
	public void setSeguranca(String seguranca) {
		this.seguranca = seguranca;
	}
	
	public String getFormasDeVIajem() {
		return formasDeVIajem;
	}
	
	public void setFormasDeVIajem(String formasDeVIajem) {
		this.formasDeVIajem = formasDeVIajem;
	}
	
	public LocalVisitado getLocal() {
		return local;
	}
	
	public void setLocal(LocalVisitado local) {
		this.local = local;
	}
	
	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}
	
	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
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
