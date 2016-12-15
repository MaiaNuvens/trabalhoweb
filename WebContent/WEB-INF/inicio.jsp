<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página Inicial</title>
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
	
	tr:nth-child(odd) {
	    background-color: #dddddd;
	}
</style>
</head>
<body>

	<h2>Bem Vindo :) !!</h2>
	
	<h2>------Logar------</h2>
	<form action="login" method="post">
	<table>
	     <tr>
	     <td>Login:</td>
	     <td><input type="text" name="login" /></td>
	     </tr>
	     <tr>
	     <td>Senha:<td>
	     <input type="password" name="senha" />
	     </tr>
	</table>
	<input type="submit" value="OK">
    </form>
	
	<h2>------Cadastre-se------</h2>
	<form action="cadastrarUsuario" method="post">
	<table>
	       <tr>
	       <td>Nome:</td>
	       <td> <input type="text" name="nome" /></td>
	       </tr>
	       <tr>
	       <td>Email:</td>
	       <td><input type="text" name="email" /></td>
	       </tr>
	       <tr>
	       <td>Login:</td>
	       <td><input type="text" name="login" /></td>
	       </tr>
	       <tr> 
	       <td>Senha:</td>
	       <td><input type="password" name="senha" /></td>
	       </tr>
	       <tr>
	       <td>Idade:</td> 
	       <td><input type="text" name="idade" /></td>
	       </tr>
	</table>
	<input type="submit" value="OK">
    </form>
    
</body>
</html>