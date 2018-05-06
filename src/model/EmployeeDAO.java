package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.MySql;
import controller.Employee;

public class EmployeeDAO {
	
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
