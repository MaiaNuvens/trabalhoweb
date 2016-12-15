<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="cadastrarComunidade" method="post">
	Nome: <input type="text" name="nome" /> <br />
	Categoria: <select name = "cat"> 
	           <c:forEach var="categoria" items="${categorias}">
		       <option value = "${categoria.catId}">${categoria.nome}</option>
		       </c:forEach>
	
	</select>
	<input type="submit" value="OK">
    </form>

</body>
</html>