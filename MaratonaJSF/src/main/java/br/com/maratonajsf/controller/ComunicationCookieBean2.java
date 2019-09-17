package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class ComunicationCookieBean2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private String value;
	
	
	public void init() {
		value= Faces.getRequestCookie("nome"); //pegando o valor da chave digitada no input
		System.out.println(value);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
