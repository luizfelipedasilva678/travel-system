package br.cefet.dao;
import java.sql.*;
import br.cefet.model.*;

public class UsuarioDao {
	private Connection connection;
	private String commandSql;
	private PreparedStatement stmt;
	
	public UsuarioDao() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public void adiciona (Usuario usuario) {
		this.commandSql = "insert into usuario(login, senha) values (?, ?)";
		
		try {
			this.stmt = this.connection.prepareStatement(this.commandSql);
			
			this.stmt.setString(1, usuario.getLogin());
			this.stmt.setString(2, usuario.getSenha());
			this.stmt.execute();			
			
			System.out.println("Adicionado com sucesso");
			
		} catch(SQLException e) {
			System.out.println("Erro ao adicionar" + e.getMessage());
		} finally {
			try {
				this.stmt.close();				
			} catch(SQLException e) {
				System.out.println("Erro ao fechar conexao" + e.getMessage());
			}
			
		}
	}
}
