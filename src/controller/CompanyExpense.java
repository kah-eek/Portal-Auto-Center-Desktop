package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CompanyExpenseDAO;
import utils.Utils;
import viewmodel.ContaPacFormatado;
import viewmodel.FuncionarioSimplesFormatado;
import viewmodel.ParceiroSimplesFormatado;

public class CompanyExpense {

	// Global employee on application
	private Employee employee;

	private int idContaPac;
	private int idCategoriaContaPac;
	private float valor;
	private String vencimento;
	private int  paga;
	private String logContaPac;

	// Default constructor
	public CompanyExpense
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

	public CompanyExpense
	(
		int idCategoriaContaPac,
		float valor,
		String vencimento,
		int paga
	)
	{
		this.idCategoriaContaPac = idCategoriaContaPac;
		this.valor = valor;
		this.vencimento = vencimento;
		this.paga = paga;
	}

	public CompanyExpense
	(
		int idContaPac,
		int idCategoriaContaPac,
		float valor,
		String vencimento,
		int paga
	)
	{
		this.idContaPac = idContaPac;
		this.idCategoriaContaPac = idCategoriaContaPac;
		this.valor = valor;
		this.vencimento = vencimento;
		this.paga = paga;
	}
	// **************************************

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

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

	// Get fields from window
	@FXML Label lblUsersName;

	//Get fields from window
	@FXML TableView<ContaPacFormatado> tblCompanyExpense;
    @FXML TableColumn<ContaPacFormatado, String> colExpenseId;
    @FXML TableColumn<ContaPacFormatado, String> colCategory;
    @FXML TableColumn<ContaPacFormatado, String> colValue;
    @FXML TableColumn<ContaPacFormatado, String> colPayed;
    @FXML TableColumn<ContaPacFormatado, String> colDue;

	// Default constructor
	public CompanyExpense(Employee employeeObj)
	{
		this.employee = employeeObj;
	}

	/**
	 * Get all informations about one company's bill
	 * @param billId Company bill's ID that it will be achieve into DB
	 * @return CompanyExpense CompanyExpense containing all data
	 * @return null Fail in try to get the company bill's data into DB
	 */
	static public CompanyExpense getFullBillById(int billId)
	{
		CompanyExpenseDAO companyExpenseDAO = new CompanyExpenseDAO();
		return companyExpenseDAO.getFullBillById(billId);
	}

	/**
	 * Insert a new company's bill into DB
	 * @param CompanyExpense Object that will inserted into DB
	 * @return long Last record's ID
	 * @return long -1 Fail in try to get last record's ID from database
	 */
	public long insertBill(CompanyExpense billObj)
	{
		CompanyExpenseDAO companyExpenseDAO = new CompanyExpenseDAO();
		return companyExpenseDAO.insertBill(billObj);
	}

	/**
	 * Update the company's bill in DB
	 * @param CompanyExpense billObj that will be updated into DB
	 * @return true Compnay's bill was updated with successful
	 * @return false Fail on attempt to updated the compnay's bill from DB
	 */
	public boolean updateBill(CompanyExpense billObj)
	{
		CompanyExpenseDAO companyExpenseDAO = new CompanyExpenseDAO();
		return companyExpenseDAO.updateBill(billObj);
	}

	/**
	 * Get all bills existing into DB
	 * @return ArrayList<ContaPacFormatado> Containing all bills
	 * @return empty ArrayList<ContaPacFormatado> Fail to attempt get bills into DB
	 */
	public ArrayList<ContaPacFormatado> getBills()
	{
		CompanyExpenseDAO companyExpenseDAO = new CompanyExpenseDAO();
		return companyExpenseDAO.getBills();
	}

	/**
	 * Delete the bill from DB
	 * @param billId Bill's ID
	 * @return true Bill was deleted with successful
	 * @return false Fail on attempt to delete the bill from DB
	 */
	static public boolean deleteBill(int billId)
	{
		CompanyExpenseDAO companyExpenseDAO = new CompanyExpenseDAO();
		return companyExpenseDAO.deleteBill(billId);
	}

	// Set some data into some field
	@FXML public void initialize()
	{
		// Set some data into some field
		colCategory.setCellValueFactory(new PropertyValueFactory<ContaPacFormatado,String>("categoria"));
		colDue.setCellValueFactory(new PropertyValueFactory<ContaPacFormatado,String>("vencimento"));
		colExpenseId.setCellValueFactory(new PropertyValueFactory<ContaPacFormatado,String>("idContaPac"));
		colPayed.setCellValueFactory(new PropertyValueFactory<ContaPacFormatado,String>("paga"));
		colValue.setCellValueFactory(new PropertyValueFactory<ContaPacFormatado,String>("valor"));

		ArrayList<ContaPacFormatado> bills = this.getBills();

		tblCompanyExpense.setItems(FXCollections.observableArrayList(bills));

		// Show employee's name
		lblUsersName.setText(employee.getNome());
	}

	/**
	 * Open window to add new bill
	 */
	@FXML public void addBill()
	{
		Main.openWindow("AddCompanyBill", new AddCompanyBill(employee));
	}

	/**
	 * Delete selected bill
	 */
	@FXML public void deleteBill()
	{
		// Get selected row
		ContaPacFormatado clickedBill = tblCompanyExpense.getSelectionModel().getSelectedItem();

		// Check if one row was selected
		if(clickedBill != null)  // Row was selected
		{
			// Create a confirm dialog
			int dialog = Utils.confirmDialog(null, "Deseja realmente deletar esta fatura \""+clickedBill.getCategoria()+"\" ("+clickedBill.getVencimento()+") ?", "Fatura", JOptionPane.YES_NO_OPTION);

			// Verify user's answer
			if(dialog == JOptionPane.YES_OPTION)
			{
				// Check if partner was deleted
				if(CompanyExpense.deleteBill(clickedBill.getIdContaPac()))
				{
					tblCompanyExpense.getItems().remove(clickedBill);
				}
				else
				{
					Utils.showError(null, "Deletar Registro", "Falha ao tentar deletar a fatura \""+clickedBill.getCategoria()+"\" ("+clickedBill.getVencimento()+")");
				}
			}
		}
	}

	/**
	 * Update selected bill
	 */
	@FXML public void updateBill()
	{
		// Get selected row
		ContaPacFormatado clickedBill = tblCompanyExpense.getSelectionModel().getSelectedItem();

		// Check if one row was selected
		if(clickedBill != null)  // Row was selected
		{
			// Open update partner window to see partner's data
			Main.openWindow("UpdateCompanyBill", new UpdateCompanyBill(employee, CompanyExpense.getFullBillById(clickedBill.getIdContaPac())));
		}
	}

	// Open windows when click on "button"
	@FXML public void openHomeWindow()
	{
		Main.openWindow("Home", new Home(employee));
	}

	@FXML public void openPartnersWindow()
	{
		Main.openWindow("Partner", new Partner(employee));
	}

	@FXML public void openEmployeeWindow()
	{
		Main.openWindow("Employee", new Employee(employee));
	}

	@FXML public void openEmployeeWageWindow()
	{
		Main.openWindow("EmployeeWage", new EmployeeWage(employee));
	}
	// ***************************************************

}
