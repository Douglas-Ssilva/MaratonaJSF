package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;

@Named
@ViewScoped
public class DataTableBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Estudante> listEstudante= Estudante.getList();
	private Set<Estudante> listSetEstudante= new HashSet<>(listEstudante);
	private List<Estudante> listLinkedEstudante= new LinkedList<>(listEstudante);
	private Map<String, Estudante> mapEstudante= new HashMap<>();
	private Estudante estudante= new Estudante();
	private static int index= 5;
	
	public void init() {
		//Map não é um collection
		mapEstudante.put("estudante1",new Estudante(1,"Chefão", "Alves", 10.0));
		mapEstudante.put("estudante2", new Estudante(2,"Luigi", "Santos", 10.0));
		mapEstudante.put("estudante3", new Estudante(3,"Mário", "Brother", 10.0));
//		mapEstudante.values(); retorna uma Collection de Estudante
	}
	
	public void orderByName(String order) {
		if(order.equals("asc")) {
			listEstudante.sort(Comparator.comparing(Estudante::getNome));
		}else {
			listEstudante.sort(Comparator.comparing(Estudante::getNome).reversed());
		}
	}
	
	public void orderByNameLinked(String order) {
		if(order.equals("asc")) {
			listLinkedEstudante.sort(Comparator.comparing(Estudante::getNome));
		}else {
			listLinkedEstudante.sort(Comparator.comparing(Estudante::getNome).reversed());
		}
	}
	
	public void orderBySobrenome(String order) {
		if(order.equals("asc")) {
			listEstudante.sort(Comparator.comparing(Estudante::getSobrenome));
		}else {
			listEstudante.sort(Comparator.comparing(Estudante::getSobrenome).reversed());
		}
	}
	
	public void edit(Estudante e) {
		e.setEditing(true);	//Habilita o input
	}
	
	public void save() {
		//Percorro p saber qual está em edição
		for (Estudante estudante : listEstudante) {
			if(estudante.isEditing()) {
				System.out.println(estudante);
				estudante.setEditing(false);
			}
		}
	}
	
	public void saveSet() {
		//Percorro p saber qual está em edição
		for (Estudante estudante : listSetEstudante) {
			if(estudante.isEditing()) {
				System.out.println(estudante);
				estudante.setEditing(false);
			}
		}
	}
	
	public void delete(Estudante estudante) {
		listEstudante.remove(estudante);
	}
	
	public void deleteSet(Estudante estudante) {
		listSetEstudante.remove(estudante);
	}
	
	public void add() {
		estudante.setId(index++);
		this.listEstudante.add(estudante);
		System.out.println(estudante);
		estudante= new Estudante();
	}
	
	public void addSet() {
		this.estudante.setId(index++);
		this.listSetEstudante.add(estudante);
		System.out.println(estudante);
		this.estudante= new Estudante();
	}
	
	public List<Estudante> getListEstudante() {
		return listEstudante;
	}
	public void setListEstudante(List<Estudante> listEstudante) {
		this.listEstudante = listEstudante;
	}
	public Set<Estudante> getListSetEstudante() {
		return listSetEstudante;
	}
	public void setListSetEstudante(Set<Estudante> listSetEstudante) {
		this.listSetEstudante = listSetEstudante;
	}
	public List<Estudante> getListLinkedEstudante() {
		return listLinkedEstudante;
	}
	public void setListLinkedEstudante(List<Estudante> listLinkedEstudante) {
		this.listLinkedEstudante = listLinkedEstudante;
	}
	public Map<String, Estudante> getMapEstudante() {
		return mapEstudante;
	}
	public void setMapEstudante(Map<String, Estudante> mapEstudante) {
		this.mapEstudante = mapEstudante;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	
	
}
