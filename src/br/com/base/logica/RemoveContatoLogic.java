package br.com.base.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class RemoveContatoLogic implements ILogica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		Connection connection = (Connection) req.getAttribute("connection");
		/*testando agora com a conex�o 'pendurada' pelos filtros, onde, atrav�s 
		 * da inje��o de depend�ncia e invers�o de controle, o objeto connection 
		 * � passado (a depend�ncia � injetada na classe j� pronta, invertendo o controle) 
		 */
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao dao = new ContatoDao();
		dao.remove(id);
		System.out.println("Excluindo contato...");
		
		//return "lista-contatos.jsp";
		//acima � a chamada direta do JSP
		return "mvc?logica=ListaLogic";
		//aqui est� chamando a L�GICA que ent�o redireciona pro JSP correto
	}

}
