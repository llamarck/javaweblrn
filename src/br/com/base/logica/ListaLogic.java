package br.com.base.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class ListaLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<Contato> contatos = new ContatoDao().getBusca();
		//Monta a lista (evitando que um objeto do tipo model seja instanciado lá na View com JSP useBeans)
		
		req.setAttribute("contatos", contatos);
		//Guarda a lista no request
		//setAttribute nada mais é do que o armazenamento de algo ("nome", objeto) para ser chamado em EL ou JSTL;

		return "/WEB-INF/JSP-HTML/lista-contatos.jsp";
	}

}
