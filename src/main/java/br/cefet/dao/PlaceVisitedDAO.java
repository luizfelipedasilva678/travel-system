package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Country;
import br.cefet.model.PlaceVisited;
import br.cefet.model.User;

public class PlaceVisitedDAO {
	private Connection connection;
	private String commandSQL;
	private PreparedStatement stmt;

	public PlaceVisitedDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}

	public void add(PlaceVisited placeVisited) {
		this.commandSQL = "insert into place_visited(image, name, id_country, id_user) values(?,?,?,?)";

		try {
			this.stmt = this.connection.prepareStatement(this.commandSQL);

			this.stmt.setString(1, placeVisited.getImage());
			this.stmt.setString(2, placeVisited.getName());
			this.stmt.setInt(3, placeVisited.getCountry().getId());
			this.stmt.setInt(4, placeVisited.getUser().getId());
			this.stmt.execute();
			System.out.println("Place visited added with no errors");

		} catch (SQLException e) {
			System.out.println("Error on add" + e.getMessage());
		} finally {
			try {
				this.stmt.close();
				System.out.println(this.connection);
			} catch (SQLException e) {
				System.out.println("Error on free resources" + e.getMessage());
			}
		}
	}

	public List<PlaceVisited> loadAllPlaceVisited() {
		List<PlaceVisited> placesVisited = new ArrayList<PlaceVisited>();
		try {
			this.stmt = this.connection.prepareStatement(
					"SELECT pv.name as place_visited_name, pv.image, u.login, c.name FROM place_visited pv join user u on (u.id = pv.id_user) join country c on (c.id = pv.id_country);");
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setLogin(rs.getString("login"));

				Country country = new Country();
				country.setName(rs.getString("name"));

				PlaceVisited placeVisited = new PlaceVisited();
				placeVisited.setCountry(country);
				placeVisited.setUser(user);
				placeVisited.setName(rs.getString("place_visited_name"));
				placeVisited.setImage(rs.getString("image"));

				placesVisited.add(placeVisited);
			}

			return placesVisited;

		} catch (SQLException e) {
			System.out.println("Error on list places visited" + e.getMessage());
			return null;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error on list places visited" + e.getMessage());
			}
		}
	}

	public List<PlaceVisited> loadAllPlaceVisitedByUserId(int id) {
		List<PlaceVisited> placesVisited = new ArrayList<PlaceVisited>();
		try {
			this.stmt = this.connection.prepareStatement(
					"SELECT pv.name as place_visited_name, pv.id as pv_id, pv.image, u.login, c.name FROM place_visited pv join user u on (u.id = pv.id_user) join country c on (c.id = pv.id_country) where u.id = ?;");
			this.stmt.setInt(1, id);
			ResultSet rs = this.stmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setLogin(rs.getString("login"));

				Country country = new Country();
				country.setName(rs.getString("name"));

				PlaceVisited placeVisited = new PlaceVisited();
				placeVisited.setCountry(country);
				placeVisited.setUser(user);
				placeVisited.setName(rs.getString("place_visited_name"));
				placeVisited.setId(rs.getInt("pv_id"));
				placeVisited.setImage(rs.getString("image"));

				placesVisited.add(placeVisited);
			}

			return placesVisited;

		} catch (SQLException e) {
			System.out.println("Error on list places visited" + e.getMessage());
			return null;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error on list places visited" + e.getMessage());
			}
		}
	}

	public PlaceVisited loadPlaceVisitedById(int id) {
		PlaceVisited placeVisited = new PlaceVisited();
		User user = new User();
		Country country = new Country();

		try {
			this.commandSQL = 
					"SELECT "
					+ "pv.name as place_visited_name, "
					+ "pv.id as pv_id,"
					+ "pv.image, "
					+ "u.login, "
					+ "c.name "
					+ "FROM place_visited pv join user u on (u.id = pv.id_user) "
					+ "join country c on (c.id = pv.id_country) "
					+ "where pv.id = ?;";
			this.stmt = this.connection.prepareStatement(this.commandSQL);
			this.stmt.setInt(1, id);
			ResultSet rs = this.stmt.executeQuery();

			if (rs.next()) {
				user.setLogin(rs.getString("login"));

				country.setName(rs.getString("name"));

				placeVisited.setCountry(country);
				placeVisited.setUser(user);
				placeVisited.setName(rs.getString("place_visited_name"));
				placeVisited.setId(rs.getInt("pv_id"));
				placeVisited.setImage(rs.getString("image"));
			}

			return placeVisited;

		} catch (SQLException e) {
			System.out.println("Error on list place visited " + e.getMessage());
			return null;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Error on list place visited " + e.getMessage());
			}
		}
	}

	public void update(PlaceVisited placeVisited) {
		try {
			this.commandSQL = "Update place_visited SET image = ?, name = ? WHERE id = ?";
			this.stmt = this.connection.prepareStatement(this.commandSQL);

			this.stmt.setString(1, placeVisited.getImage());
			this.stmt.setString(2, placeVisited.getName());
			this.stmt.setInt(3, placeVisited.getId());

			this.stmt.execute();
		} catch (SQLException e) {
			System.out.println("Error on update place visited" + e.getMessage());
		} finally {
			try {
				this.stmt.close();
				System.out.println(this.connection);
			} catch (SQLException e) {
				System.out.println("Error on update" + e.getMessage());
			}
		}
	}

	public void remove(PlaceVisited placeVisited) {
		try {
			this.commandSQL = "DELETE FROM place_visited WHERE id = ?";
			this.stmt = this.connection.prepareStatement(this.commandSQL);
			this.stmt.setInt(1, (int) placeVisited.getId());
			this.stmt.execute();
		} catch (SQLException e) {
			System.out.println("Error on remove place_visited" + e.getMessage());
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
