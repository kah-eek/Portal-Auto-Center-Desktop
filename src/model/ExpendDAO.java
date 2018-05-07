package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;

public class ExpendDAO {
	
	/**
	 * Get all company expend's value
	 * @return float Expend's value
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public float getAllExpendValue()
	{
		float response = -1;
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_total_despesas_internas";

		try {
			
			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);;
				
			// Execute the query
			ResultSet rs = stmt.executeQuery();
			
			// Verify if rs has records inside itself
			if(rs.next())
			{		
				response = rs.getFloat("total_despesa");
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
