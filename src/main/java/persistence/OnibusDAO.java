package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Motorista;
import model.Onibus;

public class OnibusDAO implements DAO<Onibus>{

	Connection connection;
	
	@Override
	public void inserir(Onibus onibus) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO onibus(placa,marca,ano,descricao)"
				+ " VALUES (?,?,?,?)");
		statement.setString(1, onibus.getPlaca());
		statement.setString(2, onibus.getMarca());
		statement.setInt(3, onibus.getAno());
		statement.setString(4, onibus.getDescricao());
		statement.execute();
		statement.close();
		connection.close();		
	}
	
	@Override
	public void atualizar(Onibus onibus) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("UPDATE onibus SET "
				+ "marca = ?, ano = ?, descricao = ? WHERE placa = ?");
		statement.setString(1, onibus.getMarca());
		statement.setInt(2, onibus.getAno());
		statement.setString(3, onibus.getDescricao());
		statement.setString(4, onibus.getPlaca());
		statement.execute();
		statement.close();
		connection.close();
	}
	
	@Override
	public Onibus consultar(Onibus onibus) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("SELECT placa, marca, ano, descricao FROM "
				+ "motorista WHERE codigo = ?");
		statement.setString(1, onibus.getPlaca());
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			onibus.setPlaca(res.getString("placa"));
			onibus.setMarca(res.getString("marca"));
			onibus.setAno(res.getInt("ano"));
		}
		res.close();
		statement.close();
		connection.close();
		return onibus;
	}
	
	@Override
	public List<Onibus> consultarTodos() throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		List<Onibus> onibuses = new ArrayList<Onibus>();
		PreparedStatement statement = connection.prepareStatement("SELECT placa, marca, ano, descricao FROM onibus");
		ResultSet res = statement.executeQuery();
		while(res.next()) {
			Onibus onibus = new Onibus();
			onibus.setPlaca(res.getString("placa"));
			onibus.setMarca(res.getString("marca"));
			onibus.setAno(res.getInt("ano"));
			onibus.setDescricao(res.getString("descricao"));
			onibuses.add(onibus);
		}
		res.close();
		statement.close();
		connection.close();
		return onibuses;
	}
	
	@Override
	public void remover(Onibus onibus) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = connection.prepareStatement("DELETE FROM onibus WHERE placa = ?");
		statement.setString(1, onibus.getPlaca());
		statement.execute();
		statement.close();
		connection.close();
		
	}
}

