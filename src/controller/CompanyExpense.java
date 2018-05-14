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
