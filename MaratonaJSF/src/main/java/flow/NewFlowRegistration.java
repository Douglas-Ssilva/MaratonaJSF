package flow;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="newregistration")
public class NewFlowRegistration implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String endereco;
	
	public String salvar() {
		System.out.println("Salvando dados no BD");
		System.out.println(nome);
		System.out.println(sobrenome);
		System.out.println(endereco);
		return "";
	}
	
	public void finaliza() {
		System.out.println("Sempre sou executado");
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	

}
