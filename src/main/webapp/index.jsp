<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br" xmlns:br="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="index.css">

    <title>Login de Usuários</title>
</head>
<body>
<div class="header">
  <h1>Hospital Figma balls</h1>
</div>
<div class="main">
  <div class="form">
    <form action="loginUsuario" method="post">
        <h3>Usuário<br></h3>
        <input type="text" name="login"> <br>
        <h3>Senha<br></h3>
        <input type="password" name="senha"> <br>
      <div class="buttonConect">
        <input type="submit" value="Conectar">
      </div>
    </form>
  </div>
  <div class="button">
    <a href="cadastrarUsuario.html"><input type="button" value="Cadastrar Novo Usuário"></a>
  </div>
</div>
</body>
</html>
