package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ValidationPasswordBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String password;
	
	public void save() {
		System.out.println("Saving password: "+ password);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
