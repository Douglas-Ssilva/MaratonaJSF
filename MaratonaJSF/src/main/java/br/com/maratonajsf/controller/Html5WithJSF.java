package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class Html5WithJSF implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> map= new HashMap<>();
	
	public void init() {
		System.out.println("==Init==");
		map.put("type", "number");
		map.put("placeholder", "Type the numbers");
		map.put("min", "0");
		map.put("max", "100");
	}
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
