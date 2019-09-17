package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ComucationFlashScopeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Estudante> list= Estudante.getList();
	
	public String edit(int index) {
		Estudante estudante= list.get(index);
		//Forma de colocar o objeto inteiro e sobreviverá por um redirecionamento, depois será morto
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("estudante", estudante);
		return "comunication-flash-scope2?faces-redirect=true";
	}
	
	public List<Estudante> getList() {
		return list;
	}
	public void setList(List<Estudante> list) {
		this.list = list;
	}
	
	
	

}
