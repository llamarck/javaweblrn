package br.com.base.teste;

import java.util.Calendar;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();
		contato.setId(1);
		contato.setNome("Amanda");
		contato.setEmail("amanda.tapir@gmail.com");
		contato.setEndereco("Av. Tapir, 666");
		contato.setDataNasc(Calendar.getInstance());
		dao.altera(contato);
		System.out.println("Contato alterado!");
	}

}
