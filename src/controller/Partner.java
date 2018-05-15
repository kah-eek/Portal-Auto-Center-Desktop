package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PartnerDAO;
import utils.Utils;
import view.Main;
import viewmodel.ParceiroDetalhado;
import viewmodel.ParceiroSimplesFormatado;

public class Partner {

	// Global employee on application
	private Employee employee;

	// Get fields from window
	@FXML Label lblUsersName;

	// Get fields from window
	@FXML TableView<ParceiroSimplesFormatado> tblPartners;
	@FXML TableColumn<ParceiroSimplesFormatado, String> colPartnerId;
	@FXML TableColumn<ParceiroSimplesFormatado, String> colPartnerCompanyName;
	@FXML TableColumn<ParceiroSimplesFormatado, String> colPartnerSubscription;
	@FXML TableColumn<ParceiroSimplesFormatado, String> colPartnershipDate;
	@FXML TableColumn<ParceiroSimplesFormatado, String> colPartnerEmail;
	@FXML TableColumn<ParceiroSimplesFormatado, String> colPartnerStatus;

    // Attributes
    private int idParceiro;
    private int idEndereco;
    private int idUsuario;
    private int idPlanoContratacao;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private int ativo;
    private int socorrista;
    private String email;
    private String telefone;
    private String celular;
    private String fotoPerfil;
    private String logParceiro;

    // Constructors
    public Partner(){}

    public Partner
    (
		int idParceiro,
		int idEndereco,
		int idUsuario,
		int idPlanoContratacao,
		String nomeFantasia,
		String razaoSocial,
	    String cnpj,
	    int ativo,
	    int socorrista,
	    String email,
	    String telefone,
	    String celular,
	    String fotoPerfil,
	    String logParceiro
    )
    {
    	this.idParceiro = idParceiro;
    	this.idEndereco = idEndereco;
    	this.idUsuario = idUsuario;
    	this.idPlanoContratacao = idPlanoContratacao;
    	this.nomeFantasia = nomeFantasia;
    	this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ativo = ativo;
		this.socorrista = socorrista;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.fotoPerfil = fotoPerfil;
		this.logParceiro = logParceiro;
    }
    
    public Partner
    (
		int idParceiro,
		int idPlanoContratacao,
		String nomeFantasia,
		String razaoSocial,
	    String cnpj,
	    int ativo,
	    int socorrista,
	    String email,
	    String telefone,
	    String celular,
	    String fotoPerfil
    )
    {
    	this.idParceiro = idParceiro;
    	this.idPlanoContratacao = idPlanoContratacao;
    	this.nomeFantasia = nomeFantasia;
    	this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.ativo = ativo;
		this.socorrista = socorrista;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.fotoPerfil = fotoPerfil;
    }

    public Partner(Employee employeeObj)
    {
    	this.employee = employeeObj;
    }
    
    // No idParceiro, idEndereco, logParceiro, ativo and idUsuario
    public Partner
    (
    	String nomeFantasia,		
		String razaoSocial,
	    String cnpj,
	    int socorrista,
	    String email,
	    String telefone,
	    String celular,
	    String fotoPerfil,
	    int idPlanoContratacao
    )
    {
    	this.idPlanoContratacao = idPlanoContratacao;
    	this.nomeFantasia = nomeFantasia;
    	this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.socorrista = socorrista;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.fotoPerfil = fotoPerfil;
    }
   //  ___________________________________________________><

	public int getIdParceiro() {
		return idParceiro;
	}
	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPlanoContratacao() {
		return idPlanoContratacao;
	}
	public void setIdPlanoContratacao(int idPlanoContratacao) {
		this.idPlanoContratacao = idPlanoContratacao;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public int getSocorrista() {
		return socorrista;
	}
	public void setSocorrista(int socorrista) {
		this.socorrista = socorrista;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	public String getLogParceiro() {
		return logParceiro;
	}
	public void setLogParceiro(String logParceiro) {
		this.logParceiro = logParceiro;
	}
	
	/**
	 * Get all informations about one partner
	 * @param partnerID Partner's ID that it will be achieve into DB
	 * @return ParceiroDetalhado Partner containing all data
	 * @return null Fail in try to get the partner's data into DB
	 */
	static public ParceiroDetalhado getFullPartnerById(int partnerID)
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.getFullPartnerById(partnerID);
	}

	/**
	 * Get employee amount existents into DB
	 * @return int Employee amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	static public int getPartnersAmount()
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.getPartnersAmount();
	}

	/**
	 * Get active partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	static public int getActivePartnersAmount()
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.getActivePartnersAmount();
	}

	/**
	 * Get inactive partners amount existents into DB
	 * @return int Partner amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	static public int getInactivePartnersAmount()
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.getInactivePartnersAmount();
	}

	/**
	 * Get all partners existents into DB
	 * @return ArrayList<ParceiroSimplesFormatado> Containing all partners
	 * @return empty ArrayList<ParceiroSimplesFormatado> Fail to attempt get partners into DB
	 */
	public ArrayList<ParceiroSimplesFormatado> getPartners()
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.getPartners();
	}

