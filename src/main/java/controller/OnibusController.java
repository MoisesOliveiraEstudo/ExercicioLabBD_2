package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Onibus;
import persistence.OnibusDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cadastro/onibus")
public class OnibusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnibusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String placa = request.getParameter("placa");
		String marca = request.getParameter("marca");
		int ano = Integer.parseInt(request.getParameter("ano"));
		String descricao = request.getParameter("descricao");
		String comando = request.getParameter("botao");
		OnibusDAO DAO = new OnibusDAO();
		Onibus onibus = new Onibus();
		
		
		if(comando.contains("Inserir")) {
			onibus.setPlaca(placa);
			onibus.setMarca(marca);
			onibus.setAno(ano);
			onibus.setDescricao(descricao);
			try {
				DAO.inserir(onibus);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/onibus.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(comando.contains("Atualizar")) {
			onibus.setPlaca(placa);
			onibus.setMarca(marca);
			onibus.setAno(ano);
			onibus.setDescricao(descricao);
			try {
				DAO.atualizar(onibus);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista.jsp");
				dispatcher.forward(request, response);
			}
		}
		if(comando.contains("Consultar")) {
			try {
				onibus.setPlaca(placa);
				onibus = DAO.consultar(onibus);
				request.setAttribute("onibus", onibus);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/onibus.jsp");
				dispatcher.forward(request, response);
			} 
			catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				//request.setAttribute("onibus", motorista);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/onibus.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		if(comando.contains("Excluir")) {

			try {
				onibus.setPlaca(placa);
				DAO.remover(onibus);
			} catch (ClassNotFoundException | SQLException e) {
				request.setAttribute("erro", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/motorista.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
	}

}
