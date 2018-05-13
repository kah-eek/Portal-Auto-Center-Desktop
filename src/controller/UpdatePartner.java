package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import utils.Utils;
import viewmodel.ParceiroDetalhado;

public class UpdatePartner {
	
	// Global employee on application
	private Employee employee;
	
	// Partner that it will be updated
	private ParceiroDetalhado fullPartner;
	
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
	@FXML RadioButton rbnUsuarioAtivoS;
	@FXML RadioButton rbnUsuarioAtivoN;
	@FXML RadioButton rbtParceiroAtivoS;
	@FXML RadioButton rbtParceiroAtivoN;
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
	public UpdatePartner(Employee employeeObj, ParceiroDetalhado fullPartner)
	{
		this.employee = employeeObj;
		this.fullPartner = fullPartner;
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
		
		// Setting data into fields
		txtNomeFantasia.setText(fullPartner.getNomeFantasia());
		txtRazaoSocial.setText(fullPartner.getRazaoSocial());
		txtCnpj.setText(fullPartner.getCnpj());
		txtEmail.setText(fullPartner.getEmail());				
		txtTelefone.setText(fullPartner.getTelefone());
//		imgFotoPerfil.setText(fullPartner.getFotoPerfil());
		txtCelular.setText(fullPartner.getCelular());
		cbxPlanoContratacao.getSelectionModel().select(fullPartner.getIdPlanoContratacao()-1);
		txtLogradouro.setText(fullPartner.getLogradouro());
		txtNumero.setText(fullPartner.getNumero());
		txtCidade.setText(fullPartner.getCidade());
		cbxEstado.getSelectionModel().select(fullPartner.getIdEndereco()-1);
		txtCep.setText(fullPartner.getCep());
		txtBairro.setText(fullPartner.getBairro());
		txtComplemento.setText(fullPartner.getComplemento());
		txtUsuario.setText(fullPartner.getUsuario());
		txtSenha.setText(fullPartner.getSenha());
		cbxNivelUsuario.getSelectionModel().select(fullPartner.getIdNivelUsuario());
		
		if(fullPartner.getAtivo() == 1)
		{ 
			rbnUsuarioAtivoS.setSelected(true);
		}
		else
		{
			rbnUsuarioAtivoN.setSelected(true);
		}
		
		if(fullPartner.getSocorrista() == 1)
		{
			rbtSocorristaS.setSelected(true);
		}
		else 
		{
			rbtSocorristaN.setSelected(true);
		}
		
		if(fullPartner.getParceiroAtivo() == 1)
		{ 
			rbtParceiroAtivoS.setSelected(true);
		}
		else
		{
			rbtParceiroAtivoN.setSelected(true);
		}
	}
	
	/**
	 * Update partner
	 */
	@FXML public void updatePartner()
	{
		// Create address object that it will updated into DB
		Address address = new Address(
				fullPartner.getIdEndereco(),
				txtLogradouro.getText(),
				txtNumero.getText(),
				txtCidade.getText(),
				cbxEstado.getSelectionModel().getSelectedIndex()+1,
				txtCep.getText(),
				txtBairro.getText(),
				txtComplemento.getText()
		);
		
		int activeUser = rbnUsuarioAtivoN.isSelected() ? 0 : 1; 
		
		// Create user object that it will updated into DB
		User user = new User
		(
			fullPartner.getIdUsuario(),
			txtUsuario.getText(), 
			txtSenha.getText(), 
			cbxNivelUsuario.getSelectionModel().getSelectedIndex()+1,
			activeUser
		);
		
		// Verify which option about "Socorrista" it will be set
		int socorrista = rbtSocorristaN.isSelected() ? 0 : 1;
		
		// Verify which option about "Ativo" (Partner) it will be set
		int ativo = rbtParceiroAtivoS.isSelected() ? 1 : 0;
				
		// Create partner object that it will updated into DB
		Partner partner = new Partner(
				fullPartner.getIdParceiro(),
				cbxPlanoContratacao.getSelectionModel().getSelectedIndex()+1,
				txtNomeFantasia.getText(),
				txtRazaoSocial.getText(),
				txtCnpj.getText(),
				ativo,
				socorrista,
				txtEmail.getText(),
				txtTelefone.getText(),
				txtCelular.getText(),
				"path"
		);
		
		// DEBBUG
		/*
		System.out.println(address.updateAddress(address)); 
		System.out.println(user.updateUser(user));
		System.out.println(partner.updatePartner(partner));
		*/
		
		// Verify if the updates was succeed
		if
		(
			address.updateAddress(address) && 
			user.updateUser(user) &&
			partner.updatePartner(partner)
		)
		{ // Successful
			Utils.showInfo(null, "Parceiro atualizado com sucesso !", "Atualizar Parceiro");
			
			// Return to partner window
			Main.openWindow("Partner", new Partner(employee));
		}
		else // Fail
		{
			Utils.showError(null, "Atualizar Parceiro", "Falha ao tentar atualziar o parceiro :(");
		}
	}
	
	/**
	 * Return to Partners window
	 */
	@FXML public void openPartnersWindow()
	{
		Main.openWindow("Partner", new Partner(employee));
	}
}
