package br.com.maratonajsf.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="pendencies")
public class FlowScopedAninhado implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String lastName;
	
	public String validar() {
		System.out.println("Consulta no banco");
		System.out.println("Consulta no SERASA");
		//Simulando um erro, adicionando mensagem de error
		if(true) {
			FacesContext context= FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User não passou nas pendencias", "Algum detalhe"));
			return null;
		}
		return "exitToRegistration";		//Tem como regra retorna p flow externo.Chamo meu file de config que redireciona
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
