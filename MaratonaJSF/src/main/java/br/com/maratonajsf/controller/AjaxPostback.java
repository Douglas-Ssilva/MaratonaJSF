package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AjaxPostback implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, List<String>> map;
	private String nome;
	
	public void init() {
//		if(!FacesContext.getCurrentInstance().isPostback()) { //Se não for uma requsição ajax, execute
			System.out.println("==Init==");
			map= new TreeMap<>();
			map.put("Chaves", Arrays.asList("Chaves","Chiquinha","Kiko"));
			map.put("Chris", Arrays.asList("Tônia","Chris","Draw"));
			map.put("Chapolim", Arrays.asList("Chapolim","Vilar","Touzo"));
//		}
	}
	
	public void modifyName() {
		this.nome= this.nome.toUpperCase();
	}
	public Map<String, List<String>> getMap() {
		return map;
	}
	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
