package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Home {
	
	// Global employee on application
	private Employee employee;
	
	// Get fields from window
	@FXML Label txtUsersName;
	
	// Default constructor
	public Home(Employee employeeObj)
	{
		this.employee = employeeObj;
	}
	
	// Set some data into some field
	@FXML public void initialize() 
	{				
		// Show employee's name
		txtUsersName.setText(this.employee.getNome());
	}
	
	
	
	

}
