package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.PartnerDAO;
import utils.Utils;

public class AddPartner {

	// Global employee on application
	private Employee employee;

	// Get fields from window
	@FXML TextField txtNomeFantasia;
	@FXML TextField txtRazaoSocial;
	@FXML TextField txtCnpj;
	@FXML TextField txtEmail;
	@FXML RadioButton rbtSocorristaN;
	@FXML RadioButton rbtSocorristaS;
	@FXML TextField txtTelefone;
	@FXML ImageView imgFotoPerfil;
	@FXML TextField txtCelular;
	@FXML ComboBox<String> cbxPlanoContratacao;
	@FXML RadioButton rbnSocorrista;
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
		// Create a list that will fill the states list
		ObservableList<String> states = FXCollections.observableArrayList();
		
		for(State state : State.getStates())
		{
			states.add(state.getEstado());
		}
		
		// Set list into combo box
		cbxEstado.setItems(states);
		// __________________________________________________________><
		
		// Create a list that will fill the user's levels
		ObservableList<String> levels = FXCollections.observableArrayList();
		
		for(UserLevel level : UserLevel.getUserLevels())
		{
			levels.add(level.getNivel());
		}
		
		// Set list into combo box
		cbxNivelUsuario.setItems(levels);
		// __________________________________________________________><
				
		// Create a list that will fill the subscription plan combo box
		ObservableList<String> plans = FXCollections.observableArrayList();
		
		for(Subscription plan : Subscription.getPartnerPlans())
		{
			plans.add(plan.getPlano());
		}
		
		// Set list into combo box
		cbxPlanoContratacao.setItems(plans);
		// __________________________________________________________><
	}

	// Return to Partners window
	@FXML public void openPartnersWindow()
	{
		Main.openWindow("Partner", new Partner(employee));
	}
	
	@FXML public void insertPartner()
	{		
		// Create address object that it will inserted into DB
		Address address = new Address(
				txtLogradouro.getText(),
				txtNumero.getText(),
				txtCidade.getText(),
				cbxEstado.getSelectionModel().getSelectedIndex()+1,
				txtCep.getText(),
				txtBairro.getText(),
				txtComplemento.getText()
		);
		
		// Create user object that it will inserted into DB
		User user = new User(txtUsuario.getText(), txtSenha.getText(), cbxNivelUsuario.getSelectionModel().getSelectedIndex()+1);
		
		// Verify which option about "Socorrista" it will be set
		int socorrista = rbtSocorristaN.isSelected() ? 0 : 1;
		
		// Create partner object that it will inserted into DB
		Partner partner = new Partner(
				txtNomeFantasia.getText(),
				txtRazaoSocial.getText(),
				txtCnpj.getText(),
				socorrista,
				txtEmail.getText(),
				txtTelefone.getText(),
				txtCelular.getText(),
				"path",
				cbxPlanoContratacao.getSelectionModel().getSelectedIndex()+1
		);
		
		PartnerDAO partnerDAO = new PartnerDAO();
		
		// Verify inserte's response
		if(partnerDAO.insertPartner(address, user, partner) != -1) // The record was inserted with successful
		{
			Utils.showInfo(null, "Parceiro cadastrado com sucesso!", "Cadastro de Parceiro");
			
			// Redirect user to partner window
			Main.openWindow("Partner", new Partner(employee));
		}
		else // Fail in try to insert the record
		{
			Utils.showError(null, "Cadastro de Parceiro", "Erro ao tentar cadastrar o parceiro :( ");
		}
		
	}

}
