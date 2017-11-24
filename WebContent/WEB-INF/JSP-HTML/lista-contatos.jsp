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
	<table>
		<c:forEach var="contato" items="${contatos}"> <!-- Aqui � onde rola a m�gica: o contatos passado como setAttribute na l�gica � chamado -->
			<tr>
				<td>${contato.nome}</td>
				<c:if test="${not empty contato.email}">
					<td><a href="mailto:${contato.email}">${contato.email}</a></td>
				</c:if>
				<td>${contato.endereco}</td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
				<td><a href="mvc?logica=AlteraContatoLogic&id=${contato.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<h3><a href="mvc?logica=AdicionaContatoLogic">Inserir um novo Contato</a></h3>
	<h3><a href="index.html">Voltar � homepage</a>.</h3>
</body>
</html>