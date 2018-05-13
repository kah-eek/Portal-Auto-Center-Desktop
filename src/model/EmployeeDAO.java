package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import viewmodel.FuncionarioSimplesFormatado;
import controller.Employee;

public class EmployeeDAO {
	
	/**
	 * Get employees' basic informations from DB
	 * @return ArrayList<FuncionarioSimplesFormatado> List containing all of employees existing into DB
	 * @return ArrayList<FuncionarioSimplesFormatado> Empty list. Fail to get employees' basic informations from DB
	 */
	public ArrayList<FuncionarioSimplesFormatado> getEmployees()
	{
		ArrayList<FuncionarioSimplesFormatado> employees = new ArrayList<>();
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_funcionario_simples_formatado";

		try {
			
			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
				
			// Execute the query
			ResultSet rs = stmt.executeQuery();
			
			// Verify if rs has records inside itself
			while(rs.next())
			{		
				FuncionarioSimplesFormatado employee = new FuncionarioSimplesFormatado
				(
					rs.getInt("id_funcionario_pac"),
					rs.getString("nome"),
					rs.getInt("id_cargo_funcionario_pac"),
					rs.getString("data_adimissao"),
					rs.getString("email"),
					rs.getString("celular"),
					rs.getString("cargo")
				);
				
				employees.add(employee);
			}
			
			// close connection to DB
			con.close();
			
			return employees;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return employees;
		}
	}
	
	/**
	 * Delete the employee from DB
	 * @param employeeId Employee's ID
	 * @return true Employee was deleted with successful
	 * @return false Fail on attempt to delete the employee from DB
	 */
	public boolean deleteEmployee(int employeeId)
	{
		// Keep the result came from DB
		boolean deleted = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "DELETE FROM tbl_funcionario_pac WHERE id_funcionario_pac = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, employeeId);

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
	 * Get employee's informations from DB
	 * @param userId Employee's user id to find it in DB
	 * @return Employee Employee object with employee's data came from DB
	 * @return null Fail to get employee's informations from DB
	 */
	public Employee getEmployeesInformation(int userId)
	{
		Employee employee = null;
		
		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM tbl_funcionario_pac WHERE id_usuario = ?";

		try {
			
			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setInt(1, userId);
				
			// Execute the query
			ResultSet rs = stmt.executeQuery();
			
			// Verify if rs has records inside itself
			if(rs.next())
			{		
				employee = new Employee();
								
				employee.setNome(rs.getString("nome"));
				employee.setCpf(rs.getInt("cpf"));
				employee.setRg(rs.getInt("rg"));
				employee.setIdEndereco(rs.getInt("id_endereco"));
				employee.setDtNascimento(rs.getString("dt_nascimento"));
				employee.setIdCargoFuncionarioPac(rs.getInt("id_cargo_funcionario_pac"));
				employee.setSalario(rs.getFloat("salario"));
				employee.setSexo(rs.getString("sexo").charAt(0));
				employee.setCelular(rs.getString("celular"));
				employee.setEmail(rs.getString("email"));
				employee.setFoto(rs.getString("foto"));
				employee.setCnh(rs.getString("cnh"));
				employee.setPis(rs.getString("pis"));
				employee.setCertificadoReservista(rs.getString("certificado_reservista"));
				employee.setIdUsuario(rs.getInt("id_usuario"));
			}
			
			// close connection to DB
			con.close();
			
			return employee;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return employee;
		}
	}

}
