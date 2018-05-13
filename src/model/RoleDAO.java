package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import controller.Role;
import controller.State;

public class RoleDAO {
	
	/**
	 * Get all existing roles into DB
	 * @return ArraLis<Role> List containing all roles existing into DB 
	 * @return ArraLis<Role> Empty Fail in try to get list containing all roles existing into DB 
	 */
	public ArrayList<Role> getRoles()
	{
		// Keep the roles
		ArrayList<Role> roles = new ArrayList<>();
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_cargo_funcionario_pac";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				//	Create plan object with data came from DB
				Role role = new Role
				(
					rs.getInt("id_cargo_funcionario_pac"),
					rs.getString("cargo")
				);
				
				// Add plan into list
				roles.add(role);
			}

			// close connection to DB
			con.close();

			return roles;

		}catch(SQLException e) {
			e.printStackTrace();
			return roles;
		}
	}

}
