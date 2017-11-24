package br.com.base.teste;

import java.util.List;

import br.com.base.dao.ContatoDao;
import br.com.base.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		//String k = "anda";
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.busca(/*k*/);
		for (Contato contato : contatos){		
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + contato.getDataNasc().getTime());
		}
		
		//teste de listagem e filtragem (tirando os comentários)
		
		int a = 2;
		Contato contato = dao.busca(a);
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());
		
		//teste de busca específica (por id)
		
	}

}
