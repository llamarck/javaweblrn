package br.com.base.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a lógica...");
		System.out.println("Retornando o nome da página JSP...");
		return "primeira-logica.jsp";
	}

}
