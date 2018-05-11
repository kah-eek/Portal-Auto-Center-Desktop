package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import controller.MySql;
import controller.Partner;
import viewmodel.ParceiroSimplesFormatado;

public class PartnerDAO {

	/**
	 * Get all partners existents into DB
	 * @return ArrayList<ParceiroSimplesFormatado> Containing all partners
	 * @return empty ArrayList<ParceiroSimplesFormatado> Fail to attempt get partners into DB
	 */
	public ArrayList<ParceiroSimplesFormatado> getPartners()
	{
		ArrayList<ParceiroSimplesFormatado> partners = new ArrayList<>();

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT * FROM view_parceiro_simples_formatado";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			while(rs.next())
			{
				ParceiroSimplesFormatado parceiroSimplesFormatado = new ParceiroSimplesFormatado
				(
					rs.getInt("id_parceiro"),
					rs.getString("nome_fantasia"),
					rs.getString("razao_social"),
					rs.getString("cnpj"),
					rs.getInt("id_endereco"),
					rs.getString("ativo"),
					rs.getString("socorrista"),
					rs.getString("email"),
					rs.getString("telefone"),
					rs.getString("foto_perfil"),
					rs.getString("celular"),
					rs.getString("log_parceiro"),
					rs.getInt("id_usuario"),
					rs.getInt("id_plano_contratacao"),
					rs.getString("plano")
				);

				// Add partner into list
			    partners.add(parceiroSimplesFormatado);
			}

			// close connection to DB
			con.close();

			return partners;

		}catch(SQLException e) {
			e.printStackTrace();
			return partners;
		}
	}

	/**
	 * Get partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public int getPartnersAmount()
	{
		int response = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS qtd_parceiros FROM tbl_parceiro";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			if(rs.next())
			{
			    response = rs.getInt("qtd_parceiros");
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
	 * Get active partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public int getActivePartnersAmount()
	{
		int response = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS ativos FROM tbl_parceiro WHERE ativo = 1";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			if(rs.next())
			{
			    response = rs.getInt("ativos");
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
	 * Get inactive partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	public int getInactivePartnersAmount()
	{
		int response = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "SELECT COUNT(*) AS inativos FROM tbl_parceiro WHERE ativo = 0";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);

			// Execute the query
			ResultSet rs = stmt.executeQuery();

			// Verify if rs has records inside itself
			if(rs.next())
			{
			    response = rs.getInt("inativos");
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
	 * Delete the partner from DB
	 * @param partnerId Partner's ID
	 * @return true Partner was deleted with successful
	 * @return false Fail on attempt to delete the partner from DB
	 */
	public boolean deletePartner(int partnerId)
	{
		// Keep the result came from DB
		boolean deleted = false;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "DELETE FROM tbl_parceiro WHERE id_parceiro = ?";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, partnerId);

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
	 * Insert a new partner into DB
	 * @param partnerObj Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertPartner(Partner partnerObj)
	{
		// Keep the result came from DB
		long recordId = -1;

		// Open connection to DB
		MySql db = new MySql();
		Connection con = db.openConnection();

		// Select into DB
		String sql = "INSERT INTO "+
						"tbl_parceiro "+
					"("+
						"nome_fantasia, "+
					    "razao_social, "+
					    "cnpj, "+
					    "id_endereco, "+
					    "socorrista, "+
					    "email, "+
					    "telefone, "+
					    "foto_perfil, "+
					    "celular, "+
					    "id_usuario, "+
					    "id_plano_contratacao "+
					") "+
					"VALUES "+
					"( "+
						"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"+
					")";

		try {

			// Create the statement
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, partnerObj.getNomeFantasia());
			stmt.setString(2, partnerObj.getRazaoSocial());
			stmt.setString(3, partnerObj.getCnpj());
			stmt.setInt(4, partnerObj.getIdEndereco());
			stmt.setInt(5, partnerObj.getSocorrista());
			stmt.setString(6, partnerObj.getEmail());
			stmt.setString(7, partnerObj.getTelefone());
			stmt.setString(8, partnerObj.getFotoPerfil());
			stmt.setString(9, partnerObj.getCelular());
			stmt.setInt(10, partnerObj.getIdUsuario());
			stmt.setInt(11, partnerObj.getIdPlanoContratacao());

			// Execute the query
			ResultSet id = stmt.getGeneratedKeys();

			// Verify if DB returns the last inserted ID
			if(id.next())
			{
				// Keep last inserted id in variable to return it
				recordId = id.getLong(1);
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
