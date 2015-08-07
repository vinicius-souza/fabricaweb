package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Estado;
import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.EstadoDAO;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/estadocontroller.do")
public class EstadoController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Recebendo Parametros da Tela
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String uf = req.getParameter("uf");

		// Instanciando usuario e setando dados
		Estado est = new Estado();
		if(id != null){
			//Convertendo ID para Inteiro
			est.setId(Integer.parseInt(id));
		}
		est.setNome(nome);
		est.setUF(uf);

		// Persistindo no banco
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(est);

		// Resposta
		resp.getWriter().print("Salvo");
	}

}
