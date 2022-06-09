package br.cefet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.User;

public class UserDAO {
    private Connection connection;
    private String commandSQL;
    private PreparedStatement stmt;

    public UserDAO() {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }

    public void add(User user) {
        this.commandSQL = "insert into user(login, password) values(?,?)";

        try {
            this.stmt = this.connection.prepareStatement(this.commandSQL);

            this.stmt.setString(1, user.getLogin());
            this.stmt.setString(2, user.getPassword());
            this.stmt.execute();
            System.out.println("User " + user.getLogin() + " added with no errors");

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

    public List<User> loadAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            this.stmt = this.connection.prepareStatement("select * from user");
            ResultSet rs = this.stmt.executeQuery();
            
            while(rs.next()) {
                User user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }

            return users;
            
        } catch (SQLException e) {
            System.out.println("Error on list users" + e.getMessage());
            return null;
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error on list users" + e.getMessage());
            }
        }
    }
    
    public User loadUserById(int id) {
    	User user = new User();
    	
        try {
        	this.commandSQL =  "select * from user where id = ?";
            this.stmt = this.connection.prepareStatement(this.commandSQL);
            this.stmt.setInt(1, id);
            ResultSet rs = this.stmt.executeQuery();
            
            if(rs.next()) {
            	user.setId(rs.getInt("id"));
            	user.setLogin(rs.getString("login"));
            	user.setPassword(rs.getString("password"));
            }
       
            return user;
            
        } catch (SQLException e) {
            System.out.println("Error on list user" + e.getMessage());
            return null;
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error on list user " + e.getMessage());
            }
        }
    }


    public void update(User user) {
        try {
            this.commandSQL = "Update user SET login = ?, password = ? WHERE id = ?";
            this.stmt = this.connection.prepareStatement(this.commandSQL);
            
            this.stmt.setString(1, user.getLogin());
            this.stmt.setString(2, user.getPassword());
            this.stmt.setInt(3, (int) user.getId());
            this.stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error on update user" + e.getMessage());
        } finally {
            try {
                this.stmt.close();
                System.out.println(this.connection);
            } catch (SQLException e) {
                System.out.println("Error on update" + e.getMessage());
            }
        }
    }

    public void remove(User user) {
        try {
            this.commandSQL = "DELETE FROM user WHERE id = ?";
            this.stmt = this.connection.prepareStatement(this.commandSQL);
            this.stmt.setInt(1, (int) user.getId());
            this.stmt.execute();
        } catch(SQLException e) {
            System.out.println("Error on remove user" + e.getMessage());
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
