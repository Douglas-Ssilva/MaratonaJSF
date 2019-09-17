package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ViewExpiredBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	
	public String invalidate() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"/login?faces-redirect=true";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
