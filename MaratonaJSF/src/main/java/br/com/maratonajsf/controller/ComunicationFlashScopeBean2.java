package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ComunicationFlashScopeBean2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private Estudante estudante;
	
	//sendo chamado pela tag viewAction
	public void init() {
		System.out.println("ComunicationFlashScopeBean2 init sendo chamado...");
		//recebendo o ben
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		estudante = (Estudante) flash.get("estudante");
	}
	
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	

}
