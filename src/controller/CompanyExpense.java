package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CompanyExpenseDAO;
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
