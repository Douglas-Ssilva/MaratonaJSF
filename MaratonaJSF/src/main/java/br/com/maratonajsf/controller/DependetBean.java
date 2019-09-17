package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class DependetBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado= new LinkedList<>();
	
	
	@PostConstruct
	public void init() {
		System.out.println("@Dependet sendo iniciado. Age conforme o scoped que é injetado.");
		personagens= Arrays.asList("Kamissamá","Goku","Gohan");
	}
	
	public void selecionarPersonagem() {
		int i = ThreadLocalRandom.current().nextInt(3);
		personagemSelecionado.add(personagens.get(i));
	}
	
	public void addPersonagem(String p) {
		this.personagemSelecionado.add(p);
	}
	
	public List<String> getPersonagens() {
		return personagens;
	}
	public void setPersonagens(List<String> personagens) {
		this.personagens = personagens;
	}
	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}
	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}
	
	
	

}
