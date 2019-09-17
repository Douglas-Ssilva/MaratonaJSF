package br.com.maratonajsf.controller;


import java.io.Serializable;

import javax.el.LambdaExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
 
import br.com.maratonajsf.model.Estudante;

@ManagedBean
@ViewScoped
public class EstudanteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Estudante estudante= new Estudante();
	private boolean mostrarNotas;
	private boolean mostrarLink;
	
	public void executar() {
		System.out.println("------------Fazendo busca no BD------------");
	}
	
	public void executar(String nome) {
		System.out.println("Param: "+ nome);
	}
	
	public String executarRetorno(String nome) {
		return ("Retornando p view: "+ nome);
	}
	
	public String proxPagina() {
		return "index.xhtml?faces-redirect=true";
	}
	
	public void exibirNotas() {
		this.mostrarNotas= true;
	}
	
	public void esconderNotas() {
		this.mostrarNotas= false;
	}
	
	public void exibirLink() {
		this.mostrarLink= true;
	}
	
	public void esconderLink() {
		this.mostrarLink= false;
	}
	
	public void calcularCubo(LambdaExpression le ,long number) {
		long result =(long) le.invoke(FacesContext.getCurrentInstance().getELContext(), number);
		System.out.println(result);
	}
	
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public boolean isMostrarNotas() {
		return mostrarNotas;
	}

	public void setMostrarNotas(boolean mostrarNotas) {
		this.mostrarNotas = mostrarNotas;
	}

	public boolean isMostrarLink() {
		return mostrarLink;
	}

	public void setMostrarLink(boolean mostrarLink) {
		this.mostrarLink = mostrarLink;
	}
	
	
	

	

}
