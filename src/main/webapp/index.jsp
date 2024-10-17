<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br" xmlns:br="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="index.css">

    <title>Login de Usuarios</title>
</head>
<body>
<div class="main">
    <h1>Login</h1>
    <form action="loginUsuario" method="post">
        <h3>Usuario<br></h3>
        <input type="text" name="login"> <br>
        <h3>Senha<br></h3>
        <input type="password" name="senha"> <br>
        <input type="submit" value="Conectar">
    </form>
    <a href="cadastrarUsuario.html"><input type="button" value="Cadastrar Novo Usuário"></a>
</div>
</body>
</html>
