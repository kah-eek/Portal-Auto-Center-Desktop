package controller;

import model.AutenticationDAO;

public class Authentication {
	
	// Attributes
	private String username;
	private String password;
	
	// Constructor
	public Authentication(String username, String password)
	{	
		this.username = username;
		this.password = password;
	}
	
	// Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// *****************************************
	
	/**
	 * Check if user's credential exists
	 * @param autenticationObj Object with credential data to be will check into DB
	 * @return true Existent credencial
	 * @return false Not existent credencial
	 */
	public boolean existentCredential(Authentication autenticationObj)
	{
		AutenticationDAO autenticationDAO = new AutenticationDAO();
		return autenticationDAO.existentCredential(autenticationObj);	
	}
	
	
}
