package viewmodel;

public class PagamentoFuncionarioDetalhadoFormatado {
	
	private int  idPagamentoFuncionarioPac; 
	private int idFuncionarioPac; 
	private String pago; 
	private String mesPagamento; 
	private String dataPagamentoRealizado; 
	private String nome;
	private float salario;
	
	// Default constructor
	public PagamentoFuncionarioDetalhadoFormatado
	(
			int idPagamentoFuncionarioPac, 
			int idFuncionarioPac, 
			String pago,
			String mesPagamento, 
			String dataPagamentoRealizado, 
			String nome,
			float salario
	) 
	{
		this.idPagamentoFuncionarioPac = idPagamentoFuncionarioPac;
		this.idFuncionarioPac = idFuncionarioPac;
		this.pago = pago;
		this.mesPagamento = mesPagamento;
		this.dataPagamentoRealizado = dataPagamentoRealizado;
		this.nome = nome;
		this.salario = salario;
	}
	// *****************************************************

	
	
	public int getIdPagamentoFuncionarioPac() {
		return idPagamentoFuncionarioPac;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public void setIdPagamentoFuncionarioPac(int idPagamentoFuncionarioPac) {
		this.idPagamentoFuncionarioPac = idPagamentoFuncionarioPac;
	}

	public int getIdFuncionarioPac() {
		return idFuncionarioPac;
	}

	public void setIdFuncionarioPac(int idFuncionarioPac) {
		this.idFuncionarioPac = idFuncionarioPac;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public String getMesPagamento() {
		return mesPagamento;
	}

	public void setMesPagamento(String mesPagamento) {
		this.mesPagamento = mesPagamento;
	}

	public String getDataPagamentoRealizado() {
		return dataPagamentoRealizado;
	}

	public void setDataPagamentoRealizado(String dataPagamentoRealizado) {
		this.dataPagamentoRealizado = dataPagamentoRealizado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
