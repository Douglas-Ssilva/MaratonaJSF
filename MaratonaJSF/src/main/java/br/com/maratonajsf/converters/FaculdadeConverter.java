package br.com.maratonajsf.converters;

import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.maratonajsf.model.Faculdade;

@FacesConverter(value="faculdadeConverter")
public class FaculdadeConverter implements Converter {

	private List<Faculdade> list= Faculdade.getList();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || !value.matches("\\d+")) {
			return null;
		}
//		Faculdade faculdade= new Faculdade();
//		faculdade.setId(Integer.parseInt(value));
//		int index = list.indexOf(faculdade);
//		list.get(index);
		return this.getAttributes(component).get(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null && !value.equals("")) {
			Faculdade faculdade= (Faculdade) value;
			if(faculdade.getId() != null) {
				this.addAttributes(component, faculdade);
				return faculdade.getId().toString(); //Na inspeção de elementos mostra o id
			}
		}
		return null;
	}
	
	private Map<String, Object> getAttributes(UIComponent component){
		return component.getAttributes();
	}
	
	private void addAttributes(UIComponent component, Faculdade faculdade) {
		this.getAttributes(component).put(faculdade.getId().toString(), faculdade);
	}

}
