package br.com.base.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.base.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {


    public FiltroConexao() {

    }


	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		Connection connection = new ConnectionFactory().getConnection();
		
		//"pendura" um objeto no Request com a Wildcard em questão - lembrar de Injeção de Dependência e Inversão de Controle
		request.setAttribute("connection", connection);
		//acima, estou passando pelo setAttribute algo (conexão, no caso) para ser acessível de qualquer lugar, uma vez que tudo passará por este filtro - o que está acontecendo é, na verdade, a disponibilidade generalizada de uma abertura de conexão para quem precisar
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
