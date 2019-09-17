package flowbuilder;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class NewRegistrationFlowBuilder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//convenção de nome de método
	//meu container irá inicializar esse método assim que start o server
	@Produces	
	@FlowDefinition
	public Flow defineFlow(@FlowBuilderParameter FlowBuilder builder) { 
		String idFlow= "newregistration";
		builder.id("", idFlow); 		//add o id ao flow
		
		//Definindo as view que temos na pasta newregistration
		builder.viewNode(idFlow, "/newregistration/newregistration.xhtml").markAsStartNode(); //o start será nessa página
		builder.viewNode(idFlow, "/newregistration/newregistration2.xhtml");
		builder.viewNode(idFlow, "/newregistration/newregistration3.xhtml");
		
		//Da primeira página, chamo o switchNome, defaul falo p ficar na mesma página
		builder.switchNode("switchNode").defaultOutcome(idFlow).switchCase()
		.condition("#{not empty newFlowRegistration.nome and not empty newFlowRegistration.sobrenome}")
		.fromOutcome("newregistration2");		
		//se os dados estiverem preenchidos, entre aqui
		//com xhtml a página não entra
		
		//chamo esse node da página 2
		builder.flowCallNode("callRegistrationPendencies")
		.flowReference("", "newpendencies") 		//param nulo como p setar id p builder, nome do id do flow interno
		.outboundParameter("userName", "#{newFlowRegistration.nome}")
		.outboundParameter("lastName", "#{newFlowRegistration.sobrenome}");		
		
		//return
		builder.returnNode("exitToInicio").fromOutcome("/inicio-flow.xhtml");
		
		//sempre irá executar esse método, independente do retorno
		builder.finalizer("#{newFlowRegistration.finaliza()}");
		return builder.getFlow();
	}

}
