package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Country;
import br.cefet.model.Experience;
import br.cefet.model.PlaceVisited;
import br.cefet.model.User;

public class ExperienceDAO {
	private Connection connection;
    private String commandSQL;
    private PreparedStatement stmt;

    public ExperienceDAO() {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }

    public void add(Experience experience) {
        this.commandSQL = "insert into experience(content, rating, total_cost, arrival_day, departure_day, id_place_visited, id_user) "
        		+ "values(?,?)";
        
        try {
            this.stmt = this.connection.prepareStatement(this.commandSQL);

            this.stmt.setString(1, experience.getContent());
            this.stmt.setInt(2, experience.getRating());
            this.stmt.setDouble(3, experience.getTotalCost());
            this.stmt.setDate(4, experience.getArrivalDay());
            this.stmt.setDate(5, experience.getDepartureDay());
            this.stmt.setInt(6, experience.getUser().getId());
            this.stmt.setInt(7, experience.getPlaceVisited().getId());
            this.stmt.execute();
            System.out.println("Experience added with no errors");

        } catch(SQLException e) {   
            System.out.println("Error on add" + e.getMessage());
        } finally {
            try {
                this.stmt.close();
                System.out.println(this.connection);
            } catch(SQLException e) {
                System.out.println("Error on free resources" + e.getMessage());
            }
        }
    }

    public List<Experience> loadAllExperiences() {
        List<Experience> experiences = new ArrayList<Experience>();
        try {
            this.stmt = this.connection.prepareStatement("select \n"
            		+ "e.content, \n"
            		+ "e.rating, \n"
            		+ "e.total_cost, \n"
            		+ "e.arrival_day, \n"
            		+ "e.departure_day, \n"
            		+ "pv.image, \n"
            		+ "pv.name as place_visited_name,\n"
            		+ "c.name as country_name,\n"
            		+ "u.login\n"
            		+ "from experience e \n"
            		+ "join place_visited pv on (pv.id = e.id_place_visited)\n"
            		+ "join country c on (c.id = pv.id_country)\n"
            		+ "join user u on (u.id = e.id_user)");
            ResultSet rs = this.stmt.executeQuery();
            
            while(rs.next()) {
                User user = new User();
                user.setLogin(rs.getString("login"));
                
                Country country = new Country();
                country.setName(rs.getString("country_name"));
                
                PlaceVisited placeVisited = new PlaceVisited();
                placeVisited.setName(rs.getString("place_visited_name"));
                placeVisited.setImage(rs.getString("image"));
                placeVisited.setCountry(country);
                
                Experience experience = new Experience();
                experience.setContent(rs.getString("content"));
                experience.setRating(rs.getInt("rating"));
                experience.setTotalCost(rs.getDouble("total_cost"));
                experience.setDepartureDay(rs.getDate("arrival_day"));
                experience.setDepartureDay(rs.getDate("departure_day"));
                experience.setUser(user);
                experience.setPlaceVisited(placeVisited);
                
                experiences.add(experience);
            }

            return experiences;
            
        } catch (SQLException e) {
            System.out.println("Error on list experiences" + e.getMessage());
            return null;
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error on list experiences" + e.getMessage());
            }
        }
    }
    
    public Experience loadExperienceById(int id) {
    	Experience experience = new Experience();
    	User user = new User();
    	PlaceVisited placeVisited = new PlaceVisited();
    	
        try {
        	this.commandSQL =  "select * from user where id = ?";
            this.stmt = this.connection.prepareStatement(this.commandSQL);
            this.stmt.setInt(1, id);
            ResultSet rs = this.stmt.executeQuery();
            
            if(rs.next()) {
            	user.setId(rs.getInt("id_user"));
            	placeVisited.setId(rs.getInt("id_place_visited"));
            	
            	experience.setId(rs.getInt("id"));
            	experience.setContent(rs.getString("content"));
            	experience.setRating(rs.getInt("rating"));
            	experience.setTotalCost(rs.getDouble("total_cost"));
            	experience.setArrivalDay(rs.getDate("arrival_day"));
            	experience.setDepartureDay(rs.getDate("departure_day"));
            	experience.setUser(user);
            	experience.setPlaceVisited(placeVisited);
            }
       
            return experience;
            
        } catch (SQLException e) {
            System.out.println("Error on list experience" + e.getMessage());
            return null;
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error on list experience " + e.getMessage());
            }
        }
    }


    public void update(Experience experience) {
        try {
            this.commandSQL = "Update user SET content = ?, rating = ?, total_cost = ? WHERE id = ?";
            this.stmt = this.connection.prepareStatement(this.commandSQL);
            
            this.stmt.setString(1, experience.getContent());
            this.stmt.setString(2, experience.getContent());
            this.stmt.setDouble(3, experience.getTotalCost());
            this.stmt.setInt(4, (int) experience.getId());
            this.stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error on update experience" + e.getMessage());
        } finally {
            try {
                this.stmt.close();
                System.out.println(this.connection);
            } catch (SQLException e) {
                System.out.println("Error on update" + e.getMessage());
            }
        }
    }

    public void remove(Experience experience) {
        try {
            this.commandSQL = "DELETE FROM experience WHERE id = ?";
            this.stmt = this.connection.prepareStatement(this.commandSQL);
            this.stmt.setInt(1, (int) experience.getId());
            this.stmt.execute();
        } catch(SQLException e) {
            System.out.println("Error on remove experience" + e.getMessage());
        } finally {
            try {
                this.stmt.close();
                System.out.println(this.connection);
            } catch (SQLException e) {
                System.out.println("Error on remove" + e.getMessage());
            }
        }
    }
}
