package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String dataString;
	private Date date= new Date();
	
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct sendo chamado ComunicationBean");
		 dataString = new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	
	public void printAttributes() {
		String s = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("image.com");
		System.out.println("Value of parameter: "+ s);
	}
	
	public String toSail() {
		System.out.println("Comunication ----------> Comunication2");
		//Enviando parameters por get
		return"comunication2?faces-redirect=true&nome="+nome+"&sobrenome="+sobrenome;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}
	
	
}
