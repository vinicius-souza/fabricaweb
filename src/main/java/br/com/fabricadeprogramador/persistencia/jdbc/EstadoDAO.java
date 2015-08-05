package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;

public class EstadoDAO {
	
	private Connection con;
	
	public EstadoDAO(){
	//Obtendo uma conexão com o banco
		con = ConexaoFactory.getConnection();
	}

	public void cadastrar(Estado estado){
		String sql = "insert into estado (nome, UF) values (?, ?)";
		
		//Criando objeto Statment
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			
			preparador.setString(1, estado.getNome());
			preparador.setString(2, estado.getUF());
			//Executando no banco
			preparador.execute();
			preparador.close();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		}
}
