package controller;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class MySql {

	private final String HOST = "jdbc:mysql://localhost/db_auto_center";
	private final String USERNAME = "root";
	private final String PASSWORD = "bcd127";

	// Connection to DB
	Connection con = null;

	/**
	 * Open connection to DB
	 * @return Connection Object with connection to DB
	 */
	public Connection openConnection()
	{
		try {

			// Load class on memory
			Class.forName("com.mysql.jdbc.Driver");

			con = (Connection) DriverManager.getConnection(HOST,USERNAME,PASSWORD);

		}catch(Exception e) {
			// JOptionPane.showMessageDialog(null,"Não foi possível estabelecer a conexão com o banco de dados\n\nErro: "+e.getMessage(),"Falha na Conexão",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * Close connection to DB
	 * @return true Connection was clodes with successful
	 * @return false Fail to close connection with database
	 */
//	public boolean closeConnection()
//	{
//		if(con != null)
//		{
//			try {
//				con.close();
//				return true;
//			}catch(SQLException e) {
//				// JOptionPane.showInputDialog(null,"Nâo foi possível fechar a conexão com o banco de dados\n\nErro: "+e.getMessage(),"Falha na Conexão",JOptionPane.ERROR_MESSAGE);
//				e.printStackTrace();
//				return false;
//			}
//
//		}
//
//		return true;
//	}

}
