package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.EmployeeDAO;
import model.EmployeeWageDAO;
import viewmodel.PagamentoFuncionarioDetalhadoFormatado;
import viewmodel.ParceiroSimplesFormatado;

public class EmployeeWage {
	
	// Global employee on application
	private Employee employee;

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
	
	
	@FXML public void updateEmployeeWage()
	{
		
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
