package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped //respondeu e morreu
public class RequestBean implements Serializable{

	private static final long serialVersionUID = -8902918231107807316L;
	private List<String> personagens;
	private List<String> personagemSelecionado= new ArrayList<>();
	
	@PostConstruct
	public void init() {
		System.out.println("@RequestScoped -> É chamado a cada requisição");
		personagens= Arrays.asList("Douglas","Inez","Tatai","Geraldo","Igor");
	}
	
	public void escolherPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(4);
		personagemSelecionado.add(personagens.get(index));
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
