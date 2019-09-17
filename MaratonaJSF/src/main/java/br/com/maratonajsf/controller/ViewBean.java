package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ViewBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado= new ArrayList<>();
	
	//COM o inject posso usar qualquer propriedade e métodos desses beans.
	private final DependetBean dependentBean;
	private final SessionScopedBean sessionScoped;
	
	@Inject
	public ViewBean(DependetBean dependentBean, SessionScopedBean sessionScoped) {
		this.dependentBean = dependentBean;
		this.sessionScoped = sessionScoped;
	}

	@PostConstruct
	public void init() {
		personagens= Arrays.asList("Cézar","Wakanda","Justiceira");
		System.out.println("@ViewScoped -> sendo chamado a cada aba que se abre");
	}
	
	public void selecionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String p= this.personagens.get(index);
		this.personagemSelecionado.add(p);
		dependentBean.addPersonagem(p);
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

	public DependetBean getDependentBean() {
		return dependentBean;
	}

// forço da view p pegar direto do bean session
//	public SessionScopedBean getSessionScoped() {
//		return sessionScoped;
//	}
	
	
}
