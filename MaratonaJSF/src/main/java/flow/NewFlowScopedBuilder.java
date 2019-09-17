package flow;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="newpendencies")
public class NewFlowScopedBuilder implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String lastName;
	
	public String validar() {
		System.out.println("Salvando no BD");
		System.out.println(userName);
		System.out.println(lastName);
		return "exit";
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
