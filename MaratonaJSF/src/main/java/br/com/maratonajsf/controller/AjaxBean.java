package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AjaxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String email;
	private Map<String, List<String>> map= new TreeMap<>();
	private String keySelecionada;
	private String valueSelecionado;
	private List<String> valuesSelecionados;
	
	
	{
		map.put("Chaves", Arrays.asList("Chaves","Chiquinha","Kiko"));
		map.put("Chris", Arrays.asList("Tônia","Chris","Draw"));
		map.put("Chapolim", Arrays.asList("Chapolim","Vilar","Touzo"));
	}
	
	public void selecaoPersonagens() {
		//A fim de fugir do nullPointer, caso o user volte p selecionar um personagem
		if(this.keySelecionada == null) {
			this.valuesSelecionados= null; //limpando o segundo comboBox
			return;
		}
		this.valuesSelecionados= this.map.get(keySelecionada);
	}
	
	public void modifyAttributes() {
		this.nome= this.nome.toUpperCase();
		this.sobrenome= this.sobrenome.toUpperCase();
	}
	
	public void modifyName() {
		this.nome= this.nome.toUpperCase();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public String getKeySelecionada() {
		return keySelecionada;
	}

	public void setKeySelecionada(String keySelecionada) {
		this.keySelecionada = keySelecionada;
	}

	public List<String> getValuesSelecionados() {
		return valuesSelecionados;
	}

	public void setValuesSelecionados(List<String> valuesSelecionados) {
		this.valuesSelecionados = valuesSelecionados;
	}

	public String getValueSelecionado() {
		return valueSelecionado;
	}

	public void setValueSelecionado(String valueSelecionado) {
		this.valueSelecionado = valueSelecionado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
