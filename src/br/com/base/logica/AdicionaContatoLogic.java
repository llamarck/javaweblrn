package br.com.base.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaContatoLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {		
		return "/WEB-INF/JSP-HTML/adiciona-contato.jsp";
	}

}
