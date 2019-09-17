package br.com.maratonajsf.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maratonajsf.controller.LoginBean;


public class FilterLogin implements Filter{

	//inject aquela instancia aqui
	@Inject
	private LoginBean loginBean;
	
	@Override
	public void destroy() {
	}

	//é executado a cada navigation in system
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		
		String url = req.getRequestURL().toString();
		//se minha url contiver a pasta privada e user não logou
		if((url.contains("/restricted")) && (loginBean.getEstudante() == null)) {
			//redirecione p página de login
			res.sendRedirect(req.getServletContext().getContextPath()+ "/login.xhtml");
		}else {
			System.out.println("Else");
			//acesso a qualquer outra pasta não privada
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//iniciado quando o sistema sobe
	}

}
