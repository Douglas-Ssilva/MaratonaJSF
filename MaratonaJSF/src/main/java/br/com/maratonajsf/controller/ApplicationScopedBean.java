package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ApplicationScopedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> nomes;
	
	@PostConstruct
	public void init() {
		System.out.println("@ApplicationScoped -> sendo chamado quando a aplicação sobe somente");
		nomes= Arrays.asList("Helena","Luciana","Cézar");
	}
	
	public void mudarList() {
		nomes= Arrays.asList("Helena","Luciana","Cézar","MaisUm");
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	
}
