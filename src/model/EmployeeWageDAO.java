package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import viewmodel.PagamentoFuncionarioDetalhadoFormatado;

public class EmployeeWageDAO {
	
	/**
	 * Get all employees' wage existing into DB
	 * @return ArrayList<PagamentoFuncionarioDetalhadoFormatado> Containing all employees' wage
	 * @return empty ArrayList<PagamentoFuncionarioDetalhadoFormatado> Fail to attempt get employees' wage into DB
	 */
	public ArrayList<PagamentoFuncionarioDetalhadoFormatado> getAllEmployeeWage()
	{
		ArrayList<PagamentoFuncionarioDetalhadoFormatado> employeesWage = new ArrayList<>();

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_pagamento_funcionario_detalhado_formatado";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				PagamentoFuncionarioDetalhadoFormatado wage = new PagamentoFuncionarioDetalhadoFormatado
				(
					rs.getInt("id_pagamento_funcionario_pac"), 
					rs.getInt("id_funcionario_pac"), 
					rs.getString("pago"),
					rs.getString("mes_pagamento"), 
					rs.getString("data_pagamento_realizado"), 
					rs.getString("nome"),
					rs.getFloat("salario")
				);

				// Add partner into list
				employeesWage.add(wage);
			}

			// close connection to DB
			con.close();

			return employeesWage;

		}catch(SQLException e) {
			e.printStackTrace();
			return employeesWage;
		}
	}

}
