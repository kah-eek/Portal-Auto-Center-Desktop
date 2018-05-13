package viewmodel;

public class FuncionarioDetalhado {
	
	private int idFuncionarioPac; 
	private String nome; 
	private String cpf; 
	private String rg; 
	private int usuarioAtivo; 
	private int idEndereco; 
	private String dtNascimento; 
	private int idCargoFuncionarioPac; 
	private String salario; 
	private char sexo; 
	private String celular; 
	private String email; 
	private String foto; 
	private String cnh; 
	private String pis; 
	private String certificadoReservista; 
	private String logFuncionarioPac; 
	private int idUsuario; 
	private String cargo; 
	private String logradouro; 
	private String numero; 
	private String cidade; 
	private int idEstado; 
	private String cep; 
	private String bairro; 
	private String complemento; 
	private String estado; 
	private String usuario; 
	private String senha; 
	private int idNivelUsuario; 
	private String log; 
	private String nivel;
	
	
	// Default constructor
	public FuncionarioDetalhado
	(
		int idFuncionarioPac, 
		String nome, 
		String cpf, 
		String rg, 
		int idEndereco,
		String dtNascimento, 
		int idCargoFuncionarioPac, 
		String salario, 
		char sexo, 
		String celular, 
		String email,
		String foto, 
		String cnh, 
		String pis, 
		String certificadoReservista, 
		String logFuncionarioPac, 
		int idUsuario,
		String cargo, 
		String logradouro, 
		String numero, 
		String cidade, 
		int idEstado, 
		String cep, 
		String bairro,
		String complemento, 
		String estado, 
		String usuario, 
		String senha, 
		int idNivelUsuario, 
		String log,
		String nivel,
		int usuarioAtivo
	) 
	{
	this.idFuncionarioPac = idFuncionarioPac;
	this.nome = nome;
	this.cpf = cpf;
	this.rg = rg;
	this.idEndereco = idEndereco;
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
	this.logFuncionarioPac = logFuncionarioPac;
	this.idUsuario = idUsuario;
	this.cargo = cargo;
	this.logradouro = logradouro;
	this.numero = numero;
	this.cidade = cidade;
	this.idEstado = idEstado;
	this.cep = cep;
	this.bairro = bairro;
	this.complemento = complemento;
	this.estado = estado;
	this.usuario = usuario;
	this.senha = senha;
	this.idNivelUsuario = idNivelUsuario;
	this.log = log;
	this.nivel = nivel;
	this.usuarioAtivo = usuarioAtivo;
	}
	// **************************************************

	

	public int getIdFuncionarioPac() {
		return idFuncionarioPac;
	}


	public int getUsuarioAtivo() {
		return usuarioAtivo;
	}



	public void setUsuarioAtivo(int usuarioAtivo) {
		this.usuarioAtivo = usuarioAtivo;
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


	public String getSalario() {
		return salario;
	}


	public void setSalario(String salario) {
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


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public int getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getIdNivelUsuario() {
		return idNivelUsuario;
	}


	public void setIdNivelUsuario(int idNivelUsuario) {
		this.idNivelUsuario = idNivelUsuario;
	}


	public String getLog() {
		return log;
	}


	public void setLog(String log) {
		this.log = log;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	

	
	
}
