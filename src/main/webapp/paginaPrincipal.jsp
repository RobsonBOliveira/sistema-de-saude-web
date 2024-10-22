<%@ page import="DAO.LoginDAO" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="Style/paginaPrincipal.css">
  <link rel="stylesheet" href="Style/style.css">

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
      <a href="listarExames.jsp">
        <input type="button" value="Alterar exames">
      </a>
    </div>
    <%
      if(Objects.equals(usuario, "admin") && Objects.equals(senha, "admin")){
      %>
    <div class="button-gerenciar-medicos">
      <a href="listarMedicos.jsp">
        <input type="button" value="Gerenciar Médicos">
      </a>
    </div>
      <%}
    %>
  </div>
</div>

<form action="imprimePdf" method="post">

<div class="bottom">
  <a href="listarLog.jsp">
    <input type="button" value="Log">
  </a>
  <input type="submit" value="Comprovante exame">

</div>
</form>
</body>