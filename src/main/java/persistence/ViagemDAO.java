package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Viagem;

public class ViagemDAO implements DAO<Viagem>{

	private Connection connection;
	
	@Override
	public void inserir(Viagem e) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Viagem> consultarTodos() throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		List<Viagem> viagens = new ArrayList<Viagem>();
		PreparedStatement statement = connection.prepareStatement("SELECT codigo, nome, naturalidade FROM viagem");
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			Viagem viagem = new Viagem();
			viagem.setCodigo(res.getInt("codigo"));
//			viagem.set(res.getString("nome"));
//			motorista.setNaturalidade(res.getString("naturalidade"));
		}
		res.close();
		statement.close();
		connection.close();
		return null;
	}
	@Override
	public void atualizar(Viagem e) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Viagem consultar(Viagem e) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void remover(Viagem e) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
}
