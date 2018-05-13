package controller;

import java.util.ArrayList;

import model.RoleDAO;

public class Role {
	
	private int idCargoFuncionarioPac;
	private String cargo;
	
	// Default constructor
	public Role(int idCargoFuncionarioPac, String cargo) 
	{
		this.idCargoFuncionarioPac = idCargoFuncionarioPac;
		this.cargo = cargo;
	}
	// ********************************************
	
	public int getIdCargoFuncionarioPac() {
		return idCargoFuncionarioPac;
	}
	public void setIdCargoFuncionarioPac(int idCargoFuncionarioPac) {
		this.idCargoFuncionarioPac = idCargoFuncionarioPac;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Get all existing roles into DB
	 * @return ArraLis<Role> List containing all roles existing into DB 
	 * @return ArraLis<Role> Empty Fail in try to get list containing all roles existing into DB 
	 */
	static public ArrayList<Role> getRoles()
	{
		RoleDAO roleDAO = new RoleDAO();
		return roleDAO.getRoles();
	}
	

}
