package br.cefet.model;

public class Country {
	private int id;
	private String name;
	
	public Country() {
		super();
	}
	
	public Country(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
}
