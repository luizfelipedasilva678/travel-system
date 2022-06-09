package br.cefet.model;

public class PlaceVisited {
	private int id;
	private String image;
	private String name;
	private User user;
	private Country country;
	
	public PlaceVisited() {
		super();
	}
	
	public PlaceVisited(int id, String image, String name, User user, Country country) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.user = user;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
