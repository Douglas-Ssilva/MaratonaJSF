package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@SessionScoped
public class SessionScopedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado= new ArrayList<>();
	private Estudante estudante;
	
    @PostConstruct	                        
	public void init() {
		System.out.println("@SessionScoped -> É somente ao iniciar a sessão");
		personagens= Arrays.asList("Goku", "Gohan","Kuririn","Kamissamá");
		logar();
	}
    
    private void logar() {
    	System.out.println("Logando no BD");
    	System.out.println("Fazendo a validação");
    	estudante= new Estudante();
    }
	
	//invalidando a sessão
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "session?faces-redirect=true";
	}
	
	public void selecionarPersonagem() {
		int index= ThreadLocalRandom.current().nextInt(4);
		this.personagemSelecionado.add(personagens.get(index));
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
}
