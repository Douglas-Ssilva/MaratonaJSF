package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ValidateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estudante estudante= new Estudante();
	
	public void save() {
		System.out.println("Salvando no banco");
		System.out.println(estudante.getEmail());
	}
	
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	

}
