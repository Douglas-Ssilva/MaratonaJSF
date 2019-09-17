package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ComunicacaoAttributes implements Serializable{

	private static final long serialVersionUID = 1L;
	private String button= "Nome definido no Bean";
	private Estudante estudante= new Estudante();
	
	
	//preciso desse param p pegar os atributos que setei na view
	public void execute(ActionEvent event) {
		String nome= (String) event.getComponent().getAttributes().get("nome");
		String sobrenome= (String) event.getComponent().getAttributes().get("sobrenome");
		Estudante estudante= (Estudante)event.getComponent().getAttributes().get("estudante");
		String test= (String)event.getComponent().getAttributes().get("test");
		
		System.out.println(nome);
		System.out.println(sobrenome);
		System.out.println(estudante.getNome());
		System.out.println(test);
	}
	
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	
	
}
