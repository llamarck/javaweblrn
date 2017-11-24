package br.com.base.logica;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class AlteraContatoLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		contato = dao.busca(id);
		req.setAttribute("contatoAltera", contato);
		
		System.out.println("Redirecionando p�gina para edi��o de " + contato.getNome());
		
		//essa l�gica vai redirecionar para um JSP com as informa��es atuais em um campo
		//esse JSP vai chamar outra l�gica que insere no banco e redireciona pra outro JSP
		
		return "/WEB-INF/JSP-HTML/altera.jsp";
	}

}