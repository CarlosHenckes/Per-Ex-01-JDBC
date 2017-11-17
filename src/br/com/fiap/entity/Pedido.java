package br.com.fiap.entity;

import java.io.Serializable;
import java.sql.Date;

public class Pedido implements Serializable {
	private int idPedido;
	private int idCliente;
	private Date data;
	private String descricao;
	private double valor;
	
	public Pedido() {	}
	
	public Pedido(int idCliente, Date data, String descricao, double valor) {
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Pedido(int idPedido, int idCliente, Date data, String descricao, double valor) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return this.idPedido +", "+ this.idCliente +", "+ 
					this.descricao +", "+ this.data +", "+ this.valor;
	}
}