	/**
	 * Delete the partner from DB
	 * @param partnerId Partner's ID
	 * @return true Partner was deleted with successful
	 * @return false Fail on attempt to delete the partner from DB
	 */
	static public boolean deletePartner(int partnerId)
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.deletePartner(partnerId);
	}
	
	/**
	 * Update the partner in DB
	 * @param partnerObj Partner that will be updated into DB
	 * @return true Partner was updated with successful
	 * @return false Fail on attempt to updated the partner from DB
	 */
	public boolean updatePartner(Partner partnerObj)
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.updatePartner(partnerObj);
	}

	/**
	 * Insert a new partner into DB
	 * @param addressObj Address object that will inserted into DB
	 * @param userObj User object that will inserted into DB
	 * @param partnerObj Partner object that will inserted into DB
	 * @return int Last partner's record ID
	 * @return itn -1 Fail in try to insert some data into database
	 */
	public int insertPartner(Address addressObj, User userObj, Partner partnerObj)
	{
		PartnerDAO partnerDAO = new PartnerDAO();
		return partnerDAO.insertPartner(addressObj, userObj, partnerObj);
	}

	// ******************* CONTROLLER *******************
	@FXML public void initialize()
	{
		// Set some data into some field
		colPartnerId.setCellValueFactory(new PropertyValueFactory<ParceiroSimplesFormatado,String>("idParceiro"));
		colPartnerEmail.setCellValueFactory(new PropertyValueFactory<ParceiroSimplesFormatado,String>("email"));
		colPartnerCompanyName.setCellValueFactory(new PropertyValueFactory<ParceiroSimplesFormatado,String>("razaoSocial"));
		colPartnershipDate.setCellValueFactory(new PropertyValueFactory<ParceiroSimplesFormatado,String>("logParceiro"));
		colPartnerStatus.setCellValueFactory(new PropertyValueFactory<ParceiroSimplesFormatado,String>("ativo"));
		colPartnerSubscription.setCellValueFactory(new PropertyValueFactory<ParceiroSimplesFormatado,String>("plano"));

		ArrayList<ParceiroSimplesFormatado> partners = this.getPartners();

		tblPartners.setItems(FXCollections.observableArrayList(partners));

		// Show employee's name
		lblUsersName.setText(employee.getNome());
	}

	/**
	 * Delete selected partner
	 */
	@FXML public void deletePartner()
	{
		// Get selected row
		ParceiroSimplesFormatado clickedPartner = tblPartners.getSelectionModel().getSelectedItem();
		
		// Check if one row was selected
		if(clickedPartner != null)  // Row was selected
		{
			// Create a confirm dialog
			int dialog = Utils.confirmDialog(null, "Deseja realmente deletar o parceiro \""+clickedPartner.getRazaoSocial()+"\" ?", "Parceiro", JOptionPane.YES_NO_OPTION);

			// Verify user's answer
			if(dialog == JOptionPane.YES_OPTION)
			{
				// Check if partner was deleted
				if(Partner.deletePartner(clickedPartner.getIdParceiro()))
				{
					tblPartners.getItems().remove(clickedPartner);
				}
				else
				{
					Utils.showError(null, "Deletar Registro", "Falha ao tentar deletar o parceiro \""+clickedPartner.getRazaoSocial()+"\"");
				}
			}
		}

	}
	
	/**
	 * Update selected partner 
	 */
	@FXML public void updatePartner()
	{
		// Get selected row
		ParceiroSimplesFormatado clickedPartner = tblPartners.getSelectionModel().getSelectedItem();
		
		// Check if one row was selected
		if(clickedPartner != null)  // Row was selected
		{		
			// Open update partner window to see partner's data
			Main.openWindow("UpdatePartner", new UpdatePartner(employee, Partner.getFullPartnerById(clickedPartner.getIdParceiro())));
		}
	}

	// Open windows when click on "button"
	@FXML public void openAddPartner()
	{
		Main.openWindow("AddPartner", new AddPartner(employee));
	}

	@FXML public void openHomeWindow()
	{
		Main.openWindow("Home", new Home(employee));
	}

	@FXML public void openEmployeeWindow()
	{
		Main.openWindow("Employee", new Employee(employee));
	}

	@FXML public void openCompanyExpenseWindow()
	{
		Main.openWindow("CompanyExpense", new CompanyExpense(employee));
	}

	@FXML public void openEmployeeWageWindow()
	{
		Main.openWindow("EmployeeWage", new EmployeeWage(employee));
	}
	// **************************************************


}
