<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,
				br.com.base.dao.*,
				br.com.base.modelo.*"
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	   String msg = "Bem vindo!";
	   out.println(msg);
	   System.out.println("Tudo foi devidamente executado!");
	%>
	<table>
	<%-- Exemplo de listagem de contatos com Scriptlets --%>
	<%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.busca();
		
		for(Contato contato : contatos){
			%>
				<tr>
					<td><%=contato.getNome() %><td>
					<td><%=contato.getEmail() %><td>
					<td><%=contato.getEndereco() %><td>
					<td><%=contato.getDataNasc().getTime() %><td>
				</tr>
			<%
		}
	%>
	</table>
	<br><a href="index.html">Voltar � homepage.</a>
</body>
</html>