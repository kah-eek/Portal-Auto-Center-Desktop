package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.EmployeeDAO;
import viewmodel.FuncionarioSimplesFormatado;
import viewmodel.ParceiroSimplesFormatado;

public class Employee {

  // Attributes
  private int idFuncionarioPac;
  private String nome;
  private int cpf;
  private int rg;
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
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public int getCpf() {
    return cpf;
  }
  public void setCpf(int cpf) {
    this.cpf = cpf;
  }
  public int getRg() {
    return rg;
  }
  public void setRg(int rg) {
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
