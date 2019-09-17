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
public class TesteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, List<String>> map= new TreeMap<>();
	private String keySelecionada;
	private String valueSelecionado;
	private List<String> valuesSelecionados;
	
	{
		this.map.put("Cruzeiro", Arrays.asList("Fábio","Dedé","Geraldo"));
		this.map.put("América", Arrays.asList("Messias","Matheusinho","Juninho"));
		this.map.put("Atlético", Arrays.asList("Cazáres","Zé","Victor"));
	}
	
	public void characterSelection() {
		if(this.keySelecionada == null) {
			this.valuesSelecionados= null;
			return;
		}
		this.valuesSelecionados= this.map.get(keySelecionada);
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

	public String getValueSelecionado() {
		return valueSelecionado;
	}

	public void setValueSelecionado(String valueSelecionado) {
		this.valueSelecionado = valueSelecionado;
	}

	public List<String> getValuesSelecionados() {
		return valuesSelecionados;
	}

	public void setValuesSelecionados(List<String> valuesSelecionados) {
		this.valuesSelecionados = valuesSelecionados;
	}
	

}
