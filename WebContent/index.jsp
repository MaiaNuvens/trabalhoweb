<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página Inicial</title>
</head>
<body>

	<h2>Bem Vindo :) !!</h2>
	
	<h2>------Logar------</h2>
	<form action="login" method="post">
	Login: <input type="text" name="login" /> <br />
	Senha: <input type="text" name="senha" /> <br />
	<input type="submit" value="OK">
    </form>
	
	<h2>------Cadastre-se------</h2>
	<form action="cadastrarUsuario" method="post">
	Nome: <input type="text" name="nome" /> <br />
	Email: <input type="text" name="email" /> <br />
	Login: <input type="text" name="login" /> <br />
	Senha: <input type="text" name="senha" /> <br />
	Idade: <input type="text" name="idade" /> <br />
	<input type="submit" value="OK">
    </form>
    
</body>
</html>