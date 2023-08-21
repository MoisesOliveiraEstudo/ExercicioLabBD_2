package persistence;

import java.sql.SQLException;
import java.util.List;

public interface DAO<E> {

	public void inserir(E e) throws SQLException, ClassNotFoundException;
	public void atualizar(E e) throws SQLException, ClassNotFoundException;
	public void remover(E e) throws SQLException, ClassNotFoundException;
	public E consultar(E e) throws SQLException, ClassNotFoundException;
	public List<E> consultarTodos() throws SQLException, ClassNotFoundException;
}
