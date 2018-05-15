package controller;

import java.time.LocalDate;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import utils.Utils;
import view.Main;
import viewmodel.ContaPacFormatado;
import viewmodel.FuncionarioDetalhado;

public class UpdateCompanyBill {

	// Global employee on application
	private Employee employee;

	// Bill that it will be updated
	private CompanyExpense fullBill;

	// Get fields from window
	@FXML TextField txtValor;
	@FXML ComboBox<String> cbxCategoria;
	@FXML DatePicker dpDataVencimento;
	@FXML RadioButton rbtPagaS;
	@FXML RadioButton rbtPagaN;

	// Default constructor
	public UpdateCompanyBill(Employee employeeObj, CompanyExpense fullBill)
	{
		this.employee = employeeObj;
		this.fullBill = fullBill;
	}

	@FXML public void initialize()
	{
		// Create a list that will fill the bill's categories
		ObservableList<String> categories = FXCollections.observableArrayList();

		for(BillCategory category  : BillCategory.getBillCategories())
		{
			categories.add(category.getCategoria());
		}

		// Set list into combo box
		cbxCategoria.setItems(categories);
		// __________________________________________________________><

		// Setting data into fields
		txtValor.setText(String.valueOf(fullBill.getValor()));
		dpDataVencimento.setValue(LocalDate.parse(fullBill.getVencimento()));
		cbxCategoria.getSelectionModel().select(fullBill.getIdCategoriaContaPac()-1);

		// Verify if bill is payed
		if(fullBill.getPaga() == 1)
		{
			rbtPagaS.setSelected(true);
		}
		else
		{
			rbtPagaN.setSelected(true);
		}
	}

	/**
	 * Update employee
	 */
	@FXML public void updateBill()
	{
		// Check if bill is payed
		int payed = rbtPagaN.isSelected() ? 0 : 1;

		CompanyExpense bill = new CompanyExpense
		(
				fullBill.getIdContaPac(),
				cbxCategoria.getSelectionModel().getSelectedIndex()+1,
				Float.parseFloat(txtValor.getText()),
				dpDataVencimento.getValue().toString(),
				payed
		);

		// Verify if the updates was succeed
		if(bill.updateBill(bill))
		{ // Successful
			Utils.showInfo(null, "Fatura atualizado com sucesso !", "Atualizar Fatura");

			// Return to partner window
			Main.openWindow("CompanyExpense", new CompanyExpense(employee));
		}
		else // Fail
		{
			Utils.showError(null, "Atualizar Fatura", "Falha ao tentar atualziar a fatura :(");
		}
	}

}
