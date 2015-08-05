package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

/**
 * Objeto de acesso a dados
 * @author Vinicius Souza
 */

public class UsuarioDAO {
	
	private Connection con;
	
	public UsuarioDAO(){
	//Obtendo uma conexão com o banco
		con = ConexaoFactory.getConnection();
	}
	
	public void cadastrar(Usuario usuario){
		String sql = "insert into usuario (nome, login, senha) values (?, ?, ?)";
		
		//Criando objeto Statment
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			//Executando no banco
			preparador.execute();
			preparador.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		}

}
