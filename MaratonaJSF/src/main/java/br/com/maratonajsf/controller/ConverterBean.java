package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.maratonajsf.model.Estudante;
import br.com.maratonajsf.model.Faculdade;

@Named
@ViewScoped
public class ConverterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Estudante> listEstudante= Estudante.getList();
	private List<Faculdade> listFaculdade= Faculdade.getList();
	private Estudante estudante;
	private Faculdade faculdade;
	
	public void save() {
		System.out.println("Salvando no banco");
		System.out.println(estudante);
		System.out.println(faculdade);
	}
	
	public List<Estudante> getListEstudante() {
		return listEstudante;
	}
	public void setListEstudante(List<Estudante> listEstudante) {
		this.listEstudante = listEstudante;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public Faculdade getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	public List<Faculdade> getListFaculdade() {
		return listFaculdade;
	}

	public void setListFaculdade(List<Faculdade> listFaculdade) {
		this.listFaculdade = listFaculdade;
	}
}
