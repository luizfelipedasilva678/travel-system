package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Comment;
import br.cefet.model.Experience;
import br.cefet.model.User;

public class CommentDAO {
	 private Connection connection;
	    private String commandSQL;
	    private PreparedStatement stmt;

	    public CommentDAO() {
	        this.connection = ConnectionFactory.getInstance().getConnection();
	    }

	    public void add(Comment comment) {
	        this.commandSQL = "insert into comment(content, id_user, id_experience) values(?,?,?)";

	        try {
	            this.stmt = this.connection.prepareStatement(this.commandSQL);

	            this.stmt.setString(1, comment.getContent());
	            this.stmt.setInt(2, comment.getUser().getId());
	            this.stmt.setInt(3, comment.getExperience().getId());
	            this.stmt.execute();
	            System.out.println("Comment added with no errors");

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

	    public List<Comment> loadAllComments() {
	        List<Comment> comments = new ArrayList<Comment>();
	        
	        try {
	            this.stmt = this.connection.prepareStatement("select * from comment");
	            ResultSet rs = this.stmt.executeQuery();
	            
	            while(rs.next()) {
	                User user = new User();
	                user.setId(rs.getInt("id_user"));
	                
	                Experience experience = new Experience();
	                experience.setId(rs.getInt("id_experience"));
	                
	                Comment comment = new Comment();
	                comment.setContent(rs.getString("content"));
	                comment.setUser(user);
	                comment.setExperience(experience);
	               
	                comments.add(comment);
	            }

	            return comments;
	            
	        } catch (SQLException e) {
	            System.out.println("Error on list comments" + e.getMessage());
	            return null;
	        } finally {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                System.out.println("Error on list comments" + e.getMessage());
	            }
	        }
	    }
	    
	    public void remove(Comment comment) {
	        try {
	            this.commandSQL = "DELETE FROM comment WHERE id = ?";
	            this.stmt = this.connection.prepareStatement(this.commandSQL);
	            this.stmt.setInt(1, (int) comment.getId());
	            this.stmt.execute();
	        } catch(SQLException e) {
	            System.out.println("Error on remove comment" + e.getMessage());
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
