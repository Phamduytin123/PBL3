package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOInterface<T> {
	
	public int insert(T t) throws SQLException, ClassNotFoundException ;
	
	public int delete(T t) throws SQLException, ClassNotFoundException ;
	
	public int update(T t) throws SQLException, ClassNotFoundException ;
	
	public ArrayList<T> selectAll() throws SQLException, ClassNotFoundException ;
	
	public T selectByID(String t) throws SQLException, ClassNotFoundException ;
	
	public ArrayList<T> selectByCondition(String condition) throws SQLException, ClassNotFoundException ;
}
