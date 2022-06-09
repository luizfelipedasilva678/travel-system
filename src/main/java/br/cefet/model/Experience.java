package br.cefet.model;

import java.sql.Date;

public class Experience {
	private int id;
	private String content;
	private int rating;
	private double totalCost;
	private Date arrivalDay ;
	private Date departureDay;
	private User user;	
	private PlaceVisited placeVisited;
	
	public Experience() {
		super();
	}
	
	public Experience(int id, String content, int rating, 
			double totalCost, Date arrivalDay, Date departureDay, 
			User user, PlaceVisited placeVisited) {
		super();
		this.id = id;
		this.content = content;
		this.rating = rating;
		this.totalCost = totalCost;
		this.arrivalDay = arrivalDay;
		this.departureDay = departureDay;
		this.placeVisited = placeVisited;
		this.user = user;
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
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public double getTotalCost() {
		
		return totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Date getArrivalDay() {
		return arrivalDay;
	}

	public void setArrivalDay(Date arrivalDay) {
		this.arrivalDay = arrivalDay;
	}

	public Date getDepartureDay() {
		return departureDay;
	}

	public void setDepartureDay(Date departureDay) {
		this.departureDay = departureDay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PlaceVisited getPlaceVisited() {
		return placeVisited;
	}

	public void setPlaceVisited(PlaceVisited placeVisited) {
		this.placeVisited = placeVisited;
	}
}
