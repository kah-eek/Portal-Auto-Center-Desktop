package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
		
		if(fullPartner.getSocorrista() == 1)
		{
			rbtSocorristaS.setSelected(true);
		}
		else 
		{
			rbtSocorristaN.setSelected(true);
		}
				
		txtTelefone.setText(fullPartner.getTelefone());
//		imgFotoPerfil.setText(fullPartner.getFotoPerfil());
		txtCelular.setText(fullPartner.getCelular());
		
		cbxPlanoContratacao.getSelectionModel().select(fullPartner.getIdPlanoContratacao()-1);
		
		if(fullPartner.getAtivo() == 1)
		{ 
			rbnUsuarioAtivoS.setSelected(true);
		}
		else
		{
			rbnUsuarioAtivoN.setSelected(true);
		}
		
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
	}
	
	/**
	 * Return to Partners window
	 */
	@FXML public void openPartnersWindow()
	{
		Main.openWindow("Partner", new Partner(employee));
	}
}
