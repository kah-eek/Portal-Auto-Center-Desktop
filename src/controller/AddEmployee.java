package controller;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.EmployeeDAO;
import model.PartnerDAO;
import utils.Utils;

public class AddEmployee {

	// Global employee on application
	private Employee employee;
	
	// Default constructor
	public AddEmployee(Employee employeeObj)
	{
		this.employee = employeeObj;
	}
	
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
		
		// Create a list that will fill the employee's roles list
		ObservableList<String> roles = FXCollections.observableArrayList();
		
		for(Role role : Role.getRoles())
		{
			roles.add(role.getCargo());
		}
		
		// Set list into combo box
		cbxCargo.setItems(roles);
		// __________________________________________________________><
	}
	
	@FXML public void addEmployee()
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
		User user = new User(txtNomeUsuario.getText(), txtSenha.getText(), cbxNivelUsuario.getSelectionModel().getSelectedIndex()+1);
		
		// Get employee's sex
		char employeeSex = rbtSexoF.isSelected() ? 'F' : 'M';
		
		// Get picked date
		LocalDate date = dpDtNasc.getValue();
		
		// Create partner object that it will inserted into DB
		Employee employee = new Employee(
				txtNome.getText(), 
				txtCpf.getText(),
				txtRg.getText(), 
				cbxCargo.getSelectionModel().getSelectedIndex()+1,
				employeeSex, 
				txtCelular.getText(),
				txtEmail.getText(),
				"path", 
				txtCnh.getText(),
				txtPis.getText(), 
				txtCertificadoReservista.getText(),
				Float.parseFloat(txtSalario.getText()),
				date.toString()
		);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		// Verify inserte's response
		if(employeeDAO.insertEmployee(address, user, employee) != -1) // The record was inserted with successful
		{
			Utils.showInfo(null, "Funcionário cadastrado com sucesso!", "Cadastro de Funcionário");
			
			// Redirect user to partner window
			Main.openWindow("Employee", new Employee(employee));
		}
		else // Fail in try to insert the record
		{
			Utils.showError(null, "Cadastro de Funcionário", "Erro ao tentar cadastrar o funcionário :( ");
		}
	}
	
	/**
	 * Return to employees window
	 */
	@FXML public void openEmployeeWindow()
	{
		Main.openWindow("Employee", new Employee(employee));
	}
}
