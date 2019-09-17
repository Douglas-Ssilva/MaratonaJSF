package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Param;

@Named
@ViewScoped
public class Comunication2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//melhor prática usando CDI
	@Inject @Param(name="nome")
	private String nome;
	
	@Inject @Param(name="sobrenome")
	private String sobrenome;
	
	@PostConstruct
	public void init() {
		System.out.println("Comunication2");
		//recebendo parameters, não é a melhor prática
//		Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//		nome= param.get("nome");
//		sobrenome= param.get("sobrenome");
		System.out.println(nome);
		System.out.println(sobrenome);
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
