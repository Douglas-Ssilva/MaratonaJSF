package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@ViewScoped
public class BenValidation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Validando no bean
	@Size(min=3, max=10, message="O nome deve ter entre 3 e 10 caracteres")
	@NotNull(message="Nome não pode ser nulo")
	private String nome;
	
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",message="Email inválido!")
	private String email;
	
	@DecimalMax(value= "20.00", message="Valor máximo: 20.00")
	@DecimalMin(value= "1.05", message="Valor mínimo: 1.05")
	private double decimal;
	
	@Digits(fraction=2 ,integer=3, message="Valor máximo: 999.99") //pode ter 3 números inteiros e 2 fracionários
	private double numero;
	
	public void save() {
		System.out.println(nome.isEmpty());
		System.out.println(nome);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}

	public double getDecimal() {
		return decimal;
	}

	public void setDecimal(double decimal) {
		this.decimal = decimal;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
