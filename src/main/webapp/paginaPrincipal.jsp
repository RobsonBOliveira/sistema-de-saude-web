<%@ page import="DAO.LoginDAO" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="Style/paginaPrincipal.css">
  <title>Página Principal</title>
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>

<div class="cabecalho">
  <%
    LoginDAO logindao = new LoginDAO("sistemasaude", usuario, senha);
      String nome = logindao.select_name(usuario);
  %>
  <h2>Bem-Vindo, Dr. <%=nome%></h2>
</div>


<div class="buttons">
  <div class="flex">
    <div class="button-agendar">
      <a href="cadastrarConsulta.html">
        <input type="button" value="Agendar consulta">
      </a>
    </div>

    <div class="button-gerenciar">
      <a href="listarConsultas.jsp">
        <input type="button" value="Gerenciar consultas">
      </a>
    </div>

    <div class="button-requisitar">
      <a href="cadastrarExame.html">
        <input type="button" value="Requisitar Exame">
      </a>
    </div>

    <div class="button-pacientes">
      <a href="listarPacientes.jsp">
        <input type="button" value="Ficha de pacientes">
      </a>
    </div>

    <div class="button-alterar">
      <a href="teste.html">
        <input type="button" value="Alterar exames">
      </a>
    </div>
  </div>
</div>

</body>