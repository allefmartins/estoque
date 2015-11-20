package br.alef.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.alef.model.UsuarioDAO;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String email;
	private String nome;
	private String senha;

	public void cadastrarUsuario() {
		UsuarioDAO.inserir(nome, email, senha);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Usuário cadastrado com sucesso!!", null));
		email = null;
		nome = null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
