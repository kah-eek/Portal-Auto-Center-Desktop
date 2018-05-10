package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AddPartner {

	// Global employee on application
	private Employee employee;

	// Get fields from window
	@FXML Label lblUsersName;

	// Default constructor
	public AddPartner(Employee employeeObj)
	{
		this.employee = employeeObj;
	}

	// Return to Partners window
	@FXML public void openPartnersWindow()
	{
		Main.openWindow("Partner", new Partner(employee));
	}

}
