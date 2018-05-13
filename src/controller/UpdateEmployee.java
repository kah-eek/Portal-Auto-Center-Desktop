package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.converter.LocalDateStringConverter;
import viewmodel.FuncionarioDetalhado;

public class UpdateEmployee {
	
	// Global employee on application
	private Employee employee;
	
	// Partner that it will be updated
	private FuncionarioDetalhado fullEmployee;
	
	// Get fields from window
	@FXML TextField txtNome;
	@FXML TextField txtCpf;
	@FXML TextField txtRg;
	@FXML DatePicker dpDtNasc;
	@FXML TextField txtSalario;
	@FXML TextField txtCelular;
	@FXML ComboBox<String> cbxCargo;
	@FXML ImageView imgFotoPerfil;
	@FXML TextField txtEmail;
	@FXML TextField txtCnh;
	@FXML TextField txtPis;
	@FXML TextField txtCertificadoReservista;
	
	@FXML RadioButton rbnUsuarioAtivoS;
	@FXML RadioButton rbnUsuarioAtivoN;
	@FXML RadioButton rbtSexoF;
	@FXML RadioButton rbtSexoM;
	
	@FXML TextField txtLogradouro;
	@FXML TextField txtNumero;
	@FXML TextField txtCidade;
	@FXML ComboBox<String> cbxEstado;
	@FXML TextField txtCep;
	@FXML TextField txtBairro;
	@FXML TextField txtComplemento;
	
	@FXML TextField txtNomeUsuario;
	@FXML PasswordField txtSenha;
	@FXML ComboBox<String> cbxNivelUsuario;

	
	// Default constructor
	public UpdateEmployee(Employee employeeObj, FuncionarioDetalhado fullEmployee)
	{
		this.employee = employeeObj;
		this.fullEmployee = fullEmployee;
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
		
		// Create a list that will fill the employee's roles list
		ObservableList<String> roles = FXCollections.observableArrayList();
		
		for(Role role : Role.getRoles())
		{
			roles.add(role.getCargo());
		}
		
		// Set list into combo box
		cbxCargo.setItems(roles);
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
		
		// Setting data into fields
		txtNome.setText(fullEmployee.getNome());
		txtCpf.setText(fullEmployee.getCpf());
		txtEmail.setText(fullEmployee.getEmail());	
		txtRg.setText(fullEmployee.getRg());
		txtSalario.setText(fullEmployee.getSalario());
		txtCnh.setText(fullEmployee.getCnh());
		txtCertificadoReservista.setText(fullEmployee.getCertificadoReservista());
		txtPis.setText(fullEmployee.getPis());
		dpDtNasc.setValue(LocalDate.parse(fullEmployee.getDtNascimento()));
		txtCelular.setText(fullEmployee.getCelular());
		//imgFotoPerfil.setText(fullEmployee.getFotoPerfil());
		txtLogradouro.setText(fullEmployee.getLogradouro());
		txtNumero.setText(fullEmployee.getNumero());
		txtCidade.setText(fullEmployee.getCidade());
		cbxEstado.getSelectionModel().select(fullEmployee.getIdEndereco()-1);
		txtCep.setText(fullEmployee.getCep());
		txtBairro.setText(fullEmployee.getBairro());
		txtComplemento.setText(fullEmployee.getComplemento());
		txtNomeUsuario.setText(fullEmployee.getUsuario());
		txtSenha.setText(fullEmployee.getSenha());
		cbxNivelUsuario.getSelectionModel().select(fullEmployee.getIdNivelUsuario());
		cbxCargo.getSelectionModel().select(fullEmployee.getCargo());

		// Verify if partner's user is active
		if(fullEmployee.getUsuarioAtivo() == 1)
		{ 
			rbnUsuarioAtivoS.setSelected(true);
		}
		else
		{
			rbnUsuarioAtivoN.setSelected(true);
		}
		
		// Verify employee's sex
		if(fullEmployee.getSexo() == 'M')
		{ 
			rbtSexoM.setSelected(true);
		}
		else
		{
			rbtSexoF.setSelected(true);
		}
	}

}
