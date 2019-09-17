package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Estudante estudante;
	private String login;
	private String senha;
	private List<Locale> list= Arrays.asList(new Locale("en"),new Locale("pt"));
	private String language;
	private int qtdMensagens;
	
	
	public String logar() {
		if(login.equals("admin") && senha.equals("1")) {
			estudante= new Estudante();
			qtdMensagens++;
			return "/restricted/access-released.xhtml";
		}
		
		FacesContext context= FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos!", ""));
		return "/login.xhtml";
	}
	
	public String logout() {
		System.out.println("Logout");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//ajuda na verificação no filter
		estudante= null;
		return "/login?faces-redirect=true";
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

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public List<Locale> getList() {
		return list;
	}

	public void setList(List<Locale> list) {
		this.list = list;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getQtdMensagens() {
		return qtdMensagens;
	}

	public void setQtdMensagens(int qtdMensagens) {
		this.qtdMensagens = qtdMensagens;
	}
}
