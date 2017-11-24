package br.com.base.logica;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class EfetuaAlteracaoLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Contato contato = new Contato();
		contato.setId(Integer.parseInt((req.getParameter("id"))));
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setDataNasc(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.altera(contato);
		System.out.println("O contato " + contato.getNome() + " está sendo alterado...");
		
		return "mvc?logica=ListaLogic";
	}

}
