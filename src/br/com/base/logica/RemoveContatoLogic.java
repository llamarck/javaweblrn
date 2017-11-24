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
		/*testando agora com a conexão 'pendurada' pelos filtros, onde, através 
		 * da injeção de dependência e inversão de controle, o objeto connection 
		 * é passado (a dependência é injetada na classe já pronta, invertendo o controle) 
		 */
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao dao = new ContatoDao();
		dao.remove(id);
		System.out.println("Excluindo contato...");
		
		//return "lista-contatos.jsp";
		//acima é a chamada direta do JSP
		return "mvc?logica=ListaLogic";
		//aqui está chamando a LÓGICA que então redireciona pro JSP correto
	}

}
