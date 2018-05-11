package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.PartnerDAO;

public class AddPartner {

	// Global employee on application
	private Employee employee;

	// Get fields from window
	@FXML TextField txtNome;
	@FXML TextField txtCpf;
	@FXML TextField txtRg;
	@FXML DatePicker dpDtNasc;
	@FXML TextField txtSalario;
	@FXML TextField txtCelular;
	@FXML ComboBox<String> cbxCargo;
	@FXML TextField txtLogradouro;
	@FXML TextField txtNumero;
	@FXML TextField txtCidade;
	@FXML ComboBox<String> cbxEstado;
	@FXML TextField txtCep;
	@FXML TextField txtBairro;
	@FXML TextField txtComplemento;
	@FXML TextField txtUsuario;
	@FXML PasswordField txtSenha;
	@FXML ComboBox<String> cbxNivelUsuario;

	// Default constructor
	public AddPartner(Employee employeeObj)
	{
		this.employee = employeeObj;
	}
	
	@FXML public void initialize()
	{
		// Create a list that will fill the user's levels
		ObservableList<String> list = FXCollections.observableArrayList
		(
			"test"
		);
		
		cbxNivelUsuario.setItems(list);
	}

	// Return to Partners window
	@FXML public void openPartnersWindow()
	{
		Main.openWindow("Partner", new Partner(employee));
	}
	
	@FXML public void insertPartner()
	{
		
		System.out.println(cbxNivelUsuario.getValue());
		
//		User user = new User
//		(
//			txtUsuario.getText(),
//			txtSenha.getText(),
//			cbxNivelUsuario.getValue()
//		);
		
//		Partner partner = new Partner
//		(
//				idParceiro,
//				int idEndereco,
//				int idUsuario,
//				int idPlanoContratacao,
//				String nomeFantasia,
//				String razaoSocial,
//			    String cnpj,
//			    int ativo,
//			    int socorrista,
//			    String email,
//			    String telefone,
//			    String celular,
//			    String fotoPerfil,
//			    String logParceiro
//		);
//		
//		PartnerDAO partnerDAO = new PartnerDAO();
//		partnerDAO.insertPartner(partnerObj);
	}

}
