package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class ComunicationSetProperty implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private Estudante estudante= new Estudante();
	private Estudante estudante2;

	public void execute() {
		System.out.println("Dentro do execute: "+ nome);
		System.out.println("Dentro do execute: "+ sobrenome);
		System.out.println("Dentro do execute: "+ estudante2.getNome());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		System.out.println("Setando o nome: "+ nome);
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		System.out.println("Setando o sobrenome: "+ sobrenome);
		this.sobrenome = sobrenome;
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
