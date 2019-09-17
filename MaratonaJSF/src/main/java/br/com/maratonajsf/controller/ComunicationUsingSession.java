package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;
import br.com.maratonajsf.util.ApplicationMapUtil;

@Named
@ViewScoped
public class ComunicationUsingSession implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Estudante> list= Estudante.getList();
	
	
	public String edit(Estudante e) {
		//Setando o objeto na sessão
		ApplicationMapUtil.setObjectInApplicationMapUtil("estudante", e);
		return "comunication-session2?faces-redirect=true";	
	}
	
	public List<Estudante> getList() {
		return list;
	}
	public void setList(List<Estudante> list) {
		this.list = list;
	}
	
	

}
