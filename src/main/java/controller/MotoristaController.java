package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Motorista;
import persistence.MotoristaDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cadastro/motorista")
public class MotoristaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public MotoristaController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String naturalidade = request.getParameter("naturalidade");
		String comando = request.getParameter("botao");
		MotoristaDAO DAO = new MotoristaDAO();
		Motorista motorista = new Motorista();
		List<Motorista> motoristas = new ArrayList<Motorista>();
		
		
		if(comando.contains("Inserir")) {
			motorista.setCodigo(codigo);
			motorista.setNome(nome);
			motorista.setNaturalidade(naturalidade);
			try {
				DAO.inserir(motorista);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("motorista.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(comando.contains("Atualizar")) {
			motorista.setCodigo(codigo);
			motorista.setNome(nome);
			motorista.setNaturalidade(naturalidade);
			try {
				DAO.atualizar(motorista);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(comando.contains("Consultar")) {
			try {
				motorista.setCodigo(codigo);
				motorista = DAO.consultar(motorista);
				request.setAttribute("motorista", motorista);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista.jsp");
				dispatcher.forward(request, response);
			} 
			catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				request.setAttribute("motorista", motorista);
				RequestDispatcher dispatcher = request.getRequestDispatcher("motorista.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		if(comando.contains("Excluir")) {

			try {
				motorista.setCodigo(codigo);
				DAO.remover(motorista);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
	}

}
