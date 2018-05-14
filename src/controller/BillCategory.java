package controller;

import java.util.ArrayList;

import model.BillCategoryDAO;

public class BillCategory {

	private int idCategoriaContaPac;
	private String categoria;

	// Default constructor
	public BillCategory(int idCategoriaContaPac, String categoria)
	{
		this.idCategoriaContaPac = idCategoriaContaPac;
		this.categoria = categoria;
	}
    // *********************************************

	public int getIdCategoriaContaPac() {
		return idCategoriaContaPac;
	}
	public void setIdCategoriaContaPac(int idCategoriaContaPac) {
		this.idCategoriaContaPac = idCategoriaContaPac;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Get all existing bill's category into DB
	 * @return ArraLis<BillCategory> List containing all bill's category existing into DB
	 * @return ArraLis<BillCategory> Empty Fail in try to get list containing all bill's category existing into DB
	 */
	static public ArrayList<BillCategory> getBillCategories()
	{
		BillCategoryDAO billCategoryDAO = new BillCategoryDAO();
		return billCategoryDAO.getBillCategories();
	}

}
