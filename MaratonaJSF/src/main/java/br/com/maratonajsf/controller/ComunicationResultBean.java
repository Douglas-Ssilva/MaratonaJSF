package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicationResultBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	
	public void init() {
		System.out.println(nome);
		System.out.println(sobrenome);
	}
	
	public String save() {
		return "result?faces-redirect=true&includeViewParams=true";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	

}
