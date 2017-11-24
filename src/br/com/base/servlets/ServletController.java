package br.com.base.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.logica.ILogica;

@WebServlet("/mvc")
public class ServletController extends HttpServlet implements ILogica {
	private static final long serialVersionUID = 1L;
       
    public ServletController() {
        super();
    }

    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception { 
			return null;
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		//diz qual o nome da l�gica/classe que possui o executa/servlet que deseja chamar pra realizar a a��o
		String nomeDaClasse = "br.com.base.logica." + parametro;
		//estabele�o par�metros para o nome da classe atrav�s desta concatena��o de strings que me leva ao endere�o da classe inteira (incluindo o package)
		
		try{
			Class<?> classe = Class.forName(nomeDaClasse);
			//atribuo uma classe mais geral para usar de refer�ncia na hora de instanciar "na ignor�ncia", de forma mais for�osa e primitiva
			ILogica logica = (ILogica) classe.newInstance();
			//minha interface nova (oriunda de ILogica) recebe a inst�ncia da classe alcan�ada l� em cima
			//isto s� � poss�vel porque a classe (a da l�gica de neg�cio) implementa/� do mesmo tipo que a interface, ent�o seria
			//equivalente a um simples public class Animal : IAnimal - que � uma forma apenas de tratar a inst�ncia
			String pagina = logica.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
		}catch(Exception e){
			throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
		}
	}

}
