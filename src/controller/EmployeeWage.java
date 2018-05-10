package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmployeeWage {

	// Global employee on application
	private Employee employee;

	// Get fields from window
	@FXML Label lblUsersName;

	// Default constructor
	public EmployeeWage(Employee employeeObj)
	{
		this.employee = employeeObj;
	}

	// Set some data into some field
	@FXML public void initialize()
	{
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

	@FXML public void openCompanyExpenseWindow()
	{
		Main.openWindow("CompanyExpense", new CompanyExpense(employee));
	}
	// ***************************************************
}
