package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.EmployeeDAO;
import utils.Utils;
import viewmodel.FuncionarioDetalhado;
import viewmodel.FuncionarioSimplesFormatado;
import viewmodel.ParceiroSimplesFormatado;

public class Employee {

  // Attributes
  private int idFuncionarioPac;
  private String nome;
  private String cpf;
  private String rg;
  private int idEndereco;
  private String dtNascimento;
  private int idCargoFuncionarioPac;
  private float salario;
  private char sexo;
  private String celular;
  private String email;
  private String foto;
  private String cnh;
  private String pis;
  private String certificadoReservista;
  private String logFuncionarioPac;
  private int idUsuario;

  //Global employee on application
  private Employee employee;
 // *****************************************************

//Get fields from window
  @FXML TableView<FuncionarioSimplesFormatado> tblEmployees;
  @FXML TableColumn<FuncionarioSimplesFormatado, String> colEmployeeId;
  @FXML TableColumn<FuncionarioSimplesFormatado, String> colEmployeeName;
  @FXML TableColumn<FuncionarioSimplesFormatado, String> colAdimissionDate;
  @FXML TableColumn<FuncionarioSimplesFormatado, String> colEmployeeRole;
  @FXML TableColumn<FuncionarioSimplesFormatado, String> colEmployeeEmail;
  @FXML TableColumn<FuncionarioSimplesFormatado, String> colEmployeeCellphone;

  // Get fields from window
  @FXML Label lblUsersName;

  // Default constructor
  public Employee(Employee employeeObj)
  {
	  this.employee = employeeObj;
  }

  public Employee(){}
  
  public Employee
  (
	String nome, 
	String cpf, 
	String rg, 
	int idCargoFuncionarioPac,
	char sexo, 
	String celular, 
	String email, 
	String foto, 
	String cnh,
	String pis, 
	String certificadoReservista,
	float salario,
	String dtNascimento
  ) 
  {
	this.nome = nome;
	this.cpf = cpf;
	this.rg = rg;
	this.dtNascimento = dtNascimento;
	this.idCargoFuncionarioPac = idCargoFuncionarioPac;
	this.salario = salario;
	this.sexo = sexo;
	this.celular = celular;
	this.email = email;
	this.foto = foto;
	this.cnh = cnh;
	this.pis = pis;
	this.certificadoReservista = certificadoReservista;
  }
  
  public Employee
  (
	int idFuncionarioPac, 
	String nome, 
	String cpf, 
	String rg, 
	int idCargoFuncionarioPac,
	char sexo, 
	String celular, 
	String email, 
	String foto, 
	String cnh,
	String pis, 
	String certificadoReservista,
	float salario,
	String dtNascimento
  ) 
  {
	this.idFuncionarioPac = idFuncionarioPac;
	this.nome = nome;
	this.cpf = cpf;
	this.rg = rg;
	this.dtNascimento = dtNascimento;
	this.idCargoFuncionarioPac = idCargoFuncionarioPac;
	this.salario = salario;
	this.sexo = sexo;
	this.celular = celular;
	this.email = email;
	this.foto = foto;
	this.cnh = cnh;
	this.pis = pis;
	this.certificadoReservista = certificadoReservista;
  }
  // ***************************************

