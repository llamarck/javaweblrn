package br.com.base.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.base.jdbc.ConnectionFactory;
import br.com.base.modelo.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		String sql = "INSERT INTO contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNasc().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato){
		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNasc().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getBusca(){
		String sql = "SELECT * FROM contatos";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			//prepara o statement
			ResultSet rs = stmt.executeQuery();
			//instancia um Result Set e executa a query
			List<Contato> contatos = new ArrayList<Contato>();
			//instancia uma Lista do tipo Contato
			while(rs.next()){
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				//enquanto houver conteúdo no Result Set, vai preenchendo na lista
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNasc(data);
				contatos.add(contato);
				//depois que todos os campos de contato forem preenchidos, adiciona na Lista
			}
		rs.close();
		stmt.close();
		//fecha Result Set e o Statement
		return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> busca(){
		String sql = "SELECT * FROM contatos";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			//prepara o statement
			ResultSet rs = stmt.executeQuery();
			//instancia um Result Set e executa a query
			List<Contato> contatos = new ArrayList<Contato>();
			//instancia uma Lista do tipo Contatos
			while(rs.next()){
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				//enquanto houver conteúdo no Result Set, vai preenchendo na lista
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNasc(data);
				contatos.add(contato);
				//depois que todos os campos de contato forem preenchidos, adiciona na Lista
			}
		rs.close();
		stmt.close();
		//fecha Result Set e o Statement
		return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Contato busca(int id){
		String sql = "SELECT * FROM contatos WHERE id = ?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Contato contato = new Contato();
			while(rs.next()){
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNasc(data);
			}
			stmt.close();
			rs.close();
			return contato;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> busca(String key){
		String sql = "SELECT * FROM contatos WHERE nome LIKE ?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, key);
			ResultSet rs = stmt.executeQuery();
			List<Contato> contatos = new ArrayList<Contato>();
			while(rs.next()){
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contatos.add(contato);
			}
			
			stmt.close();
			rs.close();
			return contatos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(long id){
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
