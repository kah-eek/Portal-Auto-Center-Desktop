package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.util.converter.LocalDateStringConverter;
import utils.Utils;
import view.Main;
import viewmodel.FuncionarioDetalhado;
import viewmodel.ParceiroSimplesFormatado;

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
		// Create a list that will fill the user's levels
		ObservableList<String> levels = FXCollections.observableArrayList();

		for(UserLevel level : UserLevel.getUserLevels())
		{
			levels.add(level.getNivel());
		}

		// Set list into combo box
		cbxNivelUsuario.setItems(levels);
		// __________________________________________________________><

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
		cbxEstado.getSelectionModel().select(fullEmployee.getIdEstado()-1);
		txtCep.setText(fullEmployee.getCep());
		txtBairro.setText(fullEmployee.getBairro());
		txtComplemento.setText(fullEmployee.getComplemento());
		txtNomeUsuario.setText(fullEmployee.getUsuario());
		txtSenha.setText(fullEmployee.getSenha());
		cbxNivelUsuario.getSelectionModel().select(fullEmployee.getIdNivelUsuario()-1);
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

	/**
	 * Return to employee window
	 */
	@FXML public void openEmployeeWIndow()
    {
		Main.openWindow("Employee", new Employee(employee));
    }

	/**
	 * Update employee
	 */
	@FXML public void updateEmployee()
	{
		// Create address object that it will updated into DB
		Address address = new Address(
				fullEmployee.getIdEndereco(),
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
			fullEmployee.getIdUsuario(),
			txtNomeUsuario.getText(),
			txtSenha.getText(),
			cbxNivelUsuario.getSelectionModel().getSelectedIndex()+1,
			activeUser
		);

		char employeeSex = rbtSexoF.isSelected() ? 'F' : 'M';

		LocalDate date = dpDtNasc.getValue();

		// Create employee object that it will updated into DB
		Employee employee = new Employee
		(
				fullEmployee.getIdFuncionarioPac(),
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
			employee.updateEmployee(employee)
		)
		{ // Successful
			Utils.showInfo(null, "Funcionário atualizado com sucesso !", "Atualizar Funcionário");

			// Return to partner window
			Main.openWindow("Employee", new Employee(employee));
		}
		else // Fail
		{
			Utils.showError(null, "Atualizar Funcionário", "Falha ao tentar atualziar o funcionário :(");
		}
	}

}
