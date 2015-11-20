package br.alef.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import br.alef.model.Usuario;
import br.alef.model.UsuarioDAO;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String email;
	private String nome;
	private String senha;
	private Usuario usuario;
	private List<Usuario> usuarios;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	public void cadastrarUsuario() {
		UsuarioDAO.inserir(nome, email, senha);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Usuário cadastrado com sucesso!!", null));
		email = null;
		nome = null;
	}

	public void pesquisarUsuarios() {
		usuarios = UsuarioDAO.pesquisarUsuarios(usuario);
	}

	public void limparDados() {

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
