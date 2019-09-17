package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ComunicationInputSecret implements Serializable{

	private static final long serialVersionUID = 1L;
	private String password;
	private List<Estudante> list= Estudante.getList();
	
	
	public void remove(Estudante e) {
		System.out.println(e);
		list.remove(e);
	}
	
	public void save() {
		System.out.println(password);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Estudante> getList() {
		return list;
	}
	public void setList(List<Estudante> list) {
		this.list = list;
	}
	
	

}