  public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
  }
  public int getIdUsuario() {
    return idUsuario;
  }
  public void setIdFuncionarioPac(int idFuncionarioPac) {
	this.idFuncionarioPac = idFuncionarioPac;
  }
  public int getIdFuncionarioPac()
  {
	  return idFuncionarioPac;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public String getRg() {
    return rg;
  }
  public void setRg(String rg) {
    this.rg = rg;
  }
  public int getIdEndereco() {
    return idEndereco;
  }
  public void setIdEndereco(int idEndereco) {
    this.idEndereco = idEndereco;
  }
  public String getDtNascimento() {
    return dtNascimento;
  }
  public void setDtNascimento(String dtNascimento) {
    this.dtNascimento = dtNascimento;
  }
  public int getIdCargoFuncionarioPac() {
    return idCargoFuncionarioPac;
  }
  public void setIdCargoFuncionarioPac(int idCargoFuncionarioPac) {
    this.idCargoFuncionarioPac = idCargoFuncionarioPac;
  }
  public float getSalario() {
    return salario;
  }
  public void setSalario(float salario) {
    this.salario = salario;
  }
  public char getSexo() {
    return sexo;
  }
  public void setSexo(char sexo) {
    this.sexo = sexo;
  }
  public String getCelular() {
    return celular;
  }
  public void setCelular(String celular) {
    this.celular = celular;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getFoto() {
    return foto;
  }
  public void setFoto(String foto) {
    this.foto = foto;
  }
  public String getCnh() {
    return cnh;
  }
  public void setCnh(String cnh) {
    this.cnh = cnh;
  }
  public String getPis() {
    return pis;
  }
  public void setPis(String pis) {
    this.pis = pis;
  }
  public String getCertificadoReservista() {
    return certificadoReservista;
  }
  public void setCertificadoReservista(String certificadoReservista) {
    this.certificadoReservista = certificadoReservista;
  }
  public String getLogFuncionarioPac() {
    return logFuncionarioPac;
  }
  public void setLogFuncionarioPac(String logFuncionarioPac) {
    this.logFuncionarioPac = logFuncionarioPac;
  }
  
  /**
  * Delete the employee from DB
  * @param employeeId Employee's ID
  * @return true Employee was deleted with successful
  * @return false Fail on attempt to delete the employee from DB
  */
  static public boolean deleteEmployee(int employeeId)
  {
	  EmployeeDAO employeeDAO = new EmployeeDAO();
	  return employeeDAO.deleteEmployee(employeeId);
  }
  
  /**
  * Update the employee in DB
  * @param employeeObj Employee that will be updated into DB
  * @return true Employee was updated with successful
  * @return false Fail on attempt to updated the employee from DB
  */
  public boolean updateEmployee(Employee employeeObj)
  {
	  EmployeeDAO employeeDAO = new EmployeeDAO();
	  return employeeDAO.updateEmployee(employeeObj);
  }
  
  /**
  * Insert a new employee into DB
  * @param addressObj Address object that will inserted into DB
  * @param userObj User object that will inserted into DB
  * @param employeeObj Employee object that will inserted into DB
  * @return int Last employee's record ID
  * @return itn -1 Fail in try to insert some data into database
  */
  public int insertEmployee(Address addressObj, User userObj, Employee employeeObj)
  {
	  EmployeeDAO employeeDAO = new EmployeeDAO();
	  return employeeDAO.insertEmployee(addressObj, userObj, employeeObj);	
  }


  /**
  * Get employee's informations from DB
  * @param userId Employee's user id to find it in DB
  * @return Employee Employee object with employee's data came from DB
  * @return null Fail to get employee's informations from DB
  */
  public Employee getEmployeesInformation(int userId)
  {
	  EmployeeDAO employeeDAO = new EmployeeDAO();
	  return employeeDAO.getEmployeesInformation(userId);
  }
  
  /**
  * Get employees' basic informations from DB
  * @return ArrayList<FuncionarioSimplesFormatado> List containing all of employees existing into DB
  * @return ArrayList<FuncionarioSimplesFormatado> Empty list. Fail to get employees' basic informations from DB
  */
  public ArrayList<FuncionarioSimplesFormatado> getEmployees()
  {
	  EmployeeDAO employeeDAO = new EmployeeDAO();
	  return employeeDAO.getEmployees();
  }
  
  @FXML public void initialize()
  {
	// Set some data into some field
	colEmployeeId.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("idFuncionarioPac"));
	colEmployeeEmail.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("email"));
	colEmployeeName.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("nome"));
	colEmployeeRole.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("cargo"));
	colAdimissionDate.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("dataAdmissao"));
	colEmployeeCellphone.setCellValueFactory(new PropertyValueFactory<FuncionarioSimplesFormatado,String>("celular"));

	ArrayList<FuncionarioSimplesFormatado> employees = this.getEmployees();

	tblEmployees.setItems(FXCollections.observableArrayList(employees));

	// Show employee's name
	lblUsersName.setText(employee.getNome());
  }
  
  /**
  * Get all informations about one employee
  * @param employeeId Employee's ID that it will be achieve into DB
  * @return FuncionarioDetalhado Employee containing all data
  * @return null Fail in try to get the employee's data into DB
  */
  static public FuncionarioDetalhado getFullEmployeeById(int employeeId)
  {
	  EmployeeDAO employeeDAO = new EmployeeDAO();
	  return employeeDAO.getFullEmployeeById(employeeId);
  }
  
  /**
   * Open window to add new employee
   */
  @FXML public void addEmployee()
  {
	  Main.openWindow("AddEmployee", new AddEmployee(employee));
  }
 
  /**
   * Update selected employee
   */
  @FXML public void updateEmployee()
  {
	// Get selected row
	FuncionarioSimplesFormatado clickedEmployee = tblEmployees.getSelectionModel().getSelectedItem();
	
	// Check if one row was selected
	if(clickedEmployee != null)  // Row was selected
	{		
		// Open update partner window to see partner's data
		Main.openWindow("UpdateEmployee", new UpdateEmployee(employee, Employee.getFullEmployeeById(clickedEmployee.getIdFuncionarioPac())));
	}
  }
  
  /**
   * Delete employee
   */
  @FXML public void deleteEmployee()
  {
	  // Get selected row
	  FuncionarioSimplesFormatado clickedEmployee =  tblEmployees.getSelectionModel().getSelectedItem();
	  
	// Check if one row was selected
	if(clickedEmployee != null)  // Row was selected
	{
		// Create a confirm dialog
		int dialog = Utils.confirmDialog(null, "Deseja realmente deletar o funcionário \""+clickedEmployee.getNome()+"\" ?", "Funcionário", JOptionPane.YES_NO_OPTION);

		// Verify user's answer
		if(dialog == JOptionPane.YES_OPTION)
		{
			// Check if employee was deleted
			if(Employee.deleteEmployee(clickedEmployee.getIdFuncionarioPac()))
			{
				tblEmployees.getItems().remove(clickedEmployee);
			}
			else
			{
				Utils.showError(null, "Deletar Registro", "Falha ao tentar deletar o funcionário \""+clickedEmployee.getNome()+"\"");
			}
		}
	}
  }

  //Open windows when click on "button"
  @FXML public void openHomeWindow()
  {
	Main.openWindow("Home", new Home(employee));
  }

  @FXML public void openPartnersWindow()
  {
	Main.openWindow("Partner", new Partner(employee));
  }

  @FXML public void openCompanyExpenseWIndow()
  {
	Main.openWindow("CompanyExpense", new CompanyExpense(employee));
  }

  @FXML public void openEmployeeWageWindow()
  {
	Main.openWindow("EmployeeWage", new EmployeeWage(employee));
  }
  // ***************************************************
  

}
