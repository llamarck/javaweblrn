package br.com.base.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ILogica {
	String executa (HttpServletRequest req, HttpServletResponse res) throws Exception;	
}