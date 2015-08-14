<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Estado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>NOME</th>
		</tr>
	
	
<%
//Acessando a Lista de Estados
List<Estado> lista = (List<Estado>)request.getAttribute("listaest");

for (Estado e: lista){
	out.print("<tr>  <td> "+ e.getId() + " </td> <td> "+ e.getNome() + "</td></tr>");
}
%>	

</table>
</body>
</html>