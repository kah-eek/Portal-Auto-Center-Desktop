package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import controller.State;

public class StateDAO {
	
	/**
	 * Get all existing states into DB
	 * @return ArraLis<State> List containing all states existing into DB 
	 * @return ArraLis<State> Empty Fail in try to get list containing all states existing into DB 
	 */
	public ArrayList<State> getStates()
	{
		// Keep the plans
		ArrayList<State> states = new ArrayList<>();
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_estado";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				//	Create plan object with data came from DB
				State state = new State
				(
					rs.getInt("id_estado"),
					rs.getString("estado")
				);
				
				// Add plan into list
				states.add(state);
			}

			// close connection to DB
			con.close();

			return states;

		}catch(SQLException e) {
			e.printStackTrace();
			return states;
		}
	}

}
