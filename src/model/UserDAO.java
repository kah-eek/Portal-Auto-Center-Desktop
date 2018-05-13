package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import controller.Employee;
import controller.MySql;
import controller.Partner;
import controller.User;

public class UserDAO {
	
	/**
	 * Get user's informations from DB
	 * @param username User's username
	 * @param password User's password
	 * @return User User object with data came from DB
	 * @return null Fail to get user's informations from DB
	 */
	public User getUser(String username, String password) 
	{
		User user = null;
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_usuario WHERE usuario = ? AND senha = ?";

		try {
			
			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, username);
			stmt.setString(2, password);
				
			// Execute the query
			ResultSet rs = stmt.executeQuery();
			
			// Verify if rs has records inside itself
			if(rs.next())
			{		
			    // Create new User with data came from DB
				user = new User
						(
							rs.getInt("id_usuario"),
							rs.getString("usuario"),
							rs.getString("senha"),
							rs.getString("log"),
							rs.getInt("id_nivel_usuario"),
							rs.getInt("ativo")
						);
			}
			
			// close connection to DB
			con.close();
			
			return user;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return user;
		}
	}
	
	/**
	 * Insert a new user into DB
	 * @param userObj Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertUser(User userObj)
	{
		// Keep the result came from DB
		long recordId = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "INSERT INTO "+
					 "tbl_usuario "+
					 "( "+
						"usuario, "+
					    "senha, "+
					    "id_nivel_usuario"+
					 ") "+
					 "VALUES "+
					 "( "+
						" ?, ?, ? "+
					 ")";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, userObj.getUsuario());
			stmt.setString(2, userObj.getSenha());
			stmt.setInt(3, userObj.getIdNivelUsuario());

			// Execute the query
			ResultSet id = stmt.getGeneratedKeys();

			// Verify if DB returns the last inserted ID
			if(id.next())
			{
				// Keep last inserted id in variable to return it
				recordId = id.getLong(1);
			}

			// close connection to DB
			con.close();

			return recordId;

		}catch(SQLException e) {
			e.printStackTrace();
			return recordId;
		}
	}
	
	/**
	 * Update the user in DB
	 * @param userObj User that will be updated into DB
	 * @return true User was updated with successful
	 * @return false Fail on attempt to updated the user from DB
	 */
	public boolean updateUser(User userObj)
	{
		// Keep the result came from DB
		boolean updated = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "UPDATE "+
					 "tbl_usuario "+
				     "SET "+
					     "usuario = ?, "+
					     "senha = ?, "+
					     "id_nivel_usuario = ?, "+
					     "ativo = ? "+
					  "WHERE id_usuario = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, userObj.getUsuario());
			stmt.setString(2, userObj.getSenha());
			stmt.setInt(3, userObj.getIdNivelUsuario());
			stmt.setInt(4, userObj.getAtivo());
			stmt.setInt(5, userObj.getIdUsuario());
			
			// Execute the query
			int rows = stmt.executeUpdate();

			// Verify if record has succeed on update
			if(rows >= 1) updated = true;

			// close connection to DB
			con.close();

			return updated;

		}catch(SQLException e) {
			e.printStackTrace();
			return updated;
		}
	}

}
