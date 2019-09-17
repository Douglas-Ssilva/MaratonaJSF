package br.com.maratonajsf.controller;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;

@FacesBehavior(value="confirm")
public class TaglibBen extends ClientBehaviorBase{
	
	@Override
	public String getScript(ClientBehaviorContext behaviorContext) {
		return "return confirm('Você tem certeza?');";
	}
}
