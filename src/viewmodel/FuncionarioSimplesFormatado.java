package viewmodel;

public class FuncionarioSimplesFormatado {
	
	private int idFuncionarioPac;
	private String nome;
	private int idCargoFuncionarioPac;
	private String dataAdmissao;
	private String email;
	private String celular;
	private String cargo;
	
	// Default constructor
	public FuncionarioSimplesFormatado
	(
		int idFuncionarioPac, 
		String nome, 
		int idCargoFuncionarioPac,
		String dataAdmissao, 
		String email, 
		String celular, 
		String cargo
	)
	{
		this.idFuncionarioPac = idFuncionarioPac;
		this.nome = nome;
		this.idCargoFuncionarioPac = idCargoFuncionarioPac;
		this.dataAdmissao = dataAdmissao;
		this.email = email;
		this.celular = celular;
		this.cargo = cargo;
	}
	
	public int getIdFuncionarioPac() {
		return idFuncionarioPac;
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
	public int getIdCargoFuncionarioPac() {
		return idCargoFuncionarioPac;
	}
	public void setIdCargoFuncionarioPac(int idCargoFuncionarioPac) {
		this.idCargoFuncionarioPac = idCargoFuncionarioPac;
	}
	public String getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
