package controller;

import model.UserDAO;

public class User {
	
	// Attributes
	private int idUsuario;
	private String usuario;
	private String senha;
	private String log;
	private int idNivelUsuario;
	private int ativo;
	
	
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}

	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	// Constructor
	public User(int idUsuario, String usuario, String senha, String log, int idNivelUsuario, int ativo)
	{
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.senha = senha;
		this.log = log;
		this.idNivelUsuario = idNivelUsuario;
		this.ativo = ativo;
	}
	public User(String usuario, String senha, int idNivelUsuario)
	{
		this.usuario = usuario;
		this.senha = senha;
		this.idNivelUsuario = idNivelUsuario;
	}
	public User(int idUsuario, String senha)
	{
		this.idUsuario = idUsuario;
		this.senha = senha;
	}
	public User(int idUsuario, String usuario, String senha, int idNivelUsuario, int ativo)
	{
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.senha = senha;
		this.idNivelUsuario = idNivelUsuario;
		this.ativo = ativo;
	}
	
	/**
	 * Get user's informations from DB
	 * @param username User's username
	 * @param password User's password
	 * @return User User object with data came from DB
	 * @return null Fail to get user's informations from DB
	 */
	static public User getUser(String username, String password) 
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.getUser(username, password);
	}
	
	/**
	 * Update the user's password in DB
	 * @param userObj User that will be updated into DB
	 * @return true User's password was updated with successful
	 * @return false Fail on attempt to updated the user's password from DB
	 */
	public boolean updatePassword(User userObj)
	{
		return new UserDAO().updatePassword(userObj);
	}
	
	/**
	 * Insert a new user into DB
	 * @param userObj Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertUser(User userObj)
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.insertUser(userObj);
	}
	
	/**
	 * Update the user in DB
	 * @param userObj User that will be updated into DB
	 * @return true User was updated with successful
	 * @return false Fail on attempt to updated the user from DB
	 */
	public boolean updateUser(User userObj)
	{
		UserDAO userDAO = new UserDAO();
		return userDAO.updateUser(userObj);
	}

}
