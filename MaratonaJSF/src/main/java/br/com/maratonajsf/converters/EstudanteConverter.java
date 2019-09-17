package br.com.maratonajsf.converters;

import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.maratonajsf.model.Estudante;

@FacesConverter(value="estudanteConverter")
public class EstudanteConverter implements Converter{

	private List<Estudante> list= Estudante.getList();
	
	//Métodos que fazem a conversão do objeto
	//Responsável p jogar dentro do model
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//Como iremos trabalhar diretamente com ID, o value precisa ser um number
		if(value == null || !value.matches("\\d+")) { 
			return null;
		}
		//Faz a consulta no banco, não consigo dar um getId na list, por isso a gambiarra
//		Estudante estudante= new Estudante();
//		estudante.setId(Integer.parseInt(value));
//		int index = list.indexOf(estudante); 		//é preciso implementar o equals p java saber diferenciar e comparar objetos pelo ID
//		list.get(index);
		return this.getAttributesFrom(component).get(value);
	}

	//Responsável p criar o valor dentro do combo
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null && !value.equals("")) {
			//Temos uma lista de estudante
			Estudante estudante= (Estudante) value;
			if(estudante.getId() != null) {
				this.addAttributes(component, estudante);
				return estudante.getId().toString(); //value será o id do estudante
			}
		}
		return null;
	}
	
	//Criação desses métodos p não ter que buscar no banco na view e aqui.
	private Map<String, Object> getAttributesFrom(UIComponent uiComponent){
		return uiComponent.getAttributes(); //pegando atributos dos componentes
	}
	
	private void addAttributes(UIComponent uiComponent, Estudante estudante) {//objeto que queremos add como atributo
		this.getAttributesFrom(uiComponent).put(estudante.getId().toString(), estudante);
		//add esse atributo quando uso o getAsString, pois ele quem mudou o value
	}

}
