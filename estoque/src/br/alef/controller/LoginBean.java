package br.alef.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.alef.model.LoginDAO;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String email;
	private String senha;

	public String validar() {
		String nome = LoginDAO.validar(email, senha);
		if (nome != null) {
			HttpSession session = SessionBean.getSession();
			session.setAttribute("nomeUsuario", nome);
			return "acesso";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	public String sair() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";
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
		return SessionBean.getNomeUsuario();
	}
}
