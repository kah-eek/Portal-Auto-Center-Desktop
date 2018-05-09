package controller;

import model.ExpendDAO;

public abstract class Expend {
	
	/**
	 * Get all company expend's value
	 * @return float Expend's value
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	static public float getAllExpendValue()
	{
		ExpendDAO expendDAO = new ExpendDAO();
		return expendDAO.getAllExpendValue();
	}

}
