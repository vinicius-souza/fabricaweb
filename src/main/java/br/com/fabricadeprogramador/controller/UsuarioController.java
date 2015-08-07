package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Recebendo Parametros da Tela
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//Instanciando usuario e setando dados
		Usuario usu = new Usuario();
		if(id != null){
			//Convertendo ID para Inteiro
			usu.setId(Integer.parseInt(id));
		}
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		//Persistindo no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		//Cadastra ou Altera
		usuarioDAO.salvar(usu);
		
		//Resposta
		resp.getWriter().print("Salvo!");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Pegando o id da tela
		String id = req.getParameter("id");
		
		//Preencher o objeto usuario
		
		Usuario usu = new Usuario();
		usu.setId(Integer.parseInt(id));
		
		//Excluir
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usu);
		
		//Resposta
		resp.getWriter().print("Excluido!");
	}

}
