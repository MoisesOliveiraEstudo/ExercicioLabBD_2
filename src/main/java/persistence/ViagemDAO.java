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
	public void inserir(Viagem viagem) throws SQLException, ClassNotFoundException {
		connection = DBConnection.connect();
		PreparedStatement statement = 
				connection.prepareStatement("INSERT INTO viagem(codigo, onibus, motorista,"
						+ "hora_saida, hora_chegada, partida, destino) VALUES (?,?,?,?,?,?,?)");
		statement.setInt(1, viagem.getCodigo());
		statement.setString(2, viagem.getOnibus().getPlaca());
		statement.setInt(3, viagem.getMotorista().getCodigo());
		statement.setInt(4, viagem.getHoraSaida());
		statement.setInt(5, viagem.getHoraChegada());
		statement.setString(6, viagem.getPartida());
		statement.setString(7, viagem.getDestino());
		statement.execute();
		statement.close();
		connection.close();
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
	public List<Viagem> consultarDescricao() throws SQLException, ClassNotFoundException{
		connection = DBConnection.connect();
		PreparedStatement query = connection.prepareStatement("SELECT * FROM v_descricao");
		return null;
	}
	
}
