package controller;

import java.util.ArrayList;

import model.StateDAO;

public class State {
	
	private int idEstado;
	private String estado;
	
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	// Default constructor
	public State(int idEstado, String estado)
	{
		this.idEstado = idEstado;
		this.estado = estado;
	}
	// ********************************
	
	/**
	 * Get all existing states into DB
	 * @return ArraLis<State> List containing all states existing into DB 
	 * @return ArraLis<State> Empty Fail in try to get list containing all states existing into DB 
	 */
	static public ArrayList<State> getStates()
	{
		StateDAO stateDAO = new StateDAO();
		return stateDAO.getStates();
	}

}
