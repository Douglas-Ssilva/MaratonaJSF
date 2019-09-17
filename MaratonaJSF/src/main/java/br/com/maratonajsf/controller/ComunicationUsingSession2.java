package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;
import br.com.maratonajsf.util.ApplicationMapUtil;

@Named
@RequestScoped		//PRA NOTAR QUE O OBJETO FICA NA SESSÃO
public class ComunicationUsingSession2 implements Serializable{

	private static final long serialVersionUID = 1L;
	private Estudante estudante;
	private Estudante estudante2= new Estudante();
	
	public void init() {
		System.out.println("@RequestScoped --> init()");
		//Pegando o objeto da sessão
		estudante= (Estudante) ApplicationMapUtil.getValueFromApplicationMapUtil("estudante");
	}

	public void save() {
		System.out.println(estudante2.getNome());
		System.out.println(estudante2.getSobrenome());
	}
	
	public Estudante getEstudante() {
		return estudante;
	}


	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}


	public Estudante getEstudante2() {
		return estudante2;
	}


	public void setEstudante2(Estudante estudante2) {
		this.estudante2 = estudante2;
	}
	

}
