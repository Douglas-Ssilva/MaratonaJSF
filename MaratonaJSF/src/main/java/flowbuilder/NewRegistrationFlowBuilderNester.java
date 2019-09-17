package flowbuilder;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class NewRegistrationFlowBuilderNester implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Produces
	@FlowDefinition
	public Flow defineFlow(@FlowBuilderParameter FlowBuilder builder) {
		String flowId= "newpendencies";
		builder.id("",flowId);
		builder.viewNode(flowId,"/newpendencies/newpendencies.xhtml").markAsStartNode();
		
		//recebendo os parâmetros
		builder.inboundParameter("userName", "#{newFlowScopedBuilder.userName}")
		.inboundParameter("lastName", "#{newFlowScopedBuilder.lastName}");
		
		builder.returnNode("exit").fromOutcome("/newregistration/newregistration3.xhtml");
		return builder.getFlow();
	}

}
