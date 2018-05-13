package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import controller.Subscription;

public class SubscriptionDAO {

	/**
	 * Get profit amount got on partner's subscriptions
	 * @return int Profit amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public float getAllProfitValue()
	{
		int response = -1;
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_receita_plano_contratacao";

		try {
			
			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
				
			// Execute the query
			ResultSet rs = stmt.executeQuery();
			
			// Verify if rs has records inside itself
			if(rs.next())
			{		
			    response = rs.getInt("receita");
			}
			
			// close connection to DB
			con.close();
			
			return response;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return response;
		}
	}
	
	/**
	 * Get all existing plans into DB
	 * @return ArraLis<Subscription> List containing all plans existing into DB 
	 * @return ArraLis<Subscription> Empty Fail in try to get list containing all plans existing into DB 
	 */
	public ArrayList<Subscription> getPartnerPlans()
	{
		// Keep the plans
		ArrayList<Subscription> plans = new ArrayList<>();
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_plano_contratacao";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				//	Create plan object with data came from DB
				Subscription plan = new Subscription
				(
					rs.getInt("id_plano_contratacao"),
					rs.getString("plano"),
					rs.getFloat("valor"),
					rs.getString("descricao")
				);
				
				// Add plan into list
				plans.add(plan);
			}

			// close connection to DB
			con.close();

			return plans;

		}catch(SQLException e) {
			e.printStackTrace();
			return plans;
		}
	}
	
}
