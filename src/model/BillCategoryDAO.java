package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.BillCategory;
import controller.MySql;
import controller.State;

public class BillCategoryDAO {

	/**
	 * Get all existing bill's category into DB
	 * @return ArraLis<BillCategory> List containing all bill's category existing into DB
	 * @return ArraLis<BillCategory> Empty Fail in try to get list containing all bill's category existing into DB
	 */
	public ArrayList<BillCategory> getBillCategories()
	{
		// Keep the plans
		ArrayList<BillCategory> categories = new ArrayList<>();

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_categoria_conta_pac";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				//	Create plan object with data came from DB
				BillCategory category = new BillCategory
				(
					rs.getInt("id_categoria_conta_pac"),
					rs.getString("categoria")
				);

				// Add plan into list
				categories.add(category);
			}

			// close connection to DB
			con.close();

			return categories;

		}catch(SQLException e) {
			e.printStackTrace();
			return categories;
		}
	}

}
