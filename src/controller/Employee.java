package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.EmployeeDAO;

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
