package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;
import model.Viagem;

public class MotoristaDAO implements DAO<Motorista>{

	private Connection connection;
	
	
	@Override
	public void inserir(Motorista motorista) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO motorista (codigo,nome,naturalidade)"
				+ " VALUES (?,?,?)");
		statement.setInt(1, motorista.getCodigo());
		statement.setString(2, motorista.getNome());
		statement.setString(3, motorista.getNaturalidade());
		statement.execute();
		statement.close();
		connection.close();
		
	}
	
	@Override
	public void atualizar(Motorista motorista) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("UPDATE motorista SET "
				+ "nome = ?, naturalidade = ? WHERE codigo = ?");
		statement.setString(1, motorista.getNome());
		statement.setString(2, motorista.getNaturalidade());
		statement.setInt(3, motorista.getCodigo());
		statement.execute();
		statement.close();
		connection.close();
	}
	@Override
	public Motorista consultar(Motorista motorista) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("SELECT codigo, nome, naturalidade FROM "
				+ "motorista WHERE codigo = ?");
		statement.setInt(1, motorista.getCodigo());
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			motorista.setCodigo(res.getInt("codigo"));
			motorista.setNome(res.getString("nome"));
			motorista.setNaturalidade(res.getString("naturalidade"));
		}
		res.close();
		statement.close();
		connection.close();
		return motorista;
	}
	@Override
	public List<Motorista> consultarTodos() throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		List<Motorista> motoristas = new ArrayList<Motorista>();
		PreparedStatement statement = connection.prepareStatement("SELECT codigo, nome, naturalidade FROM motorista");
		ResultSet res = statement.executeQuery();
		while(res.next()) {
			Motorista motorista = new Motorista();
			motorista.setCodigo(res.getInt("codigo"));
			motorista.setNome(res.getString("nome"));
			motorista.setNaturalidade(res.getString("naturalidade"));
			motoristas.add(motorista);
		}
		res.close();
		statement.close();
		connection.close();
		return motoristas;
	}
	
	@Override
	public void remover(Motorista motorista) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM motorista WHERE codigo = ?");
		statement.setInt(1, motorista.getCodigo());
		statement.execute();
		statement.close();
		connection.close();
		
	}
	
}
