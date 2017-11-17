package br.com.fiap.entity;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private int idCliente;
	private String nome;
	private String email;
	
	public Cliente() {	}

	public Cliente(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Cliente(int idCliente, String nome, String email) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return this.idCliente +", "+ this.nome +", "+ this.email;
	}
}
