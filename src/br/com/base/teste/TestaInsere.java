package br.com.base.teste;

import java.util.Calendar;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		//instancia um contato;
		
		contato.setNome("Meuteste");
		contato.setEmail("lamarck.ti@ifpe.com");
		contato.setEndereco("Av. Eraldo Barros de Souza, 1196");
		contato.setDataNasc(Calendar.getInstance());
		//seta os valores para as variáveis
		
		ContatoDao dao = new ContatoDao();
		//instancia um dao;
		
		dao.adiciona(contato);
		//insere o dao
		
		System.out.println("Contato gravado!");
	}

}
