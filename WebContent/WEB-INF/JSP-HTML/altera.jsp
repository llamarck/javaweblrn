<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Cria o DAO -->
	<!-- <jsp:useBean id="dao" class="br.com.base.dao.ContatoDao" /> -->
	<!-- JSP useBeans s�o extreamente �teis, mas infelizmente n�o s�o uma boa pr�tica dentro do MVC, pois induzem a instanciarmos um Model dentro da View -->
		<form action="mvc?logica=EfetuaAlteracaoLogic" method="POST">
		<label>ID: </label><input name="id" value="${contatoAltera.id}" readonly><br>
		<label>Nome: </label> <input type="text" value="${contatoAltera.nome}" name="nome"><br>
		<label>Email: </label> <input type="text" value="${contatoAltera.email}" name="email"><br>
		<label>Endere�o: </label> <input type="text" value="${contatoAltera.endereco}" name="endereco"><br>
		<input type="submit" value="Submitar altera��o">
		</form>
	<h3><a href="index.html">Voltar � homepage</a>.</h3>
</body>
</html>