package model;

import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import controller.CompanyExpense;
import controller.Employee;
import controller.MySql;
import controller.User;
import viewmodel.ContaPacFormatado;
import viewmodel.FuncionarioDetalhado;
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
	 * Update the company's bill in DB
	 * @param CompanyExpense billObj that will be updated into DB
	 * @return true Compnay's bill was updated with successful
	 * @return false Fail on attempt to updated the compnay's bill from DB
	 */
	public boolean updateBill(CompanyExpense billObj)
	{
		// Keep the result came from DB
		boolean updated = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "UPDATE "
					+ "tbl_conta_pac "
					+ "SET "
						+ "id_categoria_conta_pac = ?, "
						+ "valor = ? ,"
						+ "vencimento = ?, "
						+ "paga = ? "
					+"WHERE id_conta_pac = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setInt(1, billObj.getIdCategoriaContaPac());
			stmt.setFloat(2, billObj.getValor());
			stmt.setString(3, billObj.getVencimento());
			stmt.setInt(4, billObj.getPaga());
			stmt.setInt(5, billObj.getIdContaPac());

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

	/**
	 * Get all informations about one company's bill
	 * @param billId Company bill's ID that it will be achieve into DB
	 * @return CompanyExpense CompanyExpense containing all data
	 * @return null Fail in try to get the company bill's data into DB
	 */
	public CompanyExpense getFullBillById(int billId)
	{
		CompanyExpense companyExpense = null;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_conta_pac WHERE id_conta_pac = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, billId);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				companyExpense = new CompanyExpense
				(
						rs.getInt("id_conta_pac"),
						rs.getInt("id_categoria_conta_pac"),
						rs.getFloat("valor"),
						rs.getString("vencimento"),
						rs.getInt("paga"),
						rs.getString("log_conta_pac")
				);
			}

			// close connection to DB
			con.close();

			return companyExpense;

		}catch(SQLException e) {
			e.printStackTrace();
			return companyExpense;
		}
	}

	/**
	 * Insert a new company's bill into DB
	 * @param CompanyExpense Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertBill(CompanyExpense billObj)
	{
		// Keep the result came from DB
		long recordId = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "INSERT INTO "+
					 "tbl_conta_pac "+
					 "("+
					 "id_categoria_conta_pac, "+
					 "valor, "+
					 "vencimento, "+
					 "paga, "+
					 "log_conta_pac"+
					 ") "+
					 "VALUES (?,?,?,?,now())";
		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, billObj.getIdCategoriaContaPac());
			stmt.setFloat(2, billObj.getValor());
			stmt.setString(3, billObj.getVencimento());
			stmt.setInt(4, billObj.getPaga());

			// Execute query
			int rows = stmt.executeUpdate();

			// Verify how many records was affected
			if(rows > 0)
			{
				// Execute the query
				ResultSet id = stmt.getGeneratedKeys();

				// Verify if DB returns the last inserted ID
				if(id.next())
				{
					// Keep last inserted id in variable to return it
					recordId = id.getLong(1);

				}
			}

			// close connection to DB
			con.close();

			return recordId;

		}catch(SQLException e) {
			e.printStackTrace();
			return recordId;
		}
	}

}
