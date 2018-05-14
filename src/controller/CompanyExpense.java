package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import viewmodel.ContaPacFormatado;
import viewmodel.FuncionarioSimplesFormatado;

public class CompanyExpense {

	// Global employee on application
	private Employee employee;
	
	

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

	// Set some data into some field
	@FXML public void initialize()
	{
		// Set some data into some field
		colEmployeeId.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("idFuncionarioPac"));
		colEmployeeEmail.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("email"));
		colEmployeeName.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("nome"));
		colEmployeeRole.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("cargo"));
		colAdimissionDate.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("dataAdmissao"));
		colEmployeeCellphone.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("celular"));

		ArrayList<FuncionarioSimplesFormatado> employees = this.getEmployees();

		tblEmployees.setItems(FXCollections.observableArrayList(employees));
		
		// Show employee's name
		lblUsersName.setText(employee.getNome());
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
