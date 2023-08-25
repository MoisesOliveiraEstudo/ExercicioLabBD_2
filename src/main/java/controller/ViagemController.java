package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Motorista;
import model.Onibus;
import persistence.MotoristaDAO;
import persistence.OnibusDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cadastro/viagem")
public class ViagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViagemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MotoristaDAO motoristaDAO = new MotoristaDAO();
		OnibusDAO onibusDAO = new OnibusDAO();
		List<Motorista> motoristas = new ArrayList<Motorista>();
		List<Onibus> onibuses = new ArrayList<Onibus>();
		try {
			motoristas = motoristaDAO.consultarTodos();
			onibuses = onibusDAO.consultarTodos();
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			request.setAttribute("motoristas", motoristas);
			request.setAttribute("onibuses", onibuses);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/viagem.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String comando = request.getParameter("botao");
//		String placa = request.getParameter("onibus");
//		int motoristaCodigo = Integer.parseInt(request.getParameter("motorista"));
//		Onibus onibus = new Onibus();
//		Motorista motorista = new Motorista();
//		
//		if(comando.contains("Inserir")) {
//			onibus.setPlaca(placa);
////			motorista.setCodigo();
////			onibus.setAno(ano);
////			onibus.setDescricao(descricao);
//			try {
////				DAO.inserir(onibus);
//			} catch (ClassNotFoundException | SQLException e) {
//				request.setAttribute("erro", e.getMessage());
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/onibus.jsp");
//				dispatcher.forward(request, response);
//			}
//		}
//	System.out.println(onibus);
	}

}
