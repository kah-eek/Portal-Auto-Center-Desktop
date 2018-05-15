package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.CompanyExpenseDAO;
import model.EmployeeDAO;
import utils.Utils;
import view.Main;

public class AddCompanyBill {

    //Global employee on application
    private Employee employee;

	private int idContaPac;
	private int idCategoriaContaPac;
	private float valor;
	private String vencimento;
	private int paga;
	private String logContaPac;

	// Get fields from window
	@FXML TextField txtValor;
	@FXML ComboBox<String> cbxCategoria;
	@FXML DatePicker dpDataVencimento;
	@FXML RadioButton rbtPagoS;
	@FXML RadioButton rbtPagoN;

	// Default constructor
	public AddCompanyBill
	(
		int idContaPac,
		int idCategoriaContaPac,
		float valor,
		String vencimento,
		int paga,
		String logContaPac
	)
	{
		this.idContaPac = idContaPac;
		this.idCategoriaContaPac = idCategoriaContaPac;
		this.valor = valor;
		this.vencimento = vencimento;
		this.paga = paga;
		this.logContaPac = logContaPac;
	}

    public AddCompanyBill(Employee employeeObj)
    {
	  this.employee = employeeObj;
    }
	// **********************************************

	public int getIdContaPac() {
		return idContaPac;
	}

	public void setIdContaPac(int idContaPac) {
		this.idContaPac = idContaPac;
	}

	public int getIdCategoriaContaPac() {
		return idCategoriaContaPac;
	}

	public void setIdCategoriaContaPac(int idCategoriaContaPac) {
		this.idCategoriaContaPac = idCategoriaContaPac;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public int getPaga() {
		return paga;
	}

	public void setPaga(int paga) {
		this.paga = paga;
	}

	public String getLogContaPac() {
		return logContaPac;
	}

	public void setLogContaPac(String logContaPac) {
		this.logContaPac = logContaPac;
	}

	@FXML public void initialize()
	{
		// Create a list that will fill the states list
		ObservableList<String> categories = FXCollections.observableArrayList();

		for(BillCategory bill : BillCategory.getBillCategories())
		{
			categories.add(bill.getCategoria());
		}

		// Set list into combo box
		cbxCategoria.setItems(categories);
		// __________________________________________________________><
	}

	/**
	 * Insert a new company's bill
	 */
	@FXML public void insertBill()
	{
		// Verify is bill is payed
		int payed = rbtPagoN.isSelected() ? 0 : 1;

		CompanyExpense bill = new CompanyExpense
		(
			cbxCategoria.getSelectionModel().getSelectedIndex()+1,
			Float.parseFloat(txtValor.getText()),
			dpDataVencimento.getValue().toString(),
			payed
		);

		CompanyExpenseDAO companyExpenseDAO = new CompanyExpenseDAO();

		// Verify inserte's response
		if(companyExpenseDAO.insertBill(bill) != -1) // The record was inserted with successful
		{
			Utils.showInfo(null, "Fatura cadastrado com sucesso!", "Cadastro de Fatura");

			// Redirect user to companys' expenses window
			Main.openWindow("CompanyExpense", new CompanyExpense(employee));
		}
		else // Fail in try to insert the record
		{
			Utils.showError(null, "Cadastro de Fatura", "Erro ao tentar cadastrar a fatura :( ");
		}
	}

	/**
	 * Return to CompanyExpense window
	 */
	@FXML public void openCompanyExpense()
	{
		Main.openWindow("CompanyExpense", new CompanyExpense(employee));
	}


}
