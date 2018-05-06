package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.Employee;
import controller.MySql;
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

}
