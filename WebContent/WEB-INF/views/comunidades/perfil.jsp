<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
	    font-family: arial, sans-serif;
	    border-collapse: collapse;
	    width: 50%;
	}
	
	td, th {
	    border: 1px solid white;
	    text-align: left;
	    padding: 5px;
	}
	
	tr:nth-child(even) {
	    background-color: #dddddd;
	}
	tr:nth-child(odd) {
	    background-color: #dddddd;
	}
</style>
</head>
<body>

<c:import url="cabecalho.jsp" /> <br>
<h2>Comunidade - ${comunidade.nome}</h2> <c:if test="${pertence == false}">
			                                <a href = "adicionarUsuario?id=${comunidade.comId}"> Entrar </a>
			                             </c:if>

<br>
<h2>Participantes:</h2> 
        <table>
		<c:forEach var="usuario" items="${usuarios}">
		     <tr>
			 <td><a href = "mostrarPerfil?id=${usuario.usuId}">${usuario.nome}</a></td>
	         </tr>
		</c:forEach>
        </table>

<h2>Foruns:</h2> 
        <table>
		<c:forEach var="forum" items="${foruns}">
		    <tr>
			 <td><a href = "mostrarPerfilForum?id=${forum.forId}">${forum.titulo}</a></td>
			</tr>   
		</c:forEach>
       </table>
<br>
Criar forum : <br>
<form action="cadastrarForum?id=${comunidade.comId}" method="post">     <!-- colocar comunidade -->
              <table>
                     <tr>
                     <td>Titulo:</td>
                     <td><input type="text" name="titulo" /></td>
                     </tr>
                     <tr>
                     <td>Descricao:</td>
                     <td><input type="text" name="descricao" /></td>
                    </tr>
              </table>
              <input type="submit" value="OK">
</form>

<br>
<a href="listarComunidades">Voltar para comunidades</a><br />


</body>
</html>