package br.com.maratonajsf.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@ViewScoped
public class UploadBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Part file;
	
	public void upload() {
		if(this.file != null) {
			try(InputStream is= file.getInputStream()){
				String fileName = file.getSubmittedFileName();
				System.out.println("Nome file: "+file.getSubmittedFileName());
				System.out.println("ID do componente: "+file.getName());
				System.out.println(file.getContentType());
				System.out.println("Bytes: "+file.getSize());
				
				//Salvando o file
				Files.copy(is,new File("C:\\Users\\dougl\\Desktop", fileName).toPath());
				
				FacesMessage message= new FacesMessage(FacesMessage.SEVERITY_INFO, "File salvo com sucesso!","");
				FacesContext.getCurrentInstance().addMessage(null, message);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}

}
