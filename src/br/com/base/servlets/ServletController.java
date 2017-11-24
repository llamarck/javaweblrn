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
		//diz qual o nome da lógica/classe que possui o executa/servlet que deseja chamar pra realizar a ação
		String nomeDaClasse = "br.com.base.logica." + parametro;
		//estabeleço parâmetros para o nome da classe através desta concatenação de strings que me leva ao endereço da classe inteira (incluindo o package)
		
		try{
			Class<?> classe = Class.forName(nomeDaClasse);
			//atribuo uma classe mais geral para usar de referência na hora de instanciar "na ignorância", de forma mais forçosa e primitiva
			ILogica logica = (ILogica) classe.newInstance();
			//minha interface nova (oriunda de ILogica) recebe a instância da classe alcançada lá em cima
			//isto só é possível porque a classe (a da lógica de negócio) implementa/é do mesmo tipo que a interface, então seria
			//equivalente a um simples public class Animal : IAnimal - que é uma forma apenas de tratar a instância
			String pagina = logica.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
		}catch(Exception e){
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}

}
