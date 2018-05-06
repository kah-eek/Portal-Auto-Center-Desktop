package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.Authentication;
import controller.MySql;

public class AutenticationDAO {
	
	/**
	 * Check if user's credential exists
	 * @param autenticationObj Object with credential data to be will check into DB
	 * @return true Existent credencial
	 * @return false Not existent credencial
	 */
	public boolean existentCredential(Authentication autenticationObj)
	{
		// Keep final response from DB
		boolean response = false;
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS counter FROM tbl_usuario WHERE usuario = ? AND senha = ?";

		try {
			
			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, autenticationObj.getUsername());
			stmt.setString(2, autenticationObj.getPassword());
				
			// Execute the query
			ResultSet rs = stmt.executeQuery();
			
			// Verify if rs has records inside itself
			if(rs.next())
			{		
				response = rs.getInt("counter") > 0 ? true : false;
			}
			
			// close connection to DB
			con.close();
			
			return response;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return response;
		}
		
	}

}
