<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br" xmlns:br="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="Style/index.css">

    <title>Login</title>
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
<div class="main">
  <div class="form">
    <form action="loginUsuario" method="post">
        <h3>Usuário<br></h3>
        <input type="text" name="usuario" placeholder="Usuário"> <br>
        <h3>Senha<br></h3>
        <input type="password" name="senha" placeholder="Senha"> <br>
      <div class="buttonConnect">
        <input class="buttonConnect" type="submit" value="Login">
      </div>
        <a href="cadastrarUsuario.html">Cadastrar Novo Usuário</a>
    </form>
  </div>
</div>
</body>
</html>
