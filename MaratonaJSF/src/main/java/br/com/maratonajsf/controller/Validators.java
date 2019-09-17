package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;


@Named
@RequestScoped //Não precisa sobreviver a mais que uma requisição

//Outra forma de colocar as validações, criando métodos, assim não preciso criar uma classe p cada validação
//Pra cada validação crio um método
public class Validators implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> listEmail= Arrays.asList("igor@email.com","inez@email.com","geraldo@email.com");
	@Inject
	private LoginBean login;
	
	public void validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String email= (String) value;
		System.out.println("Injeção de dependencia funcionando "+login.getLogin());
		
		if(listEmail.contains(email)) {
			FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email já existe na base!","");
			throw new ValidatorException(message);
		}
	}
	
	public void validateUpload(FacesContext context, UIComponent component, Object value) {
		Part file= (Part) value;
		try {
			this.validateNameLength(file);
			this.validateFileSize(file);
			this.validateContentType(file);
		}catch(RuntimeException e) {
			FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"");
			throw new ValidatorException(message);
		}
	}

	private void validateContentType(Part file) {
		if(!file.getContentType().equals("image/png") && !file.getContentType().equals("image/jpeg")) {
			System.out.println(file.getContentType());
			throw new RuntimeException("Apenas imagem PNG e JPGE!");
		}
	}

	private void validateFileSize(Part file) {
		if(file.getSize() > 1048576) {
			throw new RuntimeException("O tamanho do file excedeu 1MB!");
		}
	}

	private void validateNameLength(Part file) {
		if(file.getSubmittedFileName().length() > 10) {
			throw new RuntimeException("Nome maior que 10 caracteres!");
		}
	}

}
