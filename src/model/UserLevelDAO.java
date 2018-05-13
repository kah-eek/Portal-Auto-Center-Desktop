package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import controller.UserLevel;

public class UserLevelDAO {
	
	/**
	 * Get all existing user's levels into DB
	 * @return ArraLis<UserLevel> List containing all user's levels existing into DB 
	 * @return ArraLis<UserLevel> Empty Fail in try to get list containing all user's levels existing into DB 
	 */
	public ArrayList<UserLevel> getUserLevels()
	{
		// Keep the plans
		ArrayList<UserLevel> levels = new ArrayList<>();
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_nivel_usuario";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				// Create level object with data came from DB
				UserLevel level = new UserLevel
				(
					rs.getInt("id_nivel_usuario"),
					rs.getString("nivel")
				);
				
				// Add plan into list
				levels.add(level);
			}

			// close connection to DB
			con.close();

			return levels;

		}catch(SQLException e) {
			e.printStackTrace();
			return levels;
		}
	}
	
	

}
