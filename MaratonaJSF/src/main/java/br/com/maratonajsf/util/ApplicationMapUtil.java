package br.com.maratonajsf.util;

import javax.faces.context.FacesContext;

public class ApplicationMapUtil {
	
	//Pegando objeto da sessão
	public static Object getValueFromApplicationMapUtil(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
	}
	
	//Setando objeto da sessão
	public static void setObjectInApplicationMapUtil(String key, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key,value);
	}

}
