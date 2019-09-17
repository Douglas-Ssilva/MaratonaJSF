package br.com.maratonajsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ConversationScopedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado= new ArrayList<>();
	
	//container fica responsável por injetar esse objeto aqui, não me preocupo com a criação dele
	@Inject
	private Conversation conversation;
	
	public void init() {
		System.out.println("@ConversationScoped -> next next acept final");
		personagens= Arrays.asList("Cézar","Wakanda","Justiceira");
		//Se não tratarmos temos a exception
		if(conversation.isTransient()) {
			conversation.begin();
			System.out.println("ID= " + conversation.getId());
		}
	}
	
	public String endConversation() {
		System.out.println("Finalizando a sessão");
		if(!conversation.isTransient()) {
			conversation.end();
		}
		return "conversation?faces-redirect=true";
	}
	
	public void selecionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String p= personagens.get(index);
		this.personagemSelecionado.add(p);
	}
	
	public List<String> getPersonagens() {
		return personagens;
	}
	public void setPersonagens(List<String> personagens) {
		this.personagens = personagens;
	}
	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}
	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
	

}
