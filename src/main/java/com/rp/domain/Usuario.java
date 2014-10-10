package com.rp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import com.rp.repository.jpa.listener.RepositoryEntityListener;

@Entity
@EntityListeners(RepositoryEntityListener.class)
public class Usuario extends BaseEntity {

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "login", length = 30, nullable = false)
	private String login;

	@Column(name = "senha", length = 20, nullable = false)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login + ", senha="
				+ senha + "]";
	}

}
