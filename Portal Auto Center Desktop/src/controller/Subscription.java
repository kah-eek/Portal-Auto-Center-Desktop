package controller;

import model.SubscriptionDAO;

public class Subscription {

	// Attributes
	private int idPlanoContratacao;
	private String plano;
	private float valor;
	private String descricao;
	
	public int getIdPlanoContratacao() {
		return idPlanoContratacao;
	}
	public void setIdPlanoContratacao(int idPlanoContratacao) {
		this.idPlanoContratacao = idPlanoContratacao;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Get profit amount got on partner's subscriptions
	 * @return int Profit amount
	 * Obs.: Returns -1 if it got some problem during attempt to get data
	 */
	static public float getAllProfitValue()
	{
		SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
		return subscriptionDAO.getAllProfitValue();
	}
	
	
}
