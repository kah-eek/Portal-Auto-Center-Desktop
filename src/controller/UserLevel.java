package controller;

import java.util.ArrayList;

import model.UserLevelDAO;

public class UserLevel {

	private int idNivelUsuario;
	private String nivel;
	
	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}
	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	// Default constructor
	public UserLevel(int idNivelUsuario, String nivel)
	{
		this.idNivelUsuario = idNivelUsuario;
		this.nivel = nivel;
	}
	// ************************************************
	
	/**
	 * Get all existing user's levels into DB
	 * @return ArraLis<UserLevel> List containing all user's levels existing into DB 
	 * @return ArraLis<UserLevel> Empty Fail in try to get list containing all user's levels existing into DB 
	 */
	static public ArrayList<UserLevel> getUserLevels()
	{
		UserLevelDAO userLevelDAO = new UserLevelDAO();
		return userLevelDAO.getUserLevels();
	}
}
