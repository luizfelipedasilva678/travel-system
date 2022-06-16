package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Country;

public class CountryDAO {
	private Connection connection;
    private PreparedStatement stmt;

    public CountryDAO () {
        this.connection = ConnectionFactory.getInstance().getConnection();
    }

    public List<Country> loadAllCountries() {
        List<Country> countries = new ArrayList<Country>();
        try {
            this.stmt = this.connection.prepareStatement("select * from country");
            ResultSet rs = this.stmt.executeQuery();
            
            while(rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setName(rs.getString("name"));
                
                countries.add(country);
            }

            return countries;
            
        } catch (SQLException e) {
            System.out.println("Error on list countries" + e.getMessage());
            return null;
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error on list countries" + e.getMessage());
            }
        }
    }
}
