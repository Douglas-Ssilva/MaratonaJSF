package br.com.maratonajsf.validators;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import br.com.maratonajsf.controller.LoginBean;

//Com esta annotation falo que é um validate
@FacesValidator
public class DuplicateEmailValidator implements Validator{

	private List<String> listEmail= Arrays.asList("douglas@email.com","tatai@email.com");
	
	@Inject
	private LoginBean login;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String email= (String) value;
		System.out.println("Injeção de dependencia funcionando "+login.getLogin());
		
		if(listEmail.contains(email)) {
			FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email já existe na base!","");
			throw new ValidatorException(message);
		}
	}
	
	public List<String> getListEmail() {
		return listEmail;
	}

	public void setListEmail(List<String> listEmail) {
		this.listEmail = listEmail;
	}


}
