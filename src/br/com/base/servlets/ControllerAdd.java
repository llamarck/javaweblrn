package br.com.base.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

@WebServlet("/ControllerAdd")
public class ControllerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerAdd() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		try{
			Date date = new SimpleDateFormat("DD/MM/YYYY").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		}catch(ParseException e){
			out.println("Erro ao converter a data.");
		}
		
		Contato contato = new Contato();
		
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNasc(dataNascimento);
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		out.println("<html>");
		out.println("<body>");
		out.println("As informações de " + contato.getNome() + " foram adicionadas! Clique <a href='index.html'>aqui</a> para voltar à home!");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
