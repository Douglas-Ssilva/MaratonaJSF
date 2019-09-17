package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;

import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class ComunicationCookieBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	
	
	public void init() {
		//pegando todos os cookies
		Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		
		//Salvando cookie sem OmniFaces
//		Cookie cookie= (Cookie)requestCookieMap.get("nome"); //passando o valor da chave direto, pois colocando key daria null
//		System.out.println("Nesse ponto tenho o valor como se aparecesse na URL "+cookie.getValue());
//		//decodificando
//		try {
//			String decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
//			System.out.println(decode);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		
		//Save cookie with OmniFaces
		System.out.println(Faces.getRequestCookie("nome"));
		
	}
	
	public void salvarCookie() {
		//salvando cookie com OmniFaces
		// -1 fica vivo durante a sessão, 0 não salva o cookie e qualquer number a quantidade de segundos que ficará ativo
		Faces.addResponseCookie(key, value, -1);
	}
	
	public String toSail() {
		return "comunication-cookie2?faces-redirect=true";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
