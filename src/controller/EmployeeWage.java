package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.EmployeeDAO;
import model.EmployeeWageDAO;
import utils.Utils;
import viewmodel.PagamentoFuncionarioDetalhadoFormatado;
import viewmodel.ParceiroSimplesFormatado;

public class EmployeeWage {
	
	// Global employee on application
	private Employee employee;
	
	private int idPagamentoFuncionarioPac;
	private int idFuncionarioPac; 
	private int pago; 
	private String mesPagamento; 
	private String dataPagamentoRealizado;
	
	// Default constructor
	public EmployeeWage
	(
		int idPagamentoFuncionarioPac, 
		int idFuncionarioPac, 
		int pago, 
		String mesPagamento,
		String dataPagamentoRealizado
	) 
	{
		this.idPagamentoFuncionarioPac = idPagamentoFuncionarioPac;
		this.idFuncionarioPac = idFuncionarioPac;
		this.pago = pago;
		this.mesPagamento = mesPagamento;
		this.dataPagamentoRealizado = dataPagamentoRealizado;
	}
	// *****************************************************

	public int getIdPagamentoFuncionarioPac() {
		return idPagamentoFuncionarioPac;
	}

	public void setIdPagamentoFuncionarioPac(int idPagamentoFuncionarioPac) {
		this.idPagamentoFuncionarioPac = idPagamentoFuncionarioPac;
	}

	public int getIdFuncionarioPac() {
		return idFuncionarioPac;
	}

	public void setIdFuncionarioPac(int idFuncionarioPac) {
		this.idFuncionarioPac = idFuncionarioPac;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public String getMesPagamento() {
		return mesPagamento;
	}

	public void setMesPagamento(String mesPagamento) {
		this.mesPagamento = mesPagamento;
	}

	public String getDataPagamentoRealizado() {
		return dataPagamentoRealizado;
	}

	public void setDataPagamentoRealizado(String dataPagamentoRealizado) {
		this.dataPagamentoRealizado = dataPagamentoRealizado;
	}

	// Get fields from window
	@FXML Label lblUsersName;
	
	@FXML TableView<PagamentoFuncionarioDetalhadoFormatado> tblEmployeeWage;
	@FXML TableColumn<PagamentoFuncionarioDetalhadoFormatado, String> colId;
	@FXML TableColumn<PagamentoFuncionarioDetalhadoFormatado, String> colName;
	@FXML TableColumn<PagamentoFuncionarioDetalhadoFormatado, String> colWage;
	@FXML TableColumn<PagamentoFuncionarioDetalhadoFormatado, String> colPaied;
	@FXML TableColumn<PagamentoFuncionarioDetalhadoFormatado, String> colPayMonth;
	@FXML TableColumn<PagamentoFuncionarioDetalhadoFormatado, String> colPaidDate;

	// Default constructor
	public EmployeeWage(Employee employeeObj)
	{
		this.employee = employeeObj;
	}
	
	/**
	 * Get all employees' wage existing into DB
	 * @return ArrayList<PagamentoFuncionarioDetalhadoFormatado> Containing all employees' wage
	 * @return empty ArrayList<PagamentoFuncionarioDetalhadoFormatado> Fail to attempt get employees' wage into DB
	 */
	static public ArrayList<PagamentoFuncionarioDetalhadoFormatado> getAllEmployeeWage()
	{
		return new EmployeeWageDAO().getAllEmployeeWage();
	}
	
	/**
	 * Update the employee's wage in DB
	 * @param employeeWageObj Employee's wage that will be updated into DB
	 * @return true Employee's wage was updated with successful
	 * @return false Fail on attempt to updated the employee's wage from DB
	 */
	public boolean updateWageState(EmployeeWage employeeWageObj)
	{
		return new EmployeeWageDAO().updateWageState(employeeWageObj);
	}

	// Set some data into some field
	@FXML public void initialize()
	{   		
		// Set some data into some field
		colId.setCellValueFactory(new PropertyValueFactory<PagamentoFuncionarioDetalhadoFormatado,String>("idPagamentoFuncionarioPac"));
		colPaied.setCellValueFactory(new PropertyValueFactory<PagamentoFuncionarioDetalhadoFormatado,String>("pago"));
		colPayMonth.setCellValueFactory(new PropertyValueFactory<PagamentoFuncionarioDetalhadoFormatado,String>("mesPagamento"));
		colWage.setCellValueFactory(new PropertyValueFactory<PagamentoFuncionarioDetalhadoFormatado,String>("salario"));
		colPaidDate.setCellValueFactory(new PropertyValueFactory<PagamentoFuncionarioDetalhadoFormatado,String>("dataPagamentoRealizado"));
		colName.setCellValueFactory(new PropertyValueFactory<PagamentoFuncionarioDetalhadoFormatado,String>("nome"));

		ArrayList<PagamentoFuncionarioDetalhadoFormatado> employeesWage = this.getAllEmployeeWage();

		tblEmployeeWage.setItems(FXCollections.observableArrayList(employeesWage));
		
		// Show employee's name
		lblUsersName.setText(employee.getNome());
	}
	
	/**
	 * Update selected employee wage state
	 */
	@FXML public void updateEmployeeWage()
	{
		// Get selected row
		PagamentoFuncionarioDetalhadoFormatado clickedWage = tblEmployeeWage.getSelectionModel().getSelectedItem();
		
		// Check if one row was selected
		if(clickedWage != null)  // Row was selected
		{
			// Keep if employee's wage is paid
			int paid = 0;
			
			// Verify wage status (if it is paid or not)
			if(clickedWage.getPago().equals("Não")) paid = 1;
			
			// Verify if it is set to payment date or not
			String dataPagamentoRealizado = paid == 1 ? LocalDateTime.now().toString() : null;
			
			// Create EmployeeWage object to update it into DB
			EmployeeWage employeeWage = new EmployeeWage
			(
				clickedWage.getIdPagamentoFuncionarioPac(), 
				clickedWage.getIdFuncionarioPac(), 
				paid, 
				clickedWage.getMesPagamento(),
				dataPagamentoRealizado
			);
			
			// Verify if update has succeed
			if(employeeWage.updateWageState(employeeWage)) // Successful
			{
				Utils.showInfo(null, "Pagamento atualizado com sucesso", "Pagamento Funcionário");
				
				// Reload the window to update items into table
				Main.openWindow("EmployeeWage", new EmployeeWage(employee));
			}
			else // Fail
			{
				Utils.showError(null, "Pagamento Funcionário", "Falha ao tentar atualizar o pagamento selecionado :(");
			}
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

	@FXML public void openCompanyExpenseWindow()
	{
		Main.openWindow("CompanyExpense", new CompanyExpense(employee));
	}
	// ***************************************************
}
