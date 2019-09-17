package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ComunicationBean3 implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String data;
	private String dataOminiFaces;
	private String dataString;
	private Date dataParseada;
	private Date dataConverter;
	
	//@PostConstruct é executado antes de renderizar a view, por isso os dados chegam null
	public void init() throws ParseException {
		//Pra não ser executado sempre que o ajax faz algo, uso assim:
//		if(!FacesContext.getCurrentInstance().isPostback()) {
			System.out.println("Entrou no Communication3");	
			System.out.println(nome);
			System.out.println(sobrenome);
			dataParseada= new SimpleDateFormat("dd-MM-yyyy").parse(dataString);
//		}
	}

	public String save() {
		System.out.println("==============");	
		System.out.println("Salvando no BD");	
		System.out.println("==============");
		return "result?faces-redirect=true&amp;includeViewParams=true";
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public Date getDataParseada() {
		return dataParseada;
	}

	public void setDataParseada(Date dataParseada) {
		this.dataParseada = dataParseada;
	}

	public String getDataOminiFaces() {
		return dataOminiFaces;
	}

	public void setDataOminiFaces(String dataOminiFaces) {
		this.dataOminiFaces = dataOminiFaces;
	}

	public Date getDataConverter() {
		return dataConverter;
	}

	public void setDataConverter(Date dataConverter) {
		this.dataConverter = dataConverter;
	}

	
}
