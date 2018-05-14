package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import viewmodel.ContaPacFormatado;
import viewmodel.ParceiroSimplesFormatado;

public class CompanyExpenseDAO {

	/**
	 * Get all bills existing into DB
	 * @return ArrayList<ContaPacFormatado> Containing all bills
	 * @return empty ArrayList<ContaPacFormatado> Fail to attempt get bills into DB
	 */
	public ArrayList<ContaPacFormatado> getBills()
	{
		ArrayList<ContaPacFormatado> bills = new ArrayList<>();

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_conta_pac_formatado";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				ContaPacFormatado bill = new ContaPacFormatado
				(
					rs.getInt("id_conta_pac"),
					rs.getInt("id_categoria_conta_pac"),
					rs.getFloat("valor"),
					rs.getString("vencimento"),
					rs.getString("paga"),
					rs.getString("categoria")
				);

				// Add partner into list
			    bills.add(bill);
			}

			// close connection to DB
			con.close();

			return bills;

		}catch(SQLException e) {
			e.printStackTrace();
			return bills;
		}
	}

	/**
	 * Delete the bill from DB
	 * @param billId Bill's ID
	 * @return true Bill was deleted with successful
	 * @return false Fail on attempt to delete the bill from DB
	 */
	public boolean deleteBill(int billId)
	{
		// Keep the result came from DB
		boolean deleted = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "DELETE FROM tbl_conta_pac WHERE id_conta_pac = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, billId);

			// Execute the query
			int rows = stmt.executeUpdate();

			// Verify if record has succeed on delete
			if(rows == 1) deleted = true;

			// close connection to DB
			con.close();

			return deleted;

		}catch(SQLException e) {
			e.printStackTrace();
			return deleted;
		}
	}

}
