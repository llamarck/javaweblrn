package br.com.base.teste;

import br.com.base.dao.ContatoDao;

public class TestaRemove {

	public static void main(String[] args){
		ContatoDao dao = new ContatoDao();
		dao.remove(3);
		
		System.out.println("Contato removido!");
	}

}
